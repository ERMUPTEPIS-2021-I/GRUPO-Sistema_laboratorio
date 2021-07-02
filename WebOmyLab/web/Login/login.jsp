<%-- 
    Document   : login
    Created on : 19 jun 2021, 21:30:25
    Author     : Mathius
--%>
<%@page import= "java.sql.*" %>
<%@page import= "java.util.Date"%>
<%@page import= "java.text.SimpleDateFormat"%>
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
					Login
				</span>
				<form class="login100-form validate-form p-b-33 p-t-5">

					<div class="wrap-input100 validate-input" data-validate = "Enter username">
						<input class="input100" type="text" name="username" placeholder="User name">
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input class="input100" type="password" name="pass" placeholder="Password">
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
					</div>

					<div class="container-login100-form-btn m-t-32">
						<button class="login100-form-btn">
							Login
						</button>
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
           
                    response.sendRedirect("../index2.jsp?id="+ resultado.getString("nro_documento"));
                 }

            }
            //response.sendRedirect("index.jsp");
            
%>
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

