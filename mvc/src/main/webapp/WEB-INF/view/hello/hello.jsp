<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HELLO</title>
</head>
<body>
<h1>HELLO!</h1>
<h3>
<% 
String name = (String) request.getAttribute("name");
if(request.getAttribute("name")!=null) {
	out.print(name);
} else {
	out.print("방문자");
} %> 
님 안녕하세요!
</h3>
</body>
</html>