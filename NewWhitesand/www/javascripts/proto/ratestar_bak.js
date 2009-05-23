var RateStar = Class.create();
RateStar.prototype = {
	initialize: function(displayin, score, options) {
		this.options = Object.extend({
				fake : true,
				display : true
		    }, options || {})
	
		this.displayin = $(displayin);
		
		if (this.options.fake) {
			score = score == 0 ? 5.0 : score;
		}
		this.score = Math.round(score);

		this.html = '<div class="FiveStar"><ul>';
		
		for(var i = 0; i < 5; i++) {
			var styleClass = "FiveStarOff";
			if (this.score >= (i+1)*2) {
				styleClass = "FiveStarOn";
			}else if (this.score == (i+1)*2 -1) {
				styleClass = "FiveStarHalf";
			}	
			this.html += '<li class="'+ styleClass +'"></li>';		
		}	
		if (this.options.display) {
			this.html += '<li class="TC2 bold">'+ score +'&nbsp;</li>';
		}
		this.html += '</ul></div>';
		
		this.displayin.innerHTML = this.html;
	}
}