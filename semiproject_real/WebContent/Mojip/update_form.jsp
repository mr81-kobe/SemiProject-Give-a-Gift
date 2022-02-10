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
<link rel="stylesheet" href="Mojip/list.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script
	src="https://uicdn.toast.com/tui.code-snippet/v1.5.2/tui-code-snippet.min.js"></script>
<script
	src="https://uicdn.toast.com/tui.time-picker/latest/tui-time-picker.min.js"></script>
<script
	src="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.min.js"></script>
<script
	src="https://uicdn.toast.com/tui-calendar/latest/tui-calendar.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://uicdn.toast.com/tui-calendar/latest/tui-calendar.css" />
<link rel="stylesheet" type="text/css"
	href="https://uicdn.toast.com/tui.date-picker/latest/tui-date-picker.css" />
<link rel="stylesheet" type="text/css"
	href="https://uicdn.toast.com/tui.time-picker/latest/tui-time-picker.css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
<form action="mojip" method="post">
				<input type="hidden" id="command"  name="command"  value="update">
				<span class="input-group-text" id="inputGroup-sizing-default">title</span>
  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="title"  value="${dto.title }" readonly="readonly">


  <label for="floatingTextarea2">Comments</label>
  <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea2" style="height: 300px" name="content">${dto.content }</textarea>
  

<span class="input-group-text" id="inputGroup-sizing-default">startDate</span>
  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" id="startDate" name="starDate">
					  <span class="input-group-text" id="inputGroup-sizing-default">endDate</span>
  <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" id="endDate" name="endDate">
					<div class="form-check">
					
					 <input class="form-check-input" type="checkbox" value="월" id="flexCheckDefault" value="월" name="week">
  <label class="form-check-label" for="flexCheckDefault">
    월
  </label>  
  </div> 
  <div class="form-check">
  			 <input class="form-check-input" type="checkbox" value="화" id="flexCheckDefault" value="화" name="week">
  <label class="form-check-label" for="flexCheckDefault">
    화
  </label>  
  </div>
  	 <div class="form-check">
  	 <input class="form-check-input" type="checkbox" value="수" id="flexCheckDefault" value="수" name="week">
  <label class="form-check-label" for="flexCheckDefault">
    수
  </label> 
  </div> 
  <div class="form-check">
	 <input class="form-check-input" type="checkbox" value="목" id="flexCheckDefault" value="목" name="week">
  <label class="form-check-label" for="flexCheckDefault">
    목
  </label>  
  </div>
   <div class="form-check">
   <input class="form-check-input" type="checkbox" value="금" id="flexCheckDefault" value="금" name="week">
  <label class="form-check-label" for="flexCheckDefault">
 금
  </label>  
  </div> 
  <div class="form-check">
   <input class="form-check-input" type="checkbox" value="토" id="flexCheckDefault" value="토" name="week">
  <label class="form-check-label" for="flexCheckDefault">
    토
  </label>  
  </div> 
  <div class="form-check">
   <input class="form-check-input" type="checkbox" value="일" id="flexCheckDefault" value="일" name="week">
  <label class="form-check-label" for="flexCheckDefault">
    일
  </label>				 
					</div>
					
					<div class="form-check">
					모집 인원<input type="number" name="student" min="1" max="20">
					<input type="hidden" id="class_time" name="class_time" value="default">
					<input type="hidden" id="command" name="command" value="insert">
</div>  

<input type="submit" value="편집하기" class="btn btn-primary">

	<script type="text/javascript" src="Mojip/script2/datePicker.js"></script>
</form>
</div>

</body>
</html>


