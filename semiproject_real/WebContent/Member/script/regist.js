
//나머지 스크립트 문장 시작 



var tagId = document.querySelector("#tagId"); 
var exp =document.querySelector("#export");  
var not =document.querySelector("#not");  
var isreal =document.querySelector("#isreal");

/*exp=function() {
	
	tagId.style.display="block";
	isreal.value ="yes";
}

not.onclick=function() {
	
	tagId.style.display="none";
	isreal.value ="no";
}*/


exp.onchange= function(){
	
	if(exp.checked){
		
		tagId.style.display="block";
		isreal.value ="yes";
		
	}else{
		
		tagId.style.display="none";
		isreal.value ="no";
		
	}
	
	
}