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
	margin-top: 30px;
	margin-bottom: 100px;
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
				<li class="nav-item active"><a class="nav-link"
					href="firstpage" style="color: white;">Home</a></li>
				<li class="nav-item active"><a class="nav-link"
					style="color: white;">Loan-Details</a></li>
				<li class="nav-item active"><a class="nav-link" href="logout"
					style="color: white;">Log-Out</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">

		<form method="post">
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="inputPassword4">Collateral Id</label> <input
						type="number" class="form-control" name="collateralId"
						id="collateralId" placeholder="Collateral Id">
				</div>
				<div class="form-group col-md-6">
					<label for="inputEmail4">Loan Id</label> <input type="number"
						class="form-control" name="loanId" id="loanId"
						placeholder="loan Id">
				</div>
				<div class="form-group col-md-6">
					<label for="inputEmail4">Collateral Value</label> <input
						type="number" class="form-control" name="collateralvalue"
						id="collateralvalue" placeholder="collateralvalue" value=0>
				</div>

				<div class="form-group col-md-6">
					<label for="inputEmail4">sanctioned Loan</label> <input
						type="number" class="form-control" name="sanctionedLoan"
						id="sanctionedLoan" placeholder="sanctionedLoan" value=0>
				</div>


				<div class="form-group col-md-6">
					<label for="inputPassword4">Collateral Type</label> <input
						type="text" class="form-control" name="collateralType"
						id="collateralType" placeholder="Collateral Type">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Bank Name</label> <input type="text"
						class="form-control" name="bankName" id="bankName"
						placeholder="Bank Name">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Deposit Amount</label> <input
						type="number" class="form-control" name="depositAmount"
						id="depositAmount" value=0 placeholder="Deposit Amount">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Interest Rate</label> <input
						type="number" class="form-control" name="interestRate"
						id="interestRate" value=0 placeholder="Interest Rate">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Lock Period In Months</label> <input
						type="number" class="form-control" name="lockPeriodInMonths"
						id="lockPeriodInMonths" value=0
						placeholder="Lock Period In Months">
				</div>
				<div class="form-group">
					<label for="inputAddress">Collateral Address</label> <input
						type="text" class="form-control" name="collateral_address"
						id="collateral_address" placeholder="Address" value="Pune">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Rate per Sq ft</label> <input
						type="number" class="form-control" name="rate_per_sq_ft"
						id="rate_per_sq_ft" value=0 placeholder="Rate">
				</div>
				<div class="form-group col-md-6">
					<label for="inputPassword4">Area</label> <input type="number"
						class="form-control" name="area" id="area" value=0
						placeholder="Area">
				</div>
				<br>
			</div>
			<button type="submit" class="btn btn-success">Save</button>
		</form>

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