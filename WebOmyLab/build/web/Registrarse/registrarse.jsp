<%-- 
    Document   : login
    Created on : 19 jun 2021, 21:30:25
    Author     : Mathius
--%>
<%@page import= "java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.swing.JOptionPane"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
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

        
        <title>JSP Page</title>
        
            
    </head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					Registrarse
				</span>
				<form class="login100-form validate-form p-b-33 p-t-5">
                                    
                                        <div class="wrap-input100 validate-input">
						<select class="input100" name="documento" placeholder="TipEnter usernameo de Documento"> 
                                                    <option>DNI</option>
                                                    <option>PASAPORTE</option>
                                                    <option>CARNET DE EXTRANJERIA</option>
                                                 </select>
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>
                                    
                                        <div class="wrap-input100 validate-input" data-validate = "Ingrese documento">
						<input class="input100" type="text" name="txtnro" placeholder="Nro de Documento">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>
                                        <div class="wrap-input100 validate-input" data-validate = "Ingrese nombre">
						<input class="input100" type="text" name="txtnom" placeholder="Nombre">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>
                                        <div class="wrap-input100 validate-input" data-validate = "Ingrese apellido">
						<input class="input100" type="text" name="txtape" placeholder="Apellido">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>
                                        
					<div class="wrap-input100 validate-input" data-validate = "Ingrese F.nacimiento">
						<input class="input100" type="text" name="txtfec" placeholder="Fecha Nacimiento">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100 validate-input" >
						<select class="input100" name="sexo">
                                                    <option>Masculino</option>
                                                    <option>Femenino</option>
                                                    <option>Otro</option>
                                                </select>
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>
                                        <div class="wrap-input100 validate-input" data-validate = "Ingrese direccion">
						<input class="input100" type="text" name="txtdir" placeholder="Direccion">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>
                                        <div class="wrap-input100 validate-input" data-validate = "Ingrese correo">
						<input class="input100" type="text" name="txtcor" placeholder="Correo">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>
                                        <div class="wrap-input100 validate-input" data-validate = "Ingrese celular">
						<input class="input100" type="text" name="txtcel" placeholder="Celular">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>
                                        <div class="wrap-input100 validate-input" data-validate = "Ingrese clave">
						<input class="input100" type="password" name="txtcla" placeholder="Clave">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>
					<div class="container-login100-form-btn m-t-32">
						<button class="login100-form-btn">
							Registrarse
						</button>
					</div>

				</form>
                            
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
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
       Connection con;
       Class.forName("com.mysql.jdbc.Driver");
       con=DriverManager.getConnection("jdbc:mysql://localhost:3309/laboratorio_omylab","root","");
       String doc,nom,ape,fec,sex,dir,cor,cel,cla;
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
       
       
       doc=request.getParameter("txtnro");
       nom=request.getParameter("txtnom");
       ape=request.getParameter("txtape");
       fec=request.getParameter("txtfec"); 
       sex=request.getParameter("sexo");
       dir=request.getParameter("txtdir");
       cor=request.getParameter("txtcor"); 
       cel=request.getParameter("txtcel");
       cla=request.getParameter("txtcla");
       
       if(doc!=null && nom!=null && ape!=null && fec!=null && sex!=null && dir!=null && cor!=null && cel!=null && cla!=null && tip!=null){
           PreparedStatement ps=con.prepareStatement("insert into cliente(nro_documento,"
                   + " nombre,"+"apellido,"+"fech_nacimiento,"+"sexo,"+"direccion,"+"correo,"+"celular,"+"clave,"+"idTipo_documento) values('"+doc+"','"+nom+"','"+ape+"','"+fec+"','"+sex+"','"+dir+"','"+cor+"','"+cel+"','"+cla+"','"+tip+"')");
           ps.executeUpdate();
           //JOptionPane.showMessageDialog(null,"Se Agrego Correctamete");           
           response.sendRedirect("../index.jsp");
       }
%>
