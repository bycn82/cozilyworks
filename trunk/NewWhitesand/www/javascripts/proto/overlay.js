if (!window.ICER) 
	var ICER = {};
	
ICER.TextOverlay = Class.create();
ICER.TextOverlay.prototype = {
	initialize: function(element, options) {
		this.element = $(element);
		this.element.addClassName('icer-to-ellipsis');
		this._scrollable = this.element.scrollWidth > this.element.offsetWidth;
		if (this._scrollable) {
			Event.observe(this.element, 'mouseover', 
				function(){
					this.element.style.cursor = "w-resize";
					this._triggerTimeoutHandler = setTimeout(this.scroll.bind(this), 500);
				}.bind(this), 
				false);
			Event.observe(this.element, 'mouseout', this.reset.bind(this), false);
		}
		
		this._triggerTimeoutHandler = null;
		this._scrollTimeoutHandler = null;
	},
	scroll: function() {
		this.element.scrollLeft = 0;
		this.element.removeClassName('icer-to-ellipsis');
		this.element.addClassName('icer-to-clip');
		clearInterval(this._scrollTimeoutHandler);
		this._scrollTimeoutHandler = setInterval(this._scroll.bind(this), 15);
	},
	reset: function() {
		this.element.scrollLeft = 0;
		this.element.removeClassName('icer-to-clip');
		this.element.addClassName('icer-to-ellipsis');
		this.element.style.cursor = "text";
		clearTimeout(this._triggerTimeoutHandler);
		clearInterval(this._scrollTimeoutHandler);
	},
	_scroll: function() {
		if (this.element._scrollLeft == this.element.scrollLeft) {
			clearInterval(this._scrollTimeoutHandler);
			this.element._scrollLeft = -1;
			//setTimeout(this.reset.bind(this), 2000);
		} else {
			this.element._scrollLeft = this.element.scrollLeft++;
		}
	}
}
