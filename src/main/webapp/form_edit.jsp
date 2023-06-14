<%@page import="com.kienvu.models.user"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<body  >
    <div   style="margin: 50px auto; width: 500px; height: 600px; display: flex; justify-content: center; align-items: center; background-color: #ccc;">
        <div style="  background-color: #fff; width: 85%;">

              
                <form action="./home?action=SaveOrUpdate" method="post">
                <input type="hidden" name ="id" value="${id}">
                    <div class="form-group">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" id="username"value="${u}" name="username" placeholder="Enter username" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="password" class="form-label">Password</label>
                        <input type="text" value="${p}"name="password" id="password" placeholder="Enter password" class="form-control">
                    </div> <br>
            
                    <input type="submit" class="btn btn-primary" value="Edit" style="float: left;">
                </form>
             
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.7.0.slim.min.js" integrity="sha256-tG5mcZUtJsZvyKAxYLVXrmjKBVLd6VpVccqz/r4ypFE=" crossorigin="anonymous"></script>
</body>
</html>