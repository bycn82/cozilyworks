var RateStar = Class.create();
RateStar.prototype = {
	initialize: function(displayin, score, ratecount, options) {
		this.options = Object.extend({
				fake : true,
				display : true
		    }, options || {})
	
		this.displayin = $(displayin);
		
		if (this.options.fake) {
			score = score == 0 ? 5.0 : score;
		}
		this.score = Math.round(score);

		this.html = '<ul class="votes"><li>Average:(' + score + ')</li>';
		
		for(var i = 0; i < 5; i++) {
			var styleClass = "FiveStarOff";
			if (this.score >= (i+1)*2) {
				styleClass = "FiveStarOn";
			}else if (this.score == (i+1)*2 -1) {
				styleClass = "FiveStarHalf";
			}	
			this.html += '<li class="'+ styleClass +'"></li>';		
		}
		this.html += '<li>(' + (ratecount+1) + (ratecount > 0 ? ' votes' : ' vote') + ')</li>';
		this.html += '</ul>';
		
		this.displayin.innerHTML = this.html;
	}
}