function pwdCheck(){
	if(document.frm.password_.value!=document.frm.password.value){
		alert("비밀번호가 틀렸습니다.");
		document.frm.password_.focus();
		return;
	}
	document.frm.submit();
}

