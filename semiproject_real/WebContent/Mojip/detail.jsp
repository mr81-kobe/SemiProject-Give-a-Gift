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
<link rel="stylesheet" href="Mojip/css/list.css">
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
                      <a class="nav-link headerachor" href="index.jsp">Home</a>
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
<button id="prevBtn" class="btn btn-primary">이전</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<button id="nextBtn" class="btn btn-primary">다음</button>
	&nbsp;&nbsp;&nbsp;&nbsp;

	<div id="calendar" style="height: 300px;"></div>

	<div >
		<form action="../sche" method="get">
			<table id="table_detail" class="table table-borderless">
				<tr>
					<td>글쓴이 ${m.id }<input type="hidden" name="teacher"
						value="${m.id }" id="teacher"></td>
				</tr>
				<tr>
					<td>제목: ${m.title }<input type="hidden" name="title"
						value="${m.title }" id="title"></td>
				</tr>
				<tr>
					<td>내용: ${m.content }</td>
				</tr>
				<tr>
					<td>시간: ${m.time }</td>
				</tr>

				<tr>
					<td>모집인원: ${m.student } <input type="hidden" name="student"
						value="${m.student }" id="student"></td>
				</tr>
				<tr>
					<c:if  test="${cur_student !=null }">	
					<td>현재인원: ${cur_student } </td>
				</c:if> 
				<c:if  test="${cur_student ==null }">	
					<td>현재인원: 0 </td>
				</c:if>
				</tr>

				<tr>
					<td>강의 시간: ${m.startdate }~${m.enddate } <input type="hidden"
						name="startdate" value="${m.startdate }" id="startdate"> <input
						type="hidden" name="enddate" value="${m.enddate }" id="enddate"></td>
				</tr>
				<input type="hidden" name="week" value="${m.week }" id="week">

			</table>
		</form>
		<div id="modal" class="searchModal">
			<div class="search-modal-content">
				<div class="page-header">
					<h1 id="modalhead"></h1>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-12">
								<h2 id="modal_text"></h2>
							</div>
						</div>
					</div>
				</div>
				<hr>
				<div
					style="cursor: pointer; background-color: #DDDDDD; text-align: center; padding-bottom: 10px; padding-top: 10px;"
					onClick="closeModal();">
					<span class="pop_bt modalCloseBtn" style="font-size: 13pt;">
					닫기
					</span>
				</div>
			</div>
		</div>
<c:if test="${tag ne 'none' }">
<h3>내 강의에 신청한 학생들</h3>

<table class="table table-striped table-hover">
<tr><th>아이디(카카오톡)</th><th>nickname</th><th>Time</th></tr>
<c:forEach items="${list_m }" var="cl">
<tr><td>${cl.id }</td><td>${cl.nick }</td><td>${cl.time }</td></tr>

</c:forEach>

</table>



</c:if>




		<c:if test="${tag eq 'none' }">
			<input type="button" value=" 강의 신청" id="butt" class="btn btn-primary">
		
		</c:if> 
		<c:if test="${tag ne 'none'  && userid == m.id }">
			<input type="button" value="편집하기" id="update" class="btn btn-primary"> 
			<input type="button" value="삭제하기" id="delete" class="btn btn-primary">
		</c:if>
		<input type="button" value="리스트로"  onclick="location.href='mojip' " class="btn btn-primary">
	</div>
	<script type="text/javascript" src="Mojip/script2/detail.js"></script>
	<c:forEach items="${t_list}" var="t">
		<script type="text/javascript">
	make_Time('${m.title}' ,'${t.start}', '${t.end}' )


</script>
	</c:forEach>
</div>

</body>
</html>


