function setEvent(target,style1,style2){
	target.style.borderColor="#FF0000";
	target.onmouseout=function(){
	target.style.borderColor="#00FF00";
	}
}
function setBorderColor(target,color){
	target.style.borderColor=color;
}