<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentification</title>
<link href="template/dist/css/style.min.css" rel="stylesheet">
</head>
<body>
<div class="main-wrapper">
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
        <!-- Preloader - style you can find in spinners.css -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Login box.scss -->
        <!-- ============================================================== -->
        <div class="auth-wrapper d-flex no-block justify-content-center align-items-center position-relative" style="background:url(template/assets/images/big/auth-bg.jpg) no-repeat center center;">
            <div class="auth-box row">
                <div class="col-lg-7 col-md-5 modal-bg-img" style="background-image: url(assets/images/big/3.jpg);">
                </div>
                <div class="col-lg-5 col-md-7 bg-white">
                    <div class="p-3">
                       
                        <h2 class="mt-3 text-center">Connectez-vous</h2>
                        <p class="text-center">Entrer votre email  et votre mot de passe  pour accéder aux espace admin </p>
                        <form class="mt-4" id="form-login" action="UserController" method="post">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="form-group" >
                                        <label class="text-dark" for="login">Email :</label>
                                        <input class="form-control" name="login" type="text" placeholder="Email">
                                    </div>
                                </div>
                                <div class="col-lg-12">
                                    <div class="form-group">
                                        <label class="text-dark" for="password">Mot de passe :</label>
                                        <input class="form-control" name="password" type="password"  placeholder=" Mot de passe">
                                    </div>
                                </div>
                                <div class="col-lg-12 text-center">
                                    <button  id ="connect"  type="submit" class="btn btn-block btn-primary" onclick="">Connexion</button>
                                </div>
                                
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- ============================================================== -->
        <!-- Login box.scss -->
        <!-- ============================================================== -->
    </div>
    <script type="text/javascript" src="script/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="script/login.js"></script>
    
</body>
</html>