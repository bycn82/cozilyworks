var InlinePopup = new function() {
	
	var __overlayId = 'icer-inlinepopup-overlay';
	var __shimId = __overlayId + "-shim";
	var ieVer = parseFloat(navigator.appVersion.substring(navigator.appVersion.indexOf("MSIE ")+5, navigator.appVersion.length));
	var shimmed = ieVer < 7;
	var __overlayIndex = 2008;
	var dialog;
	var ipopup;

	this.init = function() {
		if (!document.getElementsByTagName){ return; }
		
		if (!$(__overlayId)) {
			var overlay = document.createElement('div');
			overlay.setAttribute('id', __overlayId);
			overlay.style.cssText = 'position:absolute; top: 0; left: 0; display: hidden; width: 100%; height: 100%;background-color: #FFF; filter:alpha(opacity=70); -moz-opacity: 0.7; opacity: 0.7; z-index:' + __overlayIndex;
			
			document.body.appendChild(overlay);
			/**
			 * Uses an iframe shim to mask system controls for IE v5.5 or higher as suggested in
			 * see http://dotnetjunkies.com/weblog/jking/posts/488.aspx
			 */
			if (shimmed) {
				var shim = document.createElement('<iframe name="shimFrame" id="' + __shimId + '" src="about:blank" scrolling="no" frameborder="0" style="-moz-opacity:0;filter:alpha(opacity=0);opacity:0;position:absolute; top:0px; left:0px; display:none;"></iframe>');
				shim.style.zIndex = __overlayIndex-1;
				document.body.appendChild(shim);
			}
			
			/* register ESC keypress */
			Event.observe(document, 'keydown', function(e) {
				if (Event.KEY_ESC == e.keyCode /** || Event.KEY_RETURN == e.keyCode **/) {
					this.hide();
				}
			}.bindAsEventListener(this), false);
		}
	};
	
	this.initDialog = function(options) {
		if (!dialog) {
			var msgbox = document.createElement('div');
			Element.addClassName(msgbox, 'icer-ip-msgbox');
			dialog = this.decorate(msgbox, options);
			dialog.msgbox = msgbox;
			
			var nav = document.createElement('div');
			Element.addClassName(nav, 'icer-ip-nav');
			dialog.body.appendChild(nav);
			
			var okBtn = document.createElement('button');
			Element.addClassName(okBtn, 'icer-ip-dialog-ob');
			nav.appendChild(okBtn);
			dialog.okBtn = okBtn;			
	
			var cancelBtn = document.createElement('button');
			Element.addClassName(cancelBtn, 'icer-ip-dialog-cb');			
			nav.appendChild(cancelBtn);
			dialog.cancelBtn = cancelBtn;

			document.body.appendChild(dialog);
		}
	};
	
	this.popupDialog = function(message, options) {
		this.initDialog(options);
		
		var options = Object.extend({
			okButton: 'OK',
			okButtonClass: 'icer-ip-dialog-ob',
			cancelButton: 'Cancel',
			cancelButtonClass: 'icer-ip-dialog-cb',
			type: 'message'
			}, options || {}
		);
		
		dialog.msgbox.innerHTML = message || '';
		var cns = Element.classNames(dialog.msgbox);
		cns.set('icer-ip-msgbox');
		cns.add('icer-ip-msgbox-' + options.type);
	
		Element.addClassName(dialog.okBtn, options.okButtonClass);
		dialog.okBtn.innerHTML = options.okButton;
		dialog.okBtn.onclick = function(){
			InlinePopup.hide();
			if (typeof options.okCallback == 'function')
				options.okCallback();
		};
		if (options.type == 'message' || options.type == 'error') {
			Element.hide(dialog.cancelBtn);
		} else if (options.type == 'confirm') {
			Element.show(dialog.cancelBtn);
			Element.addClassName(dialog.cancelBtn, options.cancelButtonClass);
			dialog.cancelBtn.innerHTML = options.cancelButton;
			dialog.cancelBtn.onclick = function(){
				InlinePopup.hide();
				if (typeof options.cancelCallback == 'function')
					options.cancelCallback();
			};
		}
		
		this.popup(dialog.msgbox, options);
	};

	this.decorate = function(ele, options) {
		var element = $(ele);
		if (!element['__ipopup']) {
			var	ipopup = document.createElement('div');
			ipopup.style.zIndex = __overlayIndex+1;
			ipopup.id = 'icer-ip-' + element.id;
			Element.addClassName(ipopup, 'icer-ip');
			if (options.popupClass)
				Element.addClassName(ipopup, options.popupClass);
			var head = document.createElement('div');
			Element.addClassName(head, 'icer-ip-head');

			var bar = document.createElement('div');
			Element.addClassName(bar, 'icer-ip-bar');

			if (options && options.closeImg)  {
				bar.innerHTML = options.closeImg;
				Event.observe(bar.getElementsByTagName('img')[0], 'click', function() {this.hide();}.bindAsEventListener(this), false);
			}

			var body = document.createElement('div');
			ipopup.body = body;
			body.id = 'icer-ip-' + element.id + '-body';
			Element.addClassName(body, 'icer-ip-body');
			var foot = document.createElement('div');
			Element.addClassName(foot, 'icer-ip-foot');
			head.appendChild(bar);
			ipopup.appendChild(head);
			ipopup.appendChild(body);
			ipopup.appendChild(foot);
			document.body.appendChild(ipopup);
			body.appendChild(element);
			element['__ipopup'] = ipopup;
		}
		return element['__ipopup'];
	}

	this.popup = function(ele, options) {
		var options = Object.extend(
			{width: 500}, 
			options||{}
		);
		if (ipopup && Element.visible(ipopup))
			this.hide();		
		ipopup = this.decorate(ele, options);

		var ps = getPageSize();
		var st, sl;  //scrollTop & scrollLeft
		var l, t;
		
		if (document.documentElement) { // Explorer 6 Strict Mode
			st = document.documentElement.scrollTop;
			sl = document.documentElement.scrollLeft;
		} else if (document.body) { // other Explorers
			st = document.body.scrollTop;
			sl = document.body.scrollLeft;
		}	
		
		$(ele).style.display = 'block';
		ipopup.style.width = options.width + 'px';
		var dim = Element.getDimensions(ipopup);

		if (options.left)
			l = options.left;
		else if (options.right)
			l = screen.availWidth - options.right - dim.width;
		else 
			l = (ps[2] < dim.width)? 0 : (ps[2]-dim.width)/2 + sl;

		if (options.top)
			t = options.top;
		else
			t = (ps[3] < dim.height)? 0 : (ps[3]-dim.height)/2 + st;
	
		ipopup.style.left = l + 'px';
		ipopup.style.top = t + 'px';
		ipopup.style.position = 'absolute';
		ipopup.style.display = 'block';
		
		if (options.onPopup) {
			options.onPopup.apply($(ele));
		}
		this.show();
		this.rounded();		
	};

	this.rounded = function() {
		if (!ipopup['__rounded']) {
			if (window.Nifty) {
				Nifty('div#'+ipopup.id, 'transparent');
				Nifty('div#'+ipopup.id+'-body', 'transparent');
				$$('div#' + ipopup.id + ' b.niftycorners b').each(
					function(b) {b.style.borderColor = '#FFF';}
				);				
			}
			ipopup['__rounded'] = true;
		}
	};

	this.show = function() {
		if (!$(__overlayId))
			this.init();
			
		var ps = getPageSize();
		with ($(__overlayId).style) {
			height = ps[1]+"px";
			display = "block";
		}

		if (shimmed) {
			with ($(__shimId).style) {
				width = ps[0] + "px";
				height = ps[1] + "px";
				display = "block";
			}
		}
	};

	this.hide = function() {
		Element.hide(ipopup);
		Element.hide($(__overlayId));
		if (shimmed)
			Element.hide($(__shimId));
	};

	var getPageSize = function() {
		var xScroll, yScroll;
		if (window.innerHeight && window.scrollMaxY) {	
			xScroll = document.body.scrollWidth;
			yScroll = window.innerHeight + window.scrollMaxY;
		} else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
			xScroll = document.body.scrollWidth;
			yScroll = document.body.scrollHeight;
		} else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
			xScroll = document.body.offsetWidth;
			yScroll = document.body.offsetHeight;
		}
		var windowWidth, windowHeight;
		if (self.innerHeight) {	// all except Explorer
			windowWidth = self.innerWidth;
			windowHeight = self.innerHeight;
		} else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode
			windowWidth = document.documentElement.clientWidth;
			windowHeight = document.documentElement.clientHeight;
		} else if (document.body) { // other Explorers
			windowWidth = document.body.clientWidth;
			windowHeight = document.body.clientHeight;
		}	
		// for small pages with total height less then height of the viewport
		if(yScroll < windowHeight){
			pageHeight = windowHeight;
		} else { 
			pageHeight = yScroll;
		}
		// for small pages with total width less then width of the viewport
		if(xScroll < windowWidth){	
			pageWidth = windowWidth;
		} else {
			pageWidth = xScroll;
		}
		return [pageWidth,pageHeight,windowWidth,windowHeight];
	}
};
