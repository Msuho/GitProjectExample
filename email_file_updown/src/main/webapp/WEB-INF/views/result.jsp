<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="dto" items="${list }">
		아이디 : ${dto.id } 
		이름 : ${dto.name } 
		이미지 : ${dto.imgName }
		<img src="${contextPath }/download?file=${dto.imgName}" style="width: 100px; height: 100px;">
		<a href="${contextPath }/download?file=${dto.imgName}">다운로드</a>
		
		<br><hr>
	</c:forEach>
	<a href="${contextPath }/form">업로드 이동</a>
</body>
</html>