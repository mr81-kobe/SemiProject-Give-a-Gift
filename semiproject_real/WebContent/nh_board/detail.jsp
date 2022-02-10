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
 <div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
				<div class="table100-body js-pscroll">
	
	<table class="table table-striped table-hover">
		<tr>
			<th class="column1">번호</th>
			<td class="column2">${dto.no }</td>
		</tr>
		<tr>
			<th class="column1">제목</th>
			<td class="column2">${dto.title }</td>
		</tr>
		<tr>
			<th class="column1">내용</th>
			<td class="column3">${dto.content }</td>		
		</tr>
		<tr>
			<th class="column1">작성자</th>
			<td class="column2">${dto.writer }</td>
		</tr>
		<tr>
			<th class="column1">날짜</th>
			<td class="column2"><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${dto.r_date }" /></td>
		</tr>
		<tr>
			<th class="column1">조회수</th>
			<td class="column2">${dto.hit }</td>
		</tr>
			</table>
	</div>
	</div>
	</div>
	</div>
	</div>
	
	<table class="table table-striped table-hover">
		<tr>
			<td colspan="5" style="border: white; text-align: center;">
			
			<button type="button" class="btn btn-success" onclick="location.href='../update?no=${dto.no}'"/>수정</button>
			<button type="button"  class="btn btn-success"  onclick="location.href='../delete?no=${dto.no}'"/>삭제</button>
			<button type="button"  class="btn btn-success"  onclick="location.href='../list_nh'"/>목록</button>
			</td>
		</tr>
	</table >
	
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				<div class="table100 ver1 m-b-110">
				<div class="table100-body js-pscroll">
	<table class="table table-striped table-hover">
	
	<form action="../commenet" method="get" name="com_frm">
		<tr><th class="col1">댓글</th></tr>
		<tr>
			<td class="col1">이름</td>
			<td class="col2"><input type="text" name="name" ></td>
		</tr>
		
		<tr>
			<td class="col1">내용</td>
			<td class="col2"><textarea cols="60" rows="5" name="content"></textarea></td>
		</tr>	
		
		<tr>
			<td colspan="5" style="border: white; text-align: center;">
			<button type="button" class="btn btn-success" id="insert">등록</button>	
			<input type="hidden" id="mes" name="mes">
			<input type="hidden" id="no" name="no" value="${dto.no}">
			</td>
		</tr>
	<c:forEach items="${clist }" var="c">
		<tr>
			<td  class="col1">${c.name }</td>
			<td  class="col1">${c.content }</td>
			<td  class="col1">${c.rdate }</td>
			
			<td>
			<input type="button"  value="삭제" id="delete"  class="delete" onclick="">
			<input type="hidden"  name="cno_tar" value="${c.idx }" class="cno" >
			</td>
		</tr>
	</c:forEach>
		<input type="hidden" name="cno" >
	</table>
</form>
	</div>
	</div>
	</div>
	</div>
	</div>
<script type="text/javascript" src="script/comment.js"></script>
</div>

</body>
</html>


