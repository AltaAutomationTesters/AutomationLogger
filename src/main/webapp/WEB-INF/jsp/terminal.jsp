<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Terminal</title>
<style type="text/css">
.console {
	font-family: Courier;
	color: #CCCCCC;
	background: #000000;
	border: 1px dashed #CCCCCC;
	padding: 5px;
}
</style>
</head>
<body class="console">
	<script src="js/jquery.min.js"></script>
	<script>
		setInterval(function() {
			$(".console").load("/getFile?fileName=logs");
		}, 3000);
		window.scrollTo(0, document.body.scrollHeight);
	</script>
</body>
</html>