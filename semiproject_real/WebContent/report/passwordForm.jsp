<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta  charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="icon" href="Image/engineer.ico">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
  <link href="https://fonts.googleapis.com/css2?family=Arizonia&family=Montserrat:wght@400;800&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@700&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.1/css/all.min.css">
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>
<body>
 <header>
              <nav class="navbar navbar-expand-lg navbar-light ">
                <a class="navbar-brand brand-name" href="main.jsp">Give a Gift</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
        
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                      <a class="nav-link headerachor" href="main.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link headerachor" href="mojip">Mojip</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link headerachor" href="list_nh">QnA</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link headerachor" href="list_in">Report</a>
                    </li>
                    
                  </ul>
              </nav>
          </header>
<div class="row column1" style="margin-bottom: 50px;">
                <div class="col-lg-6 col-md-6 first-image">
                    <img class = "boyimage" src="Image/20200630_162659.gif" alt="">
                </div>  
                  <div class="col-lg-6 section-1">
                      <h1 class = "Hello">Give a Gift <span class="wave">👋</span></h1>
                      <p>This is a web project for talent donation for disabled people in need of social help. </p>
                      <h3>Give a Gift!! Donate your talent!</h3>
                          <div class=social_media_icon>
                            <a class="btn" href="https://www.instagram.com/ajit.verma_/" target=_blank>
                              <i class="fab fa-instagram"></i>
                            </a>
                            <a class="btn" href="https://www.linkedin.com/in/ajit-verma-70b9b0196/" target=_blank>
                              <i class="fab fa-linkedin" aria-hidden="true"></i>
                            </a>
                            <a class="btn" href="https://github.com/AjitVerma15" target=_blank>
                              <i class="fab fa-github"></i>
                            </a>
                            <a class="btn" href="mailto:ajitverma1503@gmail.com" target=_blank>
                              <i class="fab fa-google"></i>
                            </a>
                          </div>
                  </div>
                   </div>
 <div align="center" >
 <form action="detail_in" name="frm">
		<table class="table table-striped table-hover">
			<tr>
				<td align="center">${dto.title }</td>
			</tr>
			<tr>
				<td align="center">
					글의 비밀번호를 입력해주세요.<br>
					<input type="password" name="password_" required="required" />
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="button" value="확인" onclick="pwdCheck()" class="btn btn-primary"/>
					<input type="button" value="돌아가기" onclick="location.href='list_in'" class="btn btn-primary" />
				</td>
			</tr>
		</table>
		<input type="hidden" value="${dto.code }" name="code"  />
		<input type="hidden" value="${dto.password }" name="password"/>
	</form>
<script type="text/javascript" src="report/report.js"></script>
</div>

</body>
</html>


