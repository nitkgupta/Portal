<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>INDEX</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style type="text/css">
	body {
		background-image: url("image/bg_blur.png");
		background-size: 100%;
		background-repeat: no-repeat;
	}
	
	.main-text{
		text-align: justify;
		font-size: 16px;
	}
	#jumbo {
		/* IE8 and below */
		background: rgb(200, 54, 54);
		/* all other browsers */
		background: rgba(200, 54, 54, 0.05);
		padding-left: 10px;
		padding-right: 10px;
		padding-bottom: 10px;
		padding-top: 1px;
		margin-top: 50px;
		
	}
	form{
		color: white;
	}
	#date{
		padding-right: 60px;
		padding-bottom: 11px;
		color: black;
	}
	h2{
		color: white;
		font-size: 50px;
	}
	label{
		color: black;
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
				<a class="navbar-brand" href="index.html">PEP</a>
			</div>

			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.html">Home <span class="sr-only">(current)</span></a></li>
					<li class="dropdown">
						<a href="Login.html" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Complains <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="Login-msg.html" data-toggle="modal" data-target="#Login-msg-modal">Lodge a Complain</a></li>
							<li><a href="Login-msg.html" data-toggle="modal" data-target="#Login-msg-modal">Check Status</a></li>
							<li><a href="Login-msg.html" data-toggle="modal" data-target="#Login-msg-modal">Withdraw Complain</a></li>
							<li class="divider"></li>
							<li><a href="Login.html" data-toggle="modal" data-target="#Login-msg-modal">Report Unsolved Complain</a></li>
						</ul>
					</li>
					<li class="dropdown">
						<a href="Login.html" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Ministries <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="Login.html" data-toggle="modal" data-target="#Login-msg-modal">Human Resources</a></li>
							<li><a href="Login.html" data-toggle="modal" data-target="#Login-msg-modal">Aggriculture</a></li>
							<li><a href="Login.html data-toggle="modal" data-target="#Login-msg-modal"">Railways</a></li>
							<li class="divider"></li>
							<li><a href="Login.html" data-toggle="modal" data-target="#Login-msg-modal">Home Ministry</a></li>
						</ul>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" data-toggle="modal" data-target="#myModal">Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Log In</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<fieldset>

							<div class="form-group">
								<label for="inputEmail" class="col-xs-2 control-div">UserName</label>
								<div class="col-xs-10">
									<input type="text" class="form-control" id="inputEmail" name="username" placeholder="User Name">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-xs-2 control-div">Password</label>
								<div class="col-xs-10">
									<input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password">
								</div>
							</div>
							<div class="modal-footer">
								<div class="pull-left">
									<a href="ForgotPassword.html">Forgot Password?</a>-
									<a href="SignUp.html">Register</a>
								</div>
								<input type="submit" class="btn btn-primary" value="Submit">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal" id="Login-msg-modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title text-danger text-center">Please Log In First</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<fieldset>

							<div class="form-group">
								<label for="inputEmail" class="col-sm-2 control-div">UserName</label>
								<div class="col-xs-10">
									<input type="text" class="form-control" id="inputEmail" name="username" placeholder="User Name">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-div">Password</label>
								<div class="col-xs-10">
									<input type="password" class="form-control" id="inputPassword" name="password" placeholder="Password">
								</div>
							</div>
							<div class="modal-footer">
								<div class="pull-left">
									<a href="ForgotPassword.html">Forgot Password?</a>-
									<a href="SignUp.html">Register</a>
								</div>
								<input type="submit" class="btn btn-primary" value="Submit">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--Header Complete Anurag :) -->
	<div class="container-fluid main-body">
		<div class="col-xs-12 col-sm-offset-4 col-sm-4">
			<br><br>
			<div class="jumbotron" id="jumbo">
				<h2 class="text-center">Log In Fail</h2><br>
				<form class="form-horizontal">
					<fieldset>
						<div class="form-group">
							<div for="inputId" class="col-xs-2 control-div">UserId</div>
							<div class="col-xs-10">
								<input name="id" type="text" class="form-control" id="inputId" placeholder="User Id">
							</div>
						</div>
						<div class="form-group">
							<div for="inputPassword" class="col-xs-2 control-div">Password</div>
							<div class="col-xs-10">
								<input name="password" type="password" class="form-control" id="inputPassword" placeholder="Password">
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-10 col-xs-offset-2">
								<input type="submit" class="btn btn-primary" value="Login">
							</div>
						</div>
						
					    <%@ include file="passworderror.html" %>
						
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>