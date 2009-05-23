/*
 * Really easy field validation with Prototype
 * http://tetlaw.id.au/view/blog/really-easy-field-validation-with-prototype
 * Andrew Tetlaw
 * Version 1.2.1 (2006-05-02)
 * Thanks Mike Rumble http://www.mikerumble.co.uk/ for onblur idea!
 * http://creativecommons.org/licenses/by-sa/2.5/
 */
Validator = Class.create();

Validator.prototype = {
	initialize : function(className, error, test) {
		this.test = test ? test : function(){ return true };
		this.error = error ? error : 'Validation failed.';
		this.className = className;
	}
}

var Validation = Class.create();

Validation.prototype = {
	initialize : function(form, options){
		this.options = Object.extend({
			stopOnFirst : false,
			immediate : false
		}, options || {});
		this.form = $(form);
		Event.observe(this.form,'submit',this.onSubmit.bind(this),false);
		if(this.options.immediate) {
			Form.getElements(this.form).each(function(input) { // Thanks Mike!
				Event.observe(input, 'blur', function(ev) { Validation.validate(Event.element(ev)) });
			});
		}
	},
	onSubmit :  function(ev){
		if(!this.validate())  {
			Event.stop(ev);
		}else if (this.options.afterValidHook){ // Added by Ivan Shi for post-validation hook
			this.options.afterValidHook.call(this.form,ev);
		}
	},
	validate : function() {
		if(this.options.stopOnFirst) {
			return Form.getElements(this.form).all(Validation.validate);
		} else {
			return Form.getElements(this.form).collect(Validation.validate).all();
		}
	}
}

Object.extend(Validation, {
	validate : function(elm, index, options){ // index is here only because we use this function in Enumerations
		var options = Object.extend({}, options || {}); // options still under development and here as a placeholder only
		elm = $(elm);
		var cn = elm.classNames();
		return result = cn.all(Validation.test.bind(elm));
	},
	test : function(name) {
		var v = Validation.get(name);
		var id = 'advice-' + name + '-' + this.id;
		var prop = '__advice'+name;
		if(Validation.isVisible(this) && !v.test($F(this), this)) {
			var advice = $(id);
			if(!advice) {
				advice = document.createElement('div');
				advice.appendChild(document.createTextNode(v.error));
				advice.className = 'validation-advice';
				advice.id = id;
				advice.style.display = 'none';
				this.parentNode.insertBefore(advice, this.nextSibling);
			}
			Validation.advise(this, advice);
			//this[prop] = true;
			this.removeClassName('validation-passed');
			this.addClassName('validation-failed');
			return false;
		} else {
			if ($(id))
				$(id).remove();
			this.onkeyup = null;
			//this[prop] = '';
			this.removeClassName('validation-failed');
			this.addClassName('validation-passed');
			return true;
		}
	},
	isVisible : function(elm) {
		while(elm.tagName != 'BODY') {
			if(!$(elm).visible()) return false;
			elm = elm.parentNode;
		}
		return true;
	},
	add : function(className, error, test, options) {
		var nv = {};
		nv[className] = new Validator(className, error, test, options);
		Object.extend(Validation.methods, nv);
	},
	addAllThese : function(validators) {
		var nv = {};
		$A(validators).each(function(value) {
				nv[value[0]] = new Validator(value[0], value[1], value[2]);
			});
		Object.extend(Validation.methods, nv);
	},
	get : function(name) {
		return  Validation.methods[name] ? Validation.methods[name] : new Validator();
	},
	methods : {},
	
	/* add by zhaozexin@icer.com.cn */
	fireSubmit: function(form) {
		var form = $(form);
		if (form.fireEvent) { //for ie
			if(form.fireEvent('onsubmit'))
				form.submit();
		} else if (document.createEvent) {
			var evt = document.createEvent("HTMLEvents");
			evt.initEvent('submit', false, true); //true for can bubble, true for cancelable
			form.dispatchEvent(evt);
		}
	},
	
	advise : function(element, advice) {
		if(typeof Effect == 'undefined') {
			advice.style.display = 'block';
		} else {
			new Effect.Appear(advice.id, {duration : 0.5 });
		}
	}
});

//var $V = Validation.validate;
//var $VG = Validation.get;
//var $VA = Validation.add;

Validation.add('IsEmpty', '', function(v) {
				return  ((v == null) || (v.length == 0) || /^\s+$/.test(v));
			});

Validation.addAllThese([
	['required', 'This is a required field.', function(v) {
				return !Validation.get('IsEmpty').test(v);
			}],
	['validate-number', 'Please use numbers only in this field.', function(v) {
				return Validation.get('IsEmpty').test(v) || !isNaN(v);
			}],
	['validate-digits', 'Please use numbers only in this field.', function(v) {
				return Validation.get('IsEmpty').test(v) ||  !/[^\d]/.test(v);
			}],
	['validate-alpha', 'Please use letters only (a-z) in this field.', function (v) {
				return Validation.get('IsEmpty').test(v) ||  /^[a-zA-Z]+$/.test(v)
			}],
	['validate-alphanum', 'Please use only letters (a-z) or numbers (0-9) only in this field. No spaces or other characters are allowed.', function(v) {
				return Validation.get('IsEmpty').test(v) ||  !/\W/.test(v)
			}],
	['validate-date', 'Please enter a valid date.', function(v) {
				var test = new Date(v);
				return Validation.get('IsEmpty').test(v) || !isNaN(test);
			}],
	['validate-email', 'Please enter a valid email address.', function (v) {
				return Validation.get('IsEmpty').test(v) || /\w{1,}[@][\w\-]{1,}([.]([\w\-]{1,})){1,3}$/.test(v)
			}],
	['validate-date-au', 'Please use this date format: dd/mm/yyyy. For example 17/03/2006 for the 17th of March, 2006.', function(v) {
				if(!Validation.get('IsEmpty').test(v)) {
					var upper = 31;
					if(/^(\d{2})\/(\d{2})\/(\d{4})$/.test(v)) { // dd/mm/yyy
						if(RegExp.$2 == '02') upper = 29;
						if((RegExp.$1 <= upper) && (RegExp.$2 <= 12)) {
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return true;
				}
			}],
	['validate-currency-dollar', 'Please enter a valid $ amount. For example $100.00 .', function(v) {
				// [$]1[##][,###]+[.##]
				// [$]1###+[.##]
				// [$]0.##
				// [$].##
				return Validation.get('IsEmpty').test(v) ||  /^\$?\-?([1-9]{1}[0-9]{0,2}(\,[0-9]{3})*(\.[0-9]{0,2})?|[1-9]{1}\d*(\.[0-9]{0,2})?|0(\.[0-9]{0,2})?|(\.[0-9]{1,2})?)$/.test(v)
			}]
]);

/** add by zhaozexin@icer.com.cn */

Validation.add('validate-regexp', 'Please enter a valid value', function(v) {
	return Validation.get('IsEmpty').test(v) || arguments.callee._pattern.test(v);
});
	
Validation.add('validate-url', 'Please enter a valid url', function(v) {
	return Validation.get('IsEmpty').test(v) || /(http|https):\/\/[a-zA-Z0-9\.]*/.test(v);
});
		
var defaultAdvise = Validation.advise;
Validation.advise = function(element, advice) {
	//var pos = Position.page($(element)); 
	var pos = Position.positionedOffset($(element));
	advice.style.position = 'absolute';
	var ah = parseInt(Element.getStyle(advice, 'height'));
	var aw = parseInt(Element.getStyle(element, 'width')) * 2/ 3 ;
	
	if (isNaN(aw)) {
		aw = 0;
	}
	
	advice.style.top = (pos[1]-ah) + 'px';
	advice.style.left = (pos[0] + aw) + 'px';
	if (element.type == 'radio' || element.type == 'checkbox') {
		element.onchange = function() { Element.hide(advice); };
	} else {
		element.onkeyup = function() { Element.hide(advice); };
	}

	defaultAdvise(element, advice);
}
