<%-- 
    Document   : index2
    Created on : 28 jun 2021, 0:53:03
    Author     : Mathius
--%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Laboratorio OMYLAB</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="robots" content="all,follow">
        <link rel="stylesheet" href="https://unpkg.com/leaflet@1.6.0/dist/leaflet.css" integrity="sha512-xwE/Az9zrjBIphAcBb3F6JVqxf46+CDLwfLMHloNu6KEQCAWi6HcDUbeOfBIptF7tcCzusKFjFw2yuvEpDL9wQ==" crossorigin="">
        
        <!-- Bootstrap CSS-->
        <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
        <!-- Font Awesome CSS-->
        <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
        <!-- Google fonts - Roboto-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,700">
        <!-- Bootstrap Select-->
        <link rel="stylesheet" href="vendor/bootstrap-select/css/bootstrap-select.min.css">
        <!-- owl carousel-->
        <link rel="stylesheet" href="vendor/owl.carousel/assets/owl.carousel.css">
        <link rel="stylesheet" href="vendor/owl.carousel/assets/owl.theme.default.css">
        <!-- theme stylesheet-->
        <link rel="stylesheet" href="css/style.red.css" id="theme-stylesheet">
        <!-- Custom stylesheet - for your changes-->
        <link rel="stylesheet" href="css/custom.css">
        <!-- Favicon and apple touch icons-->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
        <link rel="apple-touch-icon" sizes="57x57" href="img/apple-touch-icon-57x57.png">
        <link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="76x76" href="img/apple-touch-icon-76x76.png">
        <link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="120x120" href="img/apple-touch-icon-120x120.png">
        <link rel="apple-touch-icon" sizes="144x144" href="img/apple-touch-icon-144x144.png">
        <link rel="apple-touch-icon" sizes="152x152" href="img/apple-touch-icon-152x152.png">
    </head>
     <body>
        <div id="all">
           <%
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/laboratorio_omylab2","root","");
            
            String nro=request.getParameter("id");//id es el parametro que bien de cargo
            String SQL="select * from cliente where nro_documento="+nro;
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
          %> 
          <!-- Top bar-->
          <div class="top-bar">
            <div class="container">
              <div class="row d-flex align-items-center">
                <div class="col-md-6 d-md-block d-none">
                  <p>Contactate con nosotros al 952112233 o envíanos un correo a laboratorioOMYLAB@gmail.com</p>
                </div>
                <div class="col-md-6">
                  <div class="d-flex justify-content-md-end justify-content-between">
                    <ul class="list-inline contact-info d-block d-md-none">
                      <li class="list-inline-item"><a href="#"><i class="fa fa-phone"></i></a></li>
                      <li class="list-inline-item"><a href="#"><i class="fa fa-envelope"></i></a></li>
                    </ul>
                    <div class="login"><a href="index2.jsp?id=<%= request.getParameter("id")%>"  class="login-btn">
                            <i class="fa fa-sign-in"></i><span class="d-none d-md-inline-block">Cerrar Sesión</span></a></div>
                    <ul class="social-custom list-inline">
                      <li class="list-inline-item"><a href="#"><i class="fa fa-facebook"></i></a></li>
                      <li class="list-inline-item"><a href="#"><i class="fa fa-google-plus"></i></a></li>
                      <li class="list-inline-item"><a href="#"><i class="fa fa-twitter"></i></a></li>
                      <li class="list-inline-item"><a href="#"><i class="fa fa-envelope"></i></a></li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- Top bar end-->
          
          <!-- Login modal end-->
          <!-- Navbar Start-->
             <header class="nav-holder make-sticky">
            <div id="navbar" role="navigation" class="navbar navbar-expand-lg">
              <div class="container"><a href="index2.jsp" class="navbar-brand home"><img src="img/LogoOmylab.png" width=200 height=50 alt="Logo del laboratorio" class="d-none d-md-inline-block"><span class="sr-only">Página principal de Laboratorio OMYLAB</span></a>
                <button type="button" data-toggle="collapse" data-target="#navigation" class="navbar-toggler btn-template-outlined"><span class="sr-only">Toggle navigation</span><i class="fa fa-align-justify"></i></button>
                <div id="navigation" class="navbar-collapse collapse">
                  <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item nav-link "><a href="index.jsp?id=<%= request.getParameter("id")%>" class="nav-item nav-link active">Inicio</a></li>
                    <li class="nav-item nav-link"><a href="nosotros2.jsp?id=<%= request.getParameter("id")%>"  class="nav-item nav-link">Sobre nosotros</a></li>
                    <li class="nav-item nav-link"><a href="servicios2.jsp?id=<%= request.getParameter("id")%>"  class="nav-item nav-link">Servicios</a></li>
                    <li class="nav-item nav-link active"><a href="contacto2.jsp?id=<%= request.getParameter("id")%>"  class="nav-item nav-link">Contacto</a></li>
                    <li class="nav-item nav-link"><a href="Orden/orden.jsp?id=<%= request.getParameter("id")%>"  class="nav-item nav-link">Reservar</a></li>
                    <li class="nav-item dropdown "><a href="javascript: void(0)" data-toggle="dropdown" class="dropdown-toggle">Mi perfil <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                          <li class="dropdown-item"><a href="Cliente/cliente.jsp?id=<%= request.getParameter("id")%>" class="nav-link">Mis datos</a></li>
                          <li class="dropdown-item"><a href="Orden/listar.jsp?id=<%= request.getParameter("id")%>" class="nav-link">Mis órdenes</a></li>
                        </ul>
                    </li>
                    
                  </ul>
                </div>
              </div>
            </div>
          </header>
          <!-- Navbar End-->

          <div id="heading-breadcrumbs" class="brder-top-0 border-bottom-0">
            <div class="container">
              <div class="row d-flex align-items-center flex-wrap">
                <div class="col-md-7">
                  <h1 class="h2">Contacto</h1>
                </div>
                <div class="col-md-5">
                  <ul class="breadcrumb d-flex justify-content-end">
                    <li class="breadcrumb-item"><a href="index.html">Inicio</a></li>
                    <li class="breadcrumb-item active">Contacto</li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
          <div id="content">
            <div id="contact" class="container">
              <section class="bar">
                <div class="row">
                  <div class="col-md-12">
                    <div class="heading">
                      <h2>Estamos aquí para ayudarte</h2>
                    </div>
                    <p class="lead">¿Tienes curiosidad por algo? ¿Tiene algún problema con nuestros análisis?</p>
                    <p class="text-sm">Si tiene alguna pregunta, no dude en contactarnos en nuestro centro de servicio al cliente el cual está trabajando para usted 24 horas al día, 7 días a la semana.</p>
                  </div>
                </div>
              </section>
              <section>
                <div class="row text-center">
                  <div class="col-md-4">
                    <div class="box-simple">
                      <div class="icon-outlined"><i class="fa fa-map-marker"></i></div>
                      <h3 class="h4">Dirección</h3>
                      <p>Av. Aviación N° 963<br>Frente al Hospital de la Solidaridad.<br>                                        Tacna,  <strong>Perú</strong></p>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="box-simple">
                      <div class="icon-outlined"><i class="fa fa-phone"></i></div>
                      <h3 class="h4">Teléfonos</h3>
                      
                      <p><strong>+51 920 111 222</strong></p>
                      <p>+51 920 333 444</p>
                    </div>
                  </div>
                  <div class="col-md-4">
                    <div class="box-simple">
                      <div class="icon-outlined"><i class="fa fa-envelope"></i></div>
                      <h3 class="h4">Soporte electrónico</h3>
                      <ul class="list-unstyled text-sm">
                        <li><strong><a href="mailto:">laboratorioOMYLAB@gmail.com</a></strong></li>
                        <li><a href="mailto:">oscarLopez@gmail.com</a></li>
                      </ul>
                    </div>
                  </div>
                </div>
              </section>
              <section class="bar pt-0">
                <div class="row">
                  
                </div>
              </section>
            </div>
            <div id="map"></div>
          </div>
          <!-- GET IT-->
          <div class="get-it">
            <div class="container">
              <div class="row">
                <div class="col-lg-8 text-center p-3">
                  <h3>¿Desea realizarse un análisis?</h3>
                  
                </div>
                <div class="col-lg-4 text-center p-3">   <a href="Registrarse/registrarse.jsp" class="btn btn-template-outlined-white">Iniciar sesión</a></div>
              </div>
            </div>
          </div>
          <!-- FOOTER -->
          <footer class="main-footer">
            <div class="container">
              <div class="row">
                <div class="col-lg-6">
                  <h4 class="h6">Sobre nosotros</h4>
                  <p>Laboratorios OMYLAB ofrece una gama completa de servicios de laboratorio médico con más de 100 pruebas entre pruebas de rutina, pruebas especiales y de genética.
</p>
                  
                </div>
               
                <div class="col-lg-6">
                  <h4 class="h6">Contacto</h4>
                  <p class="text-uppercase"><strong>Av. Aviación N° 963</strong><br>Frente al Hospital de la Solidaridad.<br>Tacna<br>Perú<br></p>
                  <a href="contacto.jsp" class="btn btn-template-main">Ve a contáctanos</a>
                  <hr class="d-block d-lg-none">
                </div>
               
              </div>
            </div>
            <div class="copyrights">
              <div class="container">
                <div class="row">
                  <div class="col-lg-12 text-center-md">
                    <p>&copy; 2021. OMYLAB / BME</p>
                  </div>
                  
                </div>
              </div>
            </div>
          </footer>
        </div>
        <!-- Javascript files-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/popper.js/umd/popper.min.js"> </script>
            <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
            <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
            <script src="vendor/waypoints/lib/jquery.waypoints.min.js"> </script>
            <script src="vendor/jquery.counterup/jquery.counterup.min.js"> </script>
            <script src="vendor/owl.carousel/owl.carousel.min.js"></script>
            <script src="vendor/owl.carousel2.thumbs/owl.carousel2.thumbs.min.js"></script>
            <script src="js/jquery.parallax-1.1.3.js"></script>
            <script src="vendor/bootstrap-select/js/bootstrap-select.min.js"></script>
            <script src="vendor/jquery.scrollto/jquery.scrollTo.min.js"></script>
            <!-- LeafletJS CDN-->
            <script src="https://unpkg.com/leaflet@1.6.0/dist/leaflet.js" integrity="sha512-gZwIG9x3wUXg2hdXF6+rVkLF/0Vi9U8D2Ntg4Ga5I5BZpVkVxlJWbSQtXPSiUTtC0TjtGOmxa1AJPuV0CPthew==" crossorigin=""></script>
            <script src="js/map.js"></script>
            <script src="js/front.js"></script>
      </body>
</html>
