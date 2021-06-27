<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

	function ajax() {
		
		var n = document.getElementById("name").value; // 자바스크립트 형식
		var a = $("#age").val() // ajax 형식
		var addr = $("#addr").val()
		var form = {age:a, name:n, addr:addr}
		
		$.ajax({
			
			url:"ajax_result02", type:"POST",
			data: JSON.stringify(form), // data: 서버로 전송할 데이터
			contentType: "application/json; charset=utf-8",	// 보낼 데이터의 형식을 지정
			dataType : "json", // 서버로 부터 return 받을 type 지정 ex) json파일로 받을 것이다.
			success: function(data) {
				
				console.log(data)
				console.log(data.name)
				console.log(data.age)
				
				$("#label").text(data.name+":"+data.age)
			}, error: function() {
				alert('문제 발생')
			}
		})
		
	}
	

</script>

</head>
<body>
	
	<input type="text" id="name"><br>
	<input type="text" id="age"><br>
	<input type="text" id="addr"><br>
	<input type="button" value="click" onclick="ajax()"><br>
	<hr>
	결과 : <label id="label"></label>
	
</body>
</html>