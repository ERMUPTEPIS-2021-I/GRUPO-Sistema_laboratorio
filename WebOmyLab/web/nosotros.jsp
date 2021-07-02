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
          
          <!-- Login modal end-->
          <!-- Navbar Start-->
          <header class="nav-holder make-sticky">
            <div id="navbar" role="navigation" class="navbar navbar-expand-lg">
              <div class="container"><a href="index2.jsp" class="navbar-brand home"><img src="img/LogoOmylab.png" width=200 height=50 alt="Logo del laboratorio" class="d-none d-md-inline-block"><span class="sr-only">Página principal de Laboratorio OMYLAB</span></a>
                <button type="button" data-toggle="collapse" data-target="#navigation" class="navbar-toggler btn-template-outlined"><span class="sr-only">Toggle navigation</span><i class="fa fa-align-justify"></i></button>
                <div id="navigation" class="navbar-collapse collapse">
                  <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item nav-link "><a href="index2.jsp" class="nav-item nav-link ">Inicio</a></li>
                    <li class="nav-item nav-link active"><a href="nosotros.jsp"  class="nav-item nav-link active">Sobre nosotros</a></li>
                    <li class="nav-item nav-link"><a href="servicios.jsp"  class="nav-item nav-link">Servicios</a></li>
                    <li class="nav-item nav-link "><a href="contacto.jsp"  class="nav-item nav-link">Contacto</a></li>
                  </ul>
                </div>
              </div>
            </div>
          </header>
          <!-- Navbar End-->

          <div id="heading-breadcrumbs">
            <div class="container">
              <div class="row d-flex align-items-center flex-wrap">
                <div class="col-md-7">
                  <h1 class="h2">Sobre nosotros</h1>
                </div>
                <div class="col-md-5">
                  <ul class="breadcrumb d-flex justify-content-end">
                    <li class="breadcrumb-item"><a href="index.html">Inicio</a></li>
                    <li class="breadcrumb-item active">Sobre nosotros</li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
          <div id="content">
            <div class="container">
              <section class="bar">
                <div class="row">
                  <div class="col-lg-12">
                    <div class="heading">
                      <h2>General</h2>
                    </div>
                    <p class="lead">Nuestro laboratorio clínico reúne en un mismo espacio los servicios de exámenes médicos de alta y baja complejidad a cargo de médicos especialistas, lo que aumenta la eficacia al momento de resolver diagnósticos complejos y, a la vez, permite acelerar el tiempo de entrega de los resultados. Tenemos más de 20 años experiencia al servicio de la ciudad de Tacna.</p>
                  </div>
                </div>
                <div class="row">
                  <div class="col-lg-8">
                    <div id="accordion" role="tablist">
                      <div class="card">
                        <div id="headingOne" role="tab" class="card-header">
                          <h4 class="mb-0 mt-0"><a data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">Visión</a></h4>
                        </div>
                        <div id="collapseOne" role="tabpanel" aria-labelledby="headingOne" data-parent="#accordion" class="collapse show">
                          <div class="card-body">
                            <div class="row">
                              <div class="col-md-12">
                                <p>Empresa privada responsable y moderna, reconocida por brindar servicios de calidad.</p>
                               </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="card">
                        <div id="headingOne" role="tab" class="card-header">
                          <h4 class="mb-0 mt-0"><a data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">Misión</a></h4>
                        </div>
                        <div id="collapseOne" role="tabpanel" aria-labelledby="headingOne" data-parent="#accordion" class="collapse show">
                          <div class="card-body">
                            <div class="row">
                              <div class="col-md-12">
                                <p>Ser uno de los laboratorios de mayor prestigio y calidad de análisis, personal e infraestructura en la ciudad de Tacna.</p>
                               </div>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="card">
                        <div id="headingOne" role="tab" class="card-header">
                          <h4 class="mb-0 mt-0"><a data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">Valores corporativos</a></h4>
                        </div>
                        <div id="collapseOne" role="tabpanel" aria-labelledby="headingOne" data-parent="#accordion" class="collapse show">
                          <div class="card-body">
                            <div class="row">
                              <div class="col-md-12">
                                  <ul class="list-group">
                                    <li class="list-group-item">Calidad en el servicio: La satisfacción total de las necesidades de los clientes y usuarios
                                        mediante la realización de las actividades esencialmente intangibles con un valor agregado y el
                                        cumplimiento de los requisitos adecuados al servicio.</li>
                                    <li class="list-group-item">Coherencia en el pensar, sentir y actuar: Armonía entre pensamiento, sentimiento, palabra y acción. Se manifiesta
                                        con actitudes correctas, claras, transparentes y éticas, necesarias para lograr el mayor beneficio de nuestros clientes y usuarios.</li>
                                    <li class="list-group-item">Compromiso hacia el logro de objetivos: Trabajar en todo momento con sentido de visión,
                                        sumando esfuerzos para alcanzar los objetivos.</li>
                                    <li class="list-group-item">Ética en el trabajo: Principios y normas, que regulan la atención en salud 
                                        y tienen como fundamento ineludible el comportamiento y las relaciones establecidas entre el personal, los clientes y usuarios. </li>
                                    <li class="list-group-item">Honestidad: Corresponder a la confianza que la empresa ha depositado en nosotros, observando
                                        una conducta recta y honorable en nuestras actividades cotidianas.</li>
                                    <li class="list-group-item">Igualdad con los Clientes/Usuarios: Escuchar las sugerencias y reclamos de los clientes/usuarios, brindarles información
                                        clara, completa y oportuna. </li>
                                    <li class="list-group-item">Igualdad con los empleados: Tener derecho a los mismos beneficios y gozar de 
                                        las mismas libertades, asignando tareas equitativas según las actividades de cada unidad. </li>
                                    <li class="list-group-item">Respeto y trato digno: Capacidad de reconocer los derechos ajenos y los propios. 
                                        El respeto se traduce en privacidad y nos induce a la cordialidad, armonía y aceptación de nuestros compañeros, clientes y usuarios.</li>
                                    <li class="list-group-item">Trabajo en equipo: Conjunto de personas con competencias técnicas y administrativas, comprometidas con una misión, 
                                        con objetivos específicos comunes y con procesos sinérgicos con el fin de lograr un alto desempeño en la atención, alcanzando
                                        resultados de calidad.</li>                                    
                                  </ul>
                               </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  
                </div>
              </section>
              
            </div>
            
            
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
        <script src="js/front.js"></script>
      </body>
</html>