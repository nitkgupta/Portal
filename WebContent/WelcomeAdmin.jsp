<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>PDE | Home</title>
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
			text-align: justify;
			font-size: 16px;
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
	<nav class="navbar navbar-inverse">
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
						<li><a href="#">Complain<span class="sr-only">(current)</span></a></li>
						<!-- <ul class="dropdown-menu" role="menu">
							<li><a href="Login-msg.html" data-toggle="modal" data-target="#Login-msg-modal">Lodge a Complain</a></li>
							<li><a href="Login-msg.html" data-toggle="modal" data-target="#Login-msg-modal">Check Status</a></li>
							<li><a href="Login-msg.html" data-toggle="modal" data-target="#Login-msg-modal">Withdraw Complain</a></li>
							<li class="divider"></li>
							<li><a href="Login.html" data-toggle="modal" data-target="#Login-msg-modal">Report Unsolved Complain</a></li>
						</ul> -->
					</li>
					<li class="">
						<li><a href="AdminComplain.html">Ministries<span class="sr-only">(current)</span></a></li>
						<!-- <ul class="dropdown-menu" role="menu">
							<li><a href="Login.html" data-toggle="modal" data-target="#Login-msg-modal">Human Resources</a></li>
							<li><a href="Login.html" data-toggle="modal" data-target="#Login-msg-modal">Aggriculture</a></li>
							<li><a href="Login.html data-toggle="modal" data-target="#Login-msg-modal"">Railways</a></li>
							<li class="divider"></li>
							<li><a href="Login.html" data-toggle="modal" data-target="#Login-msg-modal">Home Ministry</a></li>
						</ul> -->
					</li>
					<!-- <li class="dropdown">
						<li><a href="#">NGO's<span class="sr-only">(current)</span></a></li> -->
						<!-- <ul class="dropdown-menu" role="menu">
							<li><a href="helpage.jsp">HelpAge India</a></li>
							<li><a href="going.jsp">Going To School</a></li>
							<li><a href="teach.jsp">Teach For India</a></li>
							<!-- <li class="divider"></li> -->
							<!-- <li><a href="prayatn.jsp">Prayatn</a></li> -->
						</ul> 
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#" data-toggle="modal" data-target="#myModal">LogOut</a></li>
					<li class="dropdown">
						<a href="# class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${userId} <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="Profile.jsp">Profile</a></li>
							<li><a href="Profile.jsp">Change Password</a></li>
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
						<form method="post" action="LogoutServlet">
						<input type="hidden" name="userid" valiue='${userId}'>
						<input type="submit" class="btn btn-primary" value="LogOut">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
								<label for="inputEmail" class="col-lg-2 control-label">UserName</label>
								<div class="col-lg-10">
									<input type="text" class="form-control" id="inputEmail" name="username" placeholder="User Name">
								</div>
							</div>
							<div class="form-group">
								<label for="inputPassword" class="col-lg-2 control-label">Password</label>
								<div class="col-lg-10">
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
	<div class="text-center">
		<h1>Welcome Admin</h1>
	</div>
	<div class="row">	
		<div class="col-sm-offset-2 col-sm-8">
		<p class="main-text">
			Here at People's Empowerement Portal we not only listens to your complains and suggestions but we feel them the way you do. At <strong>P E P</strong> your worries becomes ours and we with our team of dedicated problem solvers try to solve your problem as soon as we can and try to bring smiles to our users. It is our guarantee that no other day would be wasted for solving your problem. At PEP, we evolve each day. With State of Art Infrastructure our computers are learning each day to solve new problems. We use machine learning to learn problems that worries you. When your problems are solved we with the help of Deep Learning and Sentiment Analysis, analyse your feedbacks to evolve. You can count on our technology. We Innovate.
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