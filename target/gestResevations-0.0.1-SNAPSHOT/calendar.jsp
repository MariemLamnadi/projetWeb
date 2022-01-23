<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Planning</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.css">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="template/assets/images/favicon.png">

<!-- Custom CSS -->
<link href="template/assets/extra-libs/c3/c3.min.css" rel="stylesheet">
<link href="template/assets/libs/chartist/dist/chartist.min.css"
	rel="stylesheet">
<link
	href="template/assets/extra-libs/jvector/jquery-jvectormap-2.0.2.css"
	rel="stylesheet" />
<!-- Custom CSS -->
<link href="template/dist/css/style.min.css" rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.10.1/main.min.js"></script>


</head>
<body>

	<div id="main-wrapper" data-theme="light" data-layout="vertical"
		data-navbarbg="skin6" data-sidebartype="full"
		data-sidebar-position="fixed" data-header-position="fixed"
		data-boxed-layout="full">
		
		<%@ include file="/includes/header.jsp"%>
		
		<%@ include file="/includes/sideBar.jsp"%>
		
		<div class="page-wrapper" style="display: block;">

		
			<div id='calendar'></div>

		</div>
	</div>


	<%@ include file="/includes/footer.jsp"%>


	<script src="script/jquery-3.3.1.min.js" type="text/javascript"></script>

	<script src="script/planning.js" type="text/javascript"></script>

</body>
</html>