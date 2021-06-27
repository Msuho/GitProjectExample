<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <c:set value="${pageContext.request.contextPath }" var="contextPath"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${userid == null }">
		<a href="${contextPath }/auth">이메일 인증하기</a>
	</c:if>
	<c:if test="${userid != null }">
		${userid } 님 이메일 인증 되셨습니다.
	</c:if>
</body>
</html>