<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href='<c:url value="/www.root/css/style.css"/>'>
<script type="text/javascript" src="/www.root/js/main.js"></script>
<link rel="stylesheet" href="/www.root/css/style.css">
</head>
<body>


<h1>Hello</h1>
<img alt="anh 1" src='${pageContext.request.contextPath}/img/cake.png'>
<img alt="anh 2" src="${pageContext.request.contextPath}/img/638144250184622356HP.png">
<img alt="anh 3" src="${pageContext.request.contextPath}/img/${img}">
<img alt="anh 4" src="${pageContext.request.contextPath}/img/MVC.png">

	<form action="./up" method="post" enctype="multipart/form-data">
	Select file to upload:
	<br>
	<input type="text" name="name">
	<br>
	<input type="file" name="image" >
	
	
	<br> <br>
	<input type="submit" value="Uploads">
	</form>
</body>
</html>