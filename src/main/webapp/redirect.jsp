<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>

<head>
<title>SELECT Operation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
</head>

<body>
	<sql:setDataSource var="dbConnect" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3308/db_test" user="root" password="" />

	<sql:query dataSource="${dbConnect}" var="result">
                        SELECT * from user;
                    </sql:query>
 <h3>Method: ${method}</h3>
  <br>
  <h1 style="color:red;">List User</h1>
  <hr>
  <div class="container">
  	<a href="./home?action=AddOrEdit" class="btn btn-primary">Add new </a>
	<table  class="table table-striped">
		<tr>
			<th>Emp ID</th>
			<th>Username</th>
			<th>Password</th>
			<th>Edit/Delete</th>
		</tr>

		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.id}" /></td>
				<td><c:out value="${row.username}" /></td>
				<td><c:out value="${row.password}" /></td>
				<td>
					<a href="./home?action=AddOrEdit&id=${row.id}" class="btn btn-warning">Edit</a> ||  <a href="./home?action=Delete&id=${row.id}" class="btn btn-danger">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
  </div>

<script src="https://code.jquery.com/jquery-3.7.0.slim.min.js" integrity="sha256-tG5mcZUtJsZvyKAxYLVXrmjKBVLd6VpVccqz/r4ypFE=" crossorigin="anonymous"></script>
</body>

</html>