<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Error</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style type="text/css">
		h1{
			font-size: 80px;
			padding: 40px;
			padding-top: 50px;
		}
		.main-text{
			text-align: center;
			font-size: 20px;
		}
		.bg-2{
    		background-color: #222222;
    		border-color: #222222;
    		padding-bottom: 40px;
    		padding-top: 40px;
    		color: 222222;
    		text-align: center;
  		}
  		.main-body{
  			padding-bottom: 120px;
  		}
	</style>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Welcome.jsp">PEP</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.html">Home <span class="sr-only">(current)</span></a></li>
					<li class="dropdown">
						<a href="# class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Complains <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="Complain.html">Lodge a Complain</a></li>
							<li><a href="Status.html">Check Status</a></li>
							<li><a href="Withdraw.html">Withdraw Complain</a></li>
							<li class="divider"></li>
							<li><a href="Report.html">Report Unsolved Complain</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Ministries <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="HRD.jsp">Human Resources</a></li>
							<li><a href="Aggri.jsp">Aggriculture</a></li>
							<li><a href="Rail.jsp">Railways</a></li>
							<li class="divider"></li>
							<li><a href="Home.jsp">Home Ministry</a></li>
						</ul>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" data-toggle="modal" data-target="#myModal">LogOut</a></li>
					<li class="dropdown">
						<a href="# class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">User <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="Profile.jsp">Profile</a></li>
							<li><a href="Profile.jsp">Change Passowrd</a></li>
							<li class="divider"></li>
							<li><a href="ComingSoon.html">Link Adhar</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title text-warning">Are you sure you want to LogOut?</h4>
				</div>
				<div class="modal-body">
					By Clicking on LogOut you will close this session.
					<div class="modal-footer">
						<form method="get" action="LogOutServlet">
						<input type="hidden" name="userid" valiue="">
						<input type="submit" class="btn btn-primary" value="LogOut">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
<!--Header Complete Anurag :) -->
<div class="container-fluid main-body">
	<div class="text-center">
		<h1>Error Occured</h1>
	</div>
	<div class="row">	
		<div class="col-sm-offset-2 col-sm-8">
		<p class="main-text text-center">
			You are viewing this page because of some Unexpected Error. Don't worry we'll fix this soon.
			</p>
		</div>
		<!-- <div class="col-sm"></div> -->
	</div>
</div>
<footer class="text-center navbar-fixed-bottom bg-2">

  <p style="color: white;">Copyright 2017 People Empowerment Portal</p>
</footer>
</body>
</html>