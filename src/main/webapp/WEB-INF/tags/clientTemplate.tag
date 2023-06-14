<%@tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" rtexprvalue="true"%>
<%@ attribute name="content" fragment="true"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>
<style>
/*  */
* {
	box-sizing: border-box;
	margin: 0px;
}

.clear_float {
	clear: both;
}
/*  */
header {
	background-color: #ccc8b3;
	text-align: center;
	font-size: 30px;
	padding: 30px;
}

nav {
	background-color: #d1dbdb;
	float: left;
	height: 300px;
	margin: 20px 20px;
	width: 15%;
	padding: 20px;
}
nav ul{
	/*list-style: none;*/
}
nav ul li a{
	text-decoration: none;
}

article {
	background-color: #f2f2e6;
	float: right;
	height: 600px;
	width: 80%;
	padding: 20px;
}

footer {
	background-color: #abbebe;
	padding: 20px;
	text-align: center;
}

@media ( max-width : 600px) {
    nav{
    margin: 0px;
    }
	nav, article {
		height: auto;
		width: 100%;
	}
}
</style>
</head>
<body>
	<header> Dashboard Client </header>
	<session>
	<nav>
		<h2>Menu navigation</h2>
		<ul>
			<li><a href="#">Link one</a></li>
			<li><a href="#">Link two</a></li>
			<li><a href="#">Link three</a></li>
		</ul>
	</nav>
	<article>
		
		<div class="container">
			<jsp:invoke fragment="content"></jsp:invoke>
		</div>
	</article>
	<div class="clear_float"></div>
	</session>
	<footer> Footer | Copyright by KienVu &copy; </footer>
</body>
</html>