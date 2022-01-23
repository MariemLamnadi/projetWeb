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
    <link rel="icon" type="image/png" sizes="16x16" href="template/assets/images/favicon.png">
    <title>Gestion Clients</title>
    <!-- Custom CSS -->
    <link href="template/assets/extra-libs/c3/c3.min.css" rel="stylesheet">
    <link href="template/assets/libs/chartist/dist/chartist.min.css" rel="stylesheet">
    <link href="template/assets/extra-libs/jvector/jquery-jvectormap-2.0.2.css" rel="stylesheet" />
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
    <div id="main-wrapper" data-theme="light" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full" data-sidebar-position="fixed" data-header-position="fixed" data-boxed-layout="full">
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
					<div class="card-header">Ajouter un client</div>
						<div class="card-body">


							<input type="hidden" name="id"
								value="<%=request.getParameter("id") == null ? "" : request.getParameter("id")%>"
								size="id" />
							<div class="form-group">
								<label>Nom :</label> <input type="text" name="nom"
									class="form-control" id="nom" placeholder=""
									value="<%=request.getParameter("nom") == null ? "" : request.getParameter("nom")%>">
							</div>
							<div class="form-group">
								<label>Prenom :</label> <input type="text" name="prenom"
									class="form-control" id="prenom" placeholder=""
									value="<%=request.getParameter("prenom") == null ? "" : request.getParameter("prenom")%>">
							</div>
							<div class="form-group">
								<label>CIN :</label> <input type="text" name="cin"
									class="form-control" id="cin" 
									value="<%=request.getParameter("cin") == null ? "" : request.getParameter("cin")%>">
							</div>
							<div class="form-group">
								<label>Email :</label> <input type="email" name="email"
									class="form-control" id="email" 
									value="<%=request.getParameter("email") == null ? "" : request.getParameter("email")%>">
							</div>
							<div class="form-group">
								<label>MotDePasse :</label> <input type="password" name="password"
									class="form-control" id="password" 
									value="<%=request.getParameter("password") == null ? "" : request.getParameter("password")%>">
							</div>
						
						<button id="add" type="submit" class="btn btn-rounded btn-primary">Enregister</button>
</div>

					</div>
				</div>
			
			<div class="col md-6 ">
			
	<div class="card">
					<div class="card-header">Liste des client</div>
						<div class="card-body">

				<div class="table-responsive">
					<table class="table table-hover" id="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Nom</th>
								<th>Prenom</th>
								<th>CIN</th>
								<th>Email</th>
								<th>Password</th>
								<th>Actions</th>
							
							</tr>
						</thead>
						<tbody id="contenu" >

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
          
          
          
          
          
          
          >
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
    <script src="template/assets/libs/perfect-scrollbar/dist/perfect-scrollbar.jquery.min.js"></script>
    <script src="template/dist/js/sidebarmenu.js"></script>
    <!--Custom JavaScript -->
    <script src="template/dist/js/custom.min.js"></script>
    <!--This page JavaScript -->
    <script src="template/assets/extra-libs/c3/d3.min.js"></script>
    <script src="template/assets/extra-libs/c3/c3.min.js"></script>
    <script src="template/assets/libs/chartist/dist/chartist.min.js"></script>
    <script src="template/assets/libs/chartist-plugin-tooltips/dist/chartist-plugin-tooltip.min.js"></script>
    <script src="template/assets/extra-libs/jvector/jquery-jvectormap-2.0.2.min.js"></script>
    <script src="template/assets/extra-libs/jvector/jquery-jvectormap-world-mill-en.js"></script>
    <script src="template/dist/js/pages/dashboards/dashboard1.min.js"></script>

    <script type="text/javascript" src="script/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="script/clients.js"></script>
</body>
</body>
</html>