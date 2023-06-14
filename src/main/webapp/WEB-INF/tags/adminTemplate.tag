<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="title" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
<style>
/*  */
body {
	margin: 0px;
}

section::after {
	clear: both;
}

.clear_float {
	clear: both;
}

* {
	box-sizing: border-box;
}

/*  */
header {
	background-color: #666;
	padding: 30px;
	font-size: 35px;
	text-align: center;
}

nav {
	float: left;
	width: 20%;
	height: 600px;
	background: #ccc;
	padding: 20px;
}

nav ul {
	/* list-style: none; */
	
}

nav ul li a {
	text-decoration: none;
}

article {
	float: left;
	width: 80%;
	padding: 10px;
	background-color: #f1f1f1;
	height: 600px;
}

footer {
	background-color: #777;
	padding: 10px;
	text-align: center;
	/* font-size: 10px; */
}

@media ( max-width : 600px) {
	nav, article {
		width: 100%;
		height: auto;
	}
}
</style>
</head>

<body>
	<header>Dashboard Admin</header>
	<section>
		<nav>
			<ul>
			<h3>Menu navigation</h3> 
				<li><a href="${pageContext.request.contextPath}/admin/product?action=AddOrEdit&id=0">Manager product</a></li>
				<li><a href="#">CRUD product</a></li>
				<li><a href="">CRUD</a></li>
			</ul>
		</nav>
		<article>
			<div class="container">
				<jsp:invoke fragment="content"></jsp:invoke>
			</div>
		</article>
		<div class="clear_float"></div>
	</section>
	<footer>
		<p>Footer | Coppyright by KienVu &copy; </p>
	</footer>
</body>

</html>