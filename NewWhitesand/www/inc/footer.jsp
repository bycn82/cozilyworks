<br/>======footer====<br/>





<iframe width=132 height=142 name="gToday:contrast:agenda.js" id="gToday:contrast:agenda.js" src="${pageContext.request.contextPath}/cal/date_range/ipopeng.htm" scrolling="no" frameborder="0" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;"></iframe>
<input id="nouse" type="hidden"/>
<script>
 function showDateSelecter(a,b,c){
	  	if(self.gfPop){
	  		if(c=='start'){
	  		gfPop.fStartPop(a,b);
	  		}
	  		if(c=='end'){
	  		gfPop.fEndPop(a,b);
	  		}
	  		if(c=='single'){
	  		gfPop.fStartPop(a,$('nouse'));
	  		}
	  	}
	  }
</script>