<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="template/assets/images/favicon.png">
<title>Gestion Crenaeux</title>
<!-- Custom CSS -->
<link href="template/assets/extra-libs/c3/c3.min.css" rel="stylesheet">
<link href="template/assets/libs/chartist/dist/chartist.min.css"
	rel="stylesheet">
<link
	href="template/assets/extra-libs/jvector/jquery-jvectormap-2.0.2.css"
	rel="stylesheet" />
<!-- Custom CSS -->
<link href="template/dist/css/style.min.css" rel="stylesheet">

</head>
<body>
<body>
	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->
	<div class="preloader" style="display: none;">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>
	<!-- ============================================================== -->
	<!-- Main wrapper - style you can find in pages.scss -->
	<!-- ============================================================== -->
	<div id="main-wrapper" data-theme="light" data-layout="vertical"
		data-navbarbg="skin6" data-sidebartype="full"
		data-sidebar-position="fixed" data-header-position="fixed"
		data-boxed-layout="full">
		<!-- ============================================================== -->
		<!-- Topbar header - style you can find in pages.scss -->
		<!-- ============================================================== -->
		<%@ include file="/includes/header.jsp"%>
		<!-- ============================================================== -->
		<!-- End Topbar header -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<%@ include file="/includes/sideBar.jsp"%>
		<!-- ============================================================== -->
		<!-- End Left Sidebar - style you can find in sidebar.scss  -->
		<!-- ============================================================== -->
		<!-- ============================================================== -->
		<!-- Page wrapper  -->
		<!-- ============================================================== -->
		<div class="page-wrapper" style="display: block;">


			<div class="main-panel">
				<div class="content-wrapper">

					<div class="row">
						<div class="col-lg-6 ">
							<div class="card">
								<div class="card-header">Ajouter une créneau</div>
								<div class="card-body">

									<div class="form-group">
										<label>Heure Debut :</label> <input type="time"
											name="heurDebut" class="form-control" id="heurDebut"
											placeholder=""
											value="<%=request.getParameter("heurDebut") == null ? "" : request.getParameter("heurDebut")%>">
									</div>
									<div class="form-group">
										<label>Heure Fin :</label> <input type="time" name="heurFin"
											class="form-control" id="heurFin" placeholder=""
											value="<%=request.getParameter("heurFin") == null ? "" : request.getParameter("heurFin")%>">
									</div>

									<button id="add" type="submit" class="btn btn-rounded btn-primary">Enregistrer</button>
								</div>

							</div>
						</div>

						<div class="col md-6 ">

							<div class="card">
								<div class="card-header">Liste des creneaux</div>
								<div class="card-body">

									<div class="table-responsive">
										<table class="table table-hover" id="table">
											<thead>
												<tr>
													<th>Id</th>
													<th>Heure Debut</th>
													<th>Heure Fin</th>

													<th>Actions</th>

												</tr>
											</thead>
											<tbody id="content">

											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>

		<%@ include file="/includes/footer.jsp"%>


	</div>
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- End Wrapper -->
	<!-- ============================================================== -->
	<!-- All Jquery -->
	<!-- ============================================================== -->
	<script src="template/assets/libs/jquery/dist/jquery.min.js"></script>
	<script src="template/assets/libs/popper.js/dist/umd/popper.min.js"></script>
	<script src="template/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>

	<script src="template/dist/js/app-style-switcher.js"></script>
	<script src="template/dist/js/feather.min.js"></script>
	<script
		src="template/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
	<script src="template/dist/js/sidebarmenu.js"></script>
	<!--Custom JavaScript -->
	<script src="template/dist/js/custom.min.js"></script>
	<!--This page JavaScript -->
	<script src="template/assets/extra-libs/c3/d3.min.js"></script>
	<script src="template/assets/extra-libs/c3/c3.min.js"></script>
	<script src="template/assets/libs/chartist/dist/chartist.min.js"></script>
	<script
		src="template/assets/libs/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
	<script
		src="template/assets/extra-libs/jvector/jquery-jvectormap-2.0.2.min.js"></script>
	<script
		src="template/assets/extra-libs/jvector/jquery-jvectormap-world-mill-en.js"></script>
	<script src="template/dist/js/pages/dashboards/dashboard1.min.js"></script>

	<script type="text/javascript" src="script/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="script/creneaux.js"></script>
</body>
</body>
</html>