<%-- 
    Document   : login
    Created on : 19 jun 2021, 21:30:25
    Author     : Mathius
--%>
<%@page import= "java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.util.Date"%>
<%@page import= "java.text.SimpleDateFormat"%>
<%@page import="javax.swing.JOptionPane"%>


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
        
        	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">

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
          
          <!-- Login modal end-->
          <!-- Navbar Start-->
          <header class="nav-holder make-sticky">
            <div id="navbar" role="navigation" class="navbar navbar-expand-lg">
              <div class="container"><a href="index2.jsp" class="navbar-brand home"><img src="img/LogoOmylab.png" width=200 height=50 alt="Logo del laboratorio" class="d-none d-md-inline-block"><span class="sr-only">Página principal de Laboratorio OMYLAB</span></a>
                <button type="button" data-toggle="collapse" data-target="#navigation" class="navbar-toggler btn-template-outlined"><span class="sr-only">Toggle navigation</span><i class="fa fa-align-justify"></i></button>
                <div id="navigation" class="navbar-collapse collapse">
                  <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item nav-link active"><a href="../index2.jsp" class="nav-item nav-link active">Inicio</a></li>
                    <li class="nav-item nav-link"><a href="../nosotros.jsp"  class="nav-item nav-link">Sobre nosotros</a></li>
                    <li class="nav-item nav-link"><a href="../servicios.jsp"  class="nav-item nav-link">Servicios</a></li>
                    <li class="nav-item nav-link"><a href="../contacto.jsp"  class="nav-item nav-link">Contacto</a></li>
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
                  <h1 class="h2">Registrarse / Iniciar sesión</h1>
                </div>
                <div class="col-md-5">
                  <ul class="breadcrumb d-flex justify-content-end">
                    <li class="breadcrumb-item"><a href="index2.jsp">Inicio</a></li>
                    <li class="breadcrumb-item active">Registrarse / Iniciar sesión</li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
          <div id="content">
            <div class="container">
              <div class="row">
                <div class="col-lg-6">
                  <div class="box">
                    <h2 class="text-uppercase">Nueva cuenta</h2>
                    <p class="lead">¿Aún no es nuestro cliente registrado?</p>
                    <p>¡Con el registro con nosotros se te permite una rápida reserva para nuestros análisis y un acceso rápido tus resultados e historial! ¡Todo el proceso no te llevará más de un minuto!</p>
                    <br><p class="text-muted">Si tiene alguna pregunta, no dude en <a href="contacto.jsp">contactarnos</a> en nuestro centro de servicio al cliente el cual está trabajando para usted 24 horas al día, 7 días a la semana.</p>
                    <hr>
                    
                    <form action="" method="post">
                        <div class="form-group">
                          <label for="documento">Tipo de documento</label>
                          <input value="DNI" name="documento" readonly="" id="documento" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                          <label for="txtnro">Número de DNI</label>
                          <input name="txtnro" id="txtnro" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                          <label for="txtnom">Nombres</label>
                          <input name="txtnom" id="txtnom" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                          <label for="txtape">Apellidos</label>
                          <input name="txtape" id="txtape" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                          <label for="txtfec">Fecha de nacimiento</label>
                          <input name="txtfec" id="txtfec" type="date" class="form-control">
                        </div>
                        <div class="form-group">
                          <label for="sexo">Sexo</label>
                          <select name="sexo" class="form-control">
                              <option selected>Femenino</option>
                              <option>Masculino</option>
                          </select>
                        </div>
                        <div class="form-group">
                          <label for="txtdir">Dirección</label>
                          <input name="txtdir" id="txtdir" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                          <label for="txtcor">Correo electrónico</label>
                          <input name="txtcor" id="txtcor" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                          <label for="txtcel">Celular</label>
                          <input name="txtcel" id="txtcel" type="text" class="form-control">
                        </div>
                        <div class="form-group">
                          <label for="txtcla">Clave</label>
                          <input name="txtcla" id="txtcla" type="password" class="form-control">
                        </div>
                        <div class="text-center">
                          <button type="submit" class="btn btn-template-outlined"><i class="fa fa-user-md"></i> Registrar</button>
                        </div>
                    </form>
                    
                   
                  </div>
                </div>
                <div class="col-lg-6">
                  <div class="box">
                    <h2 class="text-uppercase">Login</h2>
                    <p class="lead">¿Ya es nuestro cliente?</p>
                    <hr>
                    <form>
                      <div class="form-group">
                        <label for="username">DNI</label>
                        <input name="username" id="username" type="text" class="form-control">
                      </div>
                      <div class="form-group">
                        <label for="pass">Clave</label>
                        <input name="pass" id="pass" type="password" class="form-control">
                      </div>
                      <div class="text-center">
                        <button type="submit" class="btn btn-template-outlined"><i class="fa fa-sign-in"></i>Ingresar</button>
                      </div>
                    </form>
                      <%          
            
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/laboratorio_omylab2","root","");
            //dni="71390996";
            
            String SQL="select nombre,apellido,nro_documento,clave from cliente";
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            
            String fech="";
            String tipo2="";
            Date date=new Date();
            SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
            fech=formatoFecha.format(date);
            
            String ape="";
            String nom="";
            String accion="";
            String cla="";
            String dni ="";
            String a="";
            String c="";
            dni=request.getParameter("username");
            cla=request.getParameter("pass");
            
            while (resultado.next()) {
                
                a=resultado.getString("nro_documento");
                c=resultado.getString("clave");
                nom=resultado.getString("nombre");
                ape=resultado.getString("apellido");
                if(a.equals(dni) && c.equals(cla)){
                    
                    tipo2="Iniciar Sesion";
                    accion= nom+" "+ape+" Inicio sesion";
                    PreparedStatement rs=con.prepareStatement("insert into historial_cliente(fecha,"
                   + " tipo,"+"accion,"+"nro_documento) values('"+fech+"','"+tipo2+"','"+accion+"','"+a+"')");
                    rs.executeUpdate();
           
                    response.sendRedirect("../index.jsp?id="+ resultado.getString("nro_documento"));
                 }

            }
            //response.sendRedirect("index.jsp");
            
%>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- GET IT-->
          <div class="get-it">
            <div class="container">
              <div class="row">
                <div class="col-lg-8 text-center p-3">
                  <h3>¿Desea realizarse un análisis?</h3>
                </div>
                <div class="col-lg-4 text-center p-3">   <a href="#" class="btn btn-template-outlined-white">Dirigirse</a></div>
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
                  <p class="text-uppercase"><strong>Universal Ltd.</strong><br>13/25 New Avenue <br>Newtown upon River <br>45Y 73J <br>England <br><strong>Great Britain</strong></p>
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
        
        	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->

<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>
      </body>
</html>

<%
       //CONECTANOD A LA BASE DE DATOS:
       
       String doc,nom2,ape2,fec,sex,dir,cor,cel,cla2;
       String tip="";
       String tipo = request.getParameter("documento");
       if("DNI".equals(tipo)){
           tip="1";
       }
       if("PASAPORTE".equals(tipo)){
           tip="5";
       }
       if("CARNET DE EXTRANJERIA".equals(tipo)){
           tip="6";
       }
       
       String fech2="";
       String tipo4="";
       String accion2="";
       Date date2=new Date();
       SimpleDateFormat formatoFecha2=new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
       fech2=formatoFecha2.format(date2);
       
       
       doc=request.getParameter("txtnro");
       nom2=request.getParameter("txtnom");
       ape2=request.getParameter("txtape");
       fec=request.getParameter("txtfec"); 
       sex=request.getParameter("sexo");
       dir=request.getParameter("txtdir");
       cor=request.getParameter("txtcor"); 
       cel=request.getParameter("txtcel");
       cla2=request.getParameter("txtcla");
       
       if(doc!=null && nom2!=null && ape2!=null && fec!=null && sex!=null && dir!=null && cor!=null && cel!=null && cla2!=null && tip!=null){
           PreparedStatement ps=con.prepareStatement("insert into cliente(nro_documento,"
                   + " nombre,"+"apellido,"+"fech_nacimiento,"+"sexo,"+"direccion,"+"correo,"+"celular,"+"clave,"+"idTipo_documento) values('"+doc+"','"+nom2+"','"+ape2+"','"+fec+"','"+sex+"','"+dir+"','"+cor+"','"+cel+"','"+cla2+"','"+tip+"')");
           ps.executeUpdate();
           tipo4="Registrar Cliente";
           accion2= nom2+" "+ape2+" se registro";
           PreparedStatement rs=con.prepareStatement("insert into historial_cliente(fecha,"
                   + " tipo,"+"accion,"+"nro_documento) values('"+fech2+"','"+tipo4+"','"+accion2+"','"+doc+"')");
           rs.executeUpdate();
           
           //JOptionPane.showMessageDialog(null,"Se Agrego Correctamete");           
           response.sendRedirect("../index2.jsp");
       }
%>
