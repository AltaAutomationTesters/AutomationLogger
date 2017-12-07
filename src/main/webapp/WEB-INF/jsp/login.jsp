<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>:: Login to Dashboard ::</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/matrix-login.css" />
<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800'
	rel='stylesheet' type='text/css'>
<link rel="icon" href="images/icons/gear1.ico">

</head>
<body>
	<div id="loginbox">
		<form id="loginform" class="form-vertical" action="/doLogin"
			METHOD="POST">
			<div class="control-group normal_text">
				<h4>
					<i> :: Login To Dashboard :: <!-- <img src="img/logo.png" alt="Logo" /> -->
					</i>
				</h4>
			</div>
			<div class="control-group">
				<div class="controls">
					<div class="main_input_box">
						<span class="add-on bg_lg"><i class="icon-user"> </i></span><input
							name='usernameField' type="text" placeholder="Username" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<div class="main_input_box">
						<span class="add-on bg_ly"><i class="icon-lock"></i></span><input
							type="password" name='passwordField' placeholder="Password" />
					</div>
				</div>
			</div>
			<div class="form-actions">
				<span class="pull-right"><input type="submit"
					class="btn btn-success" value='Login' /> </span>
			</div>
		</form>

	</div>

	<script src="js/jquery.min.js"></script>
	<script src="js/matrix.login.js"></script>
</body>

</html>
