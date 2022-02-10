
window.Kakao.init("71eca88922edf275464f7b4346e1ae6b");
function kakaoLogin(){ 
	window.Kakao.Auth.login({
	scope : ' profile, account_email, gender'	,
	success: function(authObj) {
		console.log(authObj); 
		window.Kakao.API.request({
			
			url:'/v2/user/me', 
			success: res => {
				
				const kakao_account = res.kakao_account; 
				console.log(kakao_account);
				var json=JSON.stringify(kakao_account); //문자열로 바꾸고
				
				alert(typeof(json)); 
				
				location.href="kakao?js="
					+ encodeURIComponent(json)+"&command=form";
					
				
			
			}
			
		});
	}
	});
	
	
} 
//카카오 로그인 부분 end 







