/*  CozyValidator JavaScript Object
 *  william von vian (cozly@hotmail.com) 2007-07-22
 *
 *  it's very easy to use this lib, obly need to create a object and 
 *  e.g:
 *  there's a form has it's id exampleForm   
 *  so create a CozyValidator Object just like this 
 *  <script>new CozyValidator("exampleForm");</script>
 *	also need to add a key to the input's class whitch you wanna validate
 *  e.g: <input type="text" name="userName" class="colorful required" />
 *  the class named reqired is just for my validator 
/*--------------------------------------------------------------------------*/


var CozyValidator=Class.create();
CozyValidator.prototype={
	initialize:function(form,options){
		this.options=Object.extend({
			stop1st:false,
			immediate:false
		},options||{});
		this.form=$(form);
		Event.observe(this.form,'submit',this.onSubmit.bind(this),false)
		Form.getElements(this.form).each(function(input) { 
				Event.observe(input, 'blur', function(event) { document.body.removeChild($("CozlyAdvisor"));});
			});;
	},
	onSubmit:function(event){
		this.saved={};
		this.canSave=true;
		this.light="green";
		var inputs=Form.getElements(this.form);
		for(var i=0;i<inputs.length;i++)
			this.validate(inputs[i]);
		if(this.light!="green"){
			Event.stop(event);
			this.advise(this.saved.key,this.saved.input);
		}
	},
	validate:function(input){
		var keys=input.className.split(" ");
		for(var i=0;i<keys.length;i++){
			var key=this.trim(keys[i]);
			if(key!="")
				this.test(key,input);
		}
	},	
	test:function(key,input){
		var v=input.value;
		switch(key){
			case "required":
				if(""==this.trim(v)){
					this.light="red";
					this.savePoint(key,input);
				}
			break;
			case "number":
				if(/[^\d]/.test(v) || ""==v){
					this.light="red";
					this.savePoint(key,input);
				}
			break;
			case "email":
				if(!/\w{1,}[@][\w\-]{1,}([.]([\w\-]{1,})){1,3}$/.test(v) ||""==v){
					this.light="red";
					this.savePoint(key,input);
				}
			break;
			case "len>5":
				if(""==v || v.length<=5){
					this.light="red";
					this.savePoint(key,input);
				}
			break;
			case "len<250":
				if(""==v || v.length>250){
					this.light="red";
					this.savePoint(key,input);
				}
		}
	},
	trim:function(str) {
	  return str.replace( /\s+$/g, "" );// strip trailing	
	},
	savePoint:function(key,input){
		if(this.canSave){
			this.saved.key=key;
			this.saved.input=input;
			this.canSave=false;
		}
	},
	advise:function(key,ele){
		var div=document.createElement("div");
		document.body.appendChild(div);
		div.id="CozlyAdvisor";
		div.innerHTML=this.getHint(key);
		//div.style.width="500";
		div.style.backgroundColor="#FF0000";
		var pos = Position.positionedOffset(ele);
		//var ww=parseInt(Element.getStyle(ele, "width"));
		div.style.position = 'absolute';
		div.style.top=pos[1]+"px";
		div.style.left=pos[0]+"px";
		
	},
	getHint:function(key){
		switch(key){
			case "required":
				return "Can not be empty!";
			case "number":
				return "Only can input numbers!";
			case "email":
				return "Enter an email please!";
			case "len>5":
				return "check the size please!";
		}
	}
}

	
