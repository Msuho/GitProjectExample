<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	
	function getUsers() {
		$.ajax({
			url: "users", type: "GET", dataType: "json",
			success: function(list) {
				console.log(list)
				//$("#users").text(list)
				
				/* let html = "<b>아이디 : </b>"+list[0].name+"님"
				html += "<b>나이 : </b>" +list[0].age+"살<br>"
				$("#users").text(html) */
				
				let str = ""
				
				$.each(list, function(index, item) {
					str += "<b>아이디 : </b>" + item.name + "님"
					str += "<b>나이 : </b>" + item.age + "살<br>"
				})
				
				$("#users").html(str) 
				
			},error: function() {
				alert('문제 발생')
			}
		})
	}
	
	function userInfo() {
		
		console.log("user/"+$("#userId").val())
		$.ajax({
			// 예전 방식
			//url: "user?id="+$("#userId").val(),
			// 현재 방식 user/홍길동14 이런식으로 경로가 만들어진다.
			url: "user/"+$("#userId").val(),
			type: "GET", dataType: "json",
			success: function(data) {
				str = "<b>아이디 : </b>" + data.name + "님"
				str += "<b>나이 : </b>" + data.age + "살<br>"
				$("#users").html(str) 
			}, error: function() {
				alert('문제 발생')
			}
		})
	}
	
	function reply() {
		$("#reply").show()
	}
	
	function modify() {
		
		let name = $("#name").val()
		let age = $("#age").val()
		let form = {name:name, age:age}
	
		
		$.ajax({
			
			url: "modify", type: "PUT", dataType: "json",
			data: JSON.stringify(form),
			contentType: "application/json; charset=uft-8",
			success: function(data) {
				str = "<b>아이디 : </b>" + data.name + "님"
				str += "<b>나이 : </b>" + data.age + "살<br>"
				$("#users").html(str) 
			}, error: function() {
				alert('문제 발생')
			}
		})
	}
	
	function membership() {
		/* let uId = $("#uId").val()
		let uName = $("#uName").val()
		let uAddr = $("#uAddr").val()
		let uPhone = $("#uPhone").val()
		let uAge = $("#uAge").val()
		let form = {uId:uId, uName:uName, uAddr:uAddr, uPhone:uPhone, uAge:uAge} */
		
		let form = {}
		// 배열형태로 만들어 준다 [{name:uId, value:값1},{name:uId, value:값2}...]
		let arr = $("#frm").serializeArray()
		for(i=0; i<arr.length; i++){
			form[arr[i].name] = arr[i].value
			//form ={uId:값1}
		}
		
		$.ajax({
			url: "membership", type: "POST", dataType: "json",
			data : JSON.stringify(form),
			contentType: "application/json;charset=utf-8",
			success: function(data) {
				if(data.result == true){
					alert('성공적으로 저장')
				}else{
					alert('동일한 아이디 존재')
				}
			},error: function() {
				alert('문제 발생')
			}
		})
	}

</script>
<style type="text/css">
	#reply{display: none;}
</style>
</head>
<body>
	<span id="users"></span><hr>
	<button type="button" onclick="getUsers()">사용자 목록</button>
	<hr>
	<input type="text" id="userId" placeholder="search id"><br>
	<button type="button" onclick="userInfo()">개인정보</button>
	<hr>
	<div id="reply">
		<input type="text">
		<input type="text">
		<input type="text">
	</div>
	<button type="button" onclick="reply()">답글 작성</button>
	<hr>
	수정하고자 하는 비교 아이디 <br>
	<input type="text" id="name"><br>
	수정 할 나이 : <input type="text" id="age"><br>
	<button type="button" onclick="modify()">수정</button>
	<hr>
	<form id="frm">
		<input type="text" id="uId" name="uId" placeholder="id"><br>
		<input type="text" id="uName" name="uName" placeholder="uName"><br>
		<input type="text" id="uAddr" name="uAddr" placeholder="uAddr"><br>
		<input type="text" id="uPhone" name="uPhone" placeholder="uPhone"><br>
		<input type="text" id="uAge" name="uAge" placeholder="uAge"><br>
		<input type="button" onclick="membership()" value="가입">
	</form>
	
</body>
</html>