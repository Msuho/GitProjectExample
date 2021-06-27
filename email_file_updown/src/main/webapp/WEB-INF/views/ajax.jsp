<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function test() {
		$.ajax({
			url : "ajax_result", // 컨트롤러 연결
			type : "GET", // 전송 방식
			success : function(data) { 
				$("#count").text(data)
				console.log("통신 성공") 
			},
			error : function() { console.log("통신 실패") }
		})
	}
	
</script>

</head>
<body>
	<!-- <h1>일</h1><h1>이</h1><h1>삼</h1><h1>사</h1><h1>오</h1><h1>육</h1><h1>칠</h1><h1>팔</h1><h1>구</h1> -->

	<button type="button" onclick="test()">클릭</button>
	<label id="count">1</label>
</body>
</html>