<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<style>
    table, th, td{
        border: 1px solid black;
        border-collapse: collapse;
        padding: 5px 10px;
    }
    
    input[type="submit"]{
    	height: 50px;
    }    
</style>
</head>
<body>
	<h2>LOGIN</h2>
	<hr/>
	<form action="login" method="post">
	    <table>
	        <tr>
	            <th>ID</th>
	            <th>
	                <input type="text" name="id" value="" placeholder="아이디를 입력 하세요"/>
	            </th>
	            <th rowspan="2">
	                <input type="submit" value="login"/>
	            </th>
	        </tr>
	        <tr>
	            <th>PW</th>
	            <th>
	                <input type="password" name="pw" value="" placeholder="비밀번호를 입력 하세요"/>
	            </th>                
	        </tr>
	        <tr>
	            <th colspan="3">
	                <input id="regist" type="button" value="회원가입"/>
	                <input type="button" value="아이디/비번 찾기"/>
	            </th>    
	        </tr>
	    </table>
	</form>
</body>
<script>
	$('#regist').on('click',function(){
		location.href='joinForm';
	});
	
	var msg = "${msg}";
	if(msg != ""){
		alert(msg);
	}


</script>
</html>