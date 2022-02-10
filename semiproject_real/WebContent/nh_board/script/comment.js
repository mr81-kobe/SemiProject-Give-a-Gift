var mes=document.querySelector("#mes");
var insert=document.querySelector("#insert");

var del=document.querySelectorAll(".delete");
var cno=document.querySelectorAll(".cno");

for(var i =0; i<del.length; i++){
    del[i].onclick=function(){
       mes.value="delete";
       document.com_frm.method="get";
     
       document.com_frm.cno.value=this.nextElementSibling.value;
       document.com_frm.submit();
    }
 }

insert.onclick=function(){
	mes.value="insert";
	document.com_frm.method="post";
	document.com_frm.submit();

}