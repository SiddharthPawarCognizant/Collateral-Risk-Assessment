<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Loans</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.container {
	margin-top: 100px;
}

#footer {
	position: fixed;
	bottom: 0;
	width: 100%;
	background-color: #A9A9A9;
	height: 50px;
}

#footer span {
	line-height: 50px;
	padding-left: 30px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-primary">
		<a style="margin-left: 20px"><i class="fa fa-bank"
			style="font-size: 36px"></i></a> <a class="navbar-brand"
			style="color: white; margin-left: 20px">HSBC BANK BACK-OFFICE</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="firstpage"
					style="color: white;">Home</a></li>
				<li class="nav-item active"><a class="nav-link" 
					href="logout" style="color: white;">Log-Out</a></li>
	
			</ul>
		</div>
	</nav>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr class="table-success">
					<th>Loan Id</th>
					<th>Customer Id</th>
					<th>View Loan-Details</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${result}" var="result">
				<tr>
					<td>${result.loanId}</td>
					<td>${result.customer.customerId}</td>
					<td ><a href="page?customerid=${result.customer.customerId}&loanid=${result.loanId}" type="submit" class="btn btn-success" >View Loan-Details</a></td>
				</tr>
            </c:forEach>
			</tbody>
		</table>
	</div>

	<div id="footer">
		<footer>
			<span>Copyright &#169; 2019</span>
		</footer>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
		crossorigin="anonymous"></script>
</body>
</html>