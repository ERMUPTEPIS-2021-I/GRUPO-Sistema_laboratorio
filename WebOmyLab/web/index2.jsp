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
                 String fech="";
                String tipo2="";
                String accion="";
                String nom="";
                String ape="";
                String nro=request.getParameter("id");//id es el parametro que bien de cargo
                if(nro!=null){
                    tipo2="Cerrar Sesion";
                    accion= nom+" "+ape+" cerro sesion";
                    PreparedStatement rs=con.prepareStatement("insert into historial_cliente(fecha,"
                       + " tipo,"+"accion,"+"nro_documento) values('"+fech+"','"+tipo2+"','"+accion+"','"+nro+"')");
                    rs.executeUpdate();
                    response.sendRedirect("index2.jsp");
                }
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
                    <div class="login"><a href="Registrarse/registrarse.jsp" class="login-btn">
                            <i class="fa fa-sign-in"></i><span class="d-none d-md-inline-block">Inicia sesión</span></a>
                            <a href="Registrarse/registrarse.jsp" class="signup-btn"><i class="fa fa-user"></i>
                                <span class="d-none d-md-inline-block">Regístrate</span></a></div>
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
          <!-- Login Modal-->
          <div id="login-modal" tabindex="-1" role="dialog" aria-labelledby="login-modalLabel" aria-hidden="true" class="modal fade">
            <div role="document" class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h4 id="login-modalLabel" class="modal-title">Iniciar Sesión</h4>
                  <button type="button" data-dismiss="modal" aria-label="Close" class="close"><span aria-hidden="true">×</span></button>
                </div>
                <div class="modal-body">
                  <form action="customer-orders.html" method="get">
                    <div class="form-group">
                      <input id="email_modal" type="text" placeholder="email" class="form-control">
                    </div>
                    <div class="form-group">
                      <input id="password_modal" type="password" placeholder="password" class="form-control">
                    </div>
                    <p class="text-center">
                      <button class="btn btn-template-outlined"><i class="fa fa-sign-in"></i> Ingresar</button>
                    </p>
                  </form>
                  <p class="text-center text-muted">¿Aun no estás registrado?</p>
                  <p class="text-center text-muted"><a href="Registrarse/registrarse.jsp"><strong>¡Regístrate ahora!</strong></a></p>
                </div>
              </div>
            </div>
          </div>
          <!-- Login modal end-->
          <!-- Navbar Start-->
          <header class="nav-holder make-sticky">
            <div id="navbar" role="navigation" class="navbar navbar-expand-lg">
              <div class="container"><a href="index2.jsp" class="navbar-brand home"><img src="img/LogoOmylab.png" width=200 height=50 alt="Logo del laboratorio" class="d-none d-md-inline-block"><span class="sr-only">Página principal de Laboratorio OMYLAB</span></a>
                <button type="button" data-toggle="collapse" data-target="#navigation" class="navbar-toggler btn-template-outlined"><span class="sr-only">Toggle navigation</span><i class="fa fa-align-justify"></i></button>
                <div id="navigation" class="navbar-collapse collapse">
                  <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item nav-link active"><a href="index2.jsp" class="nav-item nav-link active">Inicio</a></li>
                    <li class="nav-item nav-link"><a href="nosotros.jsp"  class="nav-item nav-link">Sobre nosotros</a></li>
                    <li class="nav-item nav-link"><a href="servicios.jsp"  class="nav-item nav-link">Servicios</a></li>
                    <li class="nav-item nav-link"><a href="contacto.jsp"  class="nav-item nav-link">Contacto</a></li>
                  </ul>
                </div>
              </div>
            </div>
          </header>
          <!-- Navbar End-->

          <section style="background: url('img/photogrid.jpg') center center repeat; background-size: cover;" class="relative-positioned">
            <!-- Carousel Start-->
            <div class="home-carousel">
              <div class="dark-mask mask-primary"></div>
              <div class="container">
                <div class="homepage owl-carousel">
                  <div class="item">
                    <div class="row">
                      <div class="col-md-5 text-right">
                        <p><img src="img/logo.png" alt="" class="ml-auto"></p>
                        <h1>Multipurpose responsive theme</h1>
                        <p>Business. Corporate. Agency.<br>Portfolio. Blog. E-commerce.</p>
                      </div>
                      <div class="col-md-7"><img src="img/template-homepage.png" alt="" class="img-fluid"></div>
                    </div>
                  </div>
                  <div class="item">
                    <div class="row">
                      <div class="col-md-7 text-center"><img src="img/template-mac.png" alt="" class="img-fluid"></div>
                      <div class="col-md-5">
                        <h2>46 HTML pages full of features</h2>
                        <ul class="list-unstyled">
                          <li>Sliders and carousels</li>
                          <li>4 Header variations</li>
                          <li>Google maps, Forms, Megamenu, CSS3 Animations and much more</li>
                          <li>+ 11 extra pages showing template features</li>
                        </ul>
                      </div>
                    </div>
                  </div>
                  <div class="item">
                    <div class="row">
                      <div class="col-md-5 text-right">
                        <h1>Design</h1>
                        <ul class="list-unstyled">
                          <li>Clean and elegant design</li>
                          <li>Full width and boxed mode</li>
                          <li>Easily readable Roboto font and awesome icons</li>
                          <li>7 preprepared colour variations</li>
                        </ul>
                      </div>
                      <div class="col-md-7"><img src="img/template-easy-customize.png" alt="" class="img-fluid"></div>
                    </div>
                  </div>
                  <div class="item">
                    <div class="row">
                      <div class="col-md-7"><img src="img/template-easy-code.png" alt="" class="img-fluid"></div>
                      <div class="col-md-5">
                        <h1>Easy to customize</h1>
                        <ul class="list-unstyled">
                          <li>7 preprepared colour variations.</li>
                          <li>Easily to change fonts</li>
                        </ul>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- Carousel End-->
          </section>
         
          
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
        <script src="js/front.js"></script>
      </body>
</html>
