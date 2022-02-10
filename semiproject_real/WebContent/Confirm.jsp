<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고글 제목 검색 목록 : search.jsp</title>
</head>
<body>
	신고글 제목 검색 목록
	<br>
	<br>
	
	<form action="search_in" method="get">
		<input type="text" name="searchWord" required="required"/>
		<input type="submit" value="제목검색"/>
		<input type="button" value="목록으로 돌아가기" onclick="location.href='list_in'" />
	</form>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach var="n" items="${list }">
			<tr>
				<td>${n.code }</td>
				<td><a href="detail_in?code=${n.code }">${n.title }</a></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${n.rdate }" /></td>
				<td>${n.hit }</td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="report/writeForm.html">글쓰기</a>
	<br>
	<br>
	
	<c:set var="page" value="${empty param.page? 1 : param.page }" />
	<c:set var="startNum" value="${page-(page-1)%5 }" />
	<c:set var="lastNum" value="${fn:substringBefore(Math.ceil(count/10),'.') }" />
	
	<c:if test="${startNum>1 }">
		<a href="search?page=${startNum-1 }&searchWord=${searchWord}" >이전</a>
	</c:if>
	<c:if test="${startNum<=1 }">
		<a onclick="alert('이전페이지가 없습니다.')">이전</a>
	</c:if>
		
	<c:forEach var="i" begin="0" end="4">
		<c:if test="${(startNum+i)<=lastNum }">
			<a href="search_in?page=${startNum+i }&searchWord=${searchWord}"  style="color:${(page==startNum+i)? 'orange':'gray'}">${startNum+i }</a>
		</c:if>
	</c:forEach>
	
	<c:if test="${startNum+4<lastNum }">
		<a href="search_in?page=${startNum+5 }&searchWord=${searchWord}" >다음</a>
	</c:if>
	<c:if test="${startNum+4>=lastNum }">
		<a onclick="alert('다음페이지가 없습니다.')">다음</a>
	</c:if>

</body>
</html>