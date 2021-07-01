<%-- 
    Document   : editar
    Created on : 19 jun 2021, 18:04:52
    Author     : Mathius
--%>
<%@page import="java.awt.TrayIcon.MessageType"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
        <%
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3309/laboratorio_omylab","root","");
            
            String nro=request.getParameter("id");//id es el parametro que bien de cargo
            String SQL="select * from cliente where nro_documento="+nro;
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            while (resultado.next()){
          %>
          <h1>Modificar Cliente</h1>
            <hr>
            <form action="" method="post"  style="width: 500px; height: 490px">
               <table>
                <tr>
                    <td>NRO DOCUMENTO:&nbsp; <td   
                    <td><input type="text" readonly="" value="<%= resultado.getString("nro_documento")%>"/></td>
                    
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td>NOMBRE:&nbsp; </td>  
                    <td><input type="text" name="txtnom" value="<%= resultado.getString("nombre")%>"/></td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td>APELLIDO:&nbsp; </td>  
                    <td><input type="text" name="txtape" value="<%= resultado.getString("apellido")%>"/></td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td>FECHA NACIMIENTO:&nbsp; </td>  
                    <td><input type="text" name="txtfec" value="<%= resultado.getString("fech_nacimiento")%>"/></td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td>SEXO:&nbsp; </td>  
                    <td><select name="sexo" >
                            <option Selected><%= resultado.getString("sexo")%></option>
                            <option>Masculino</option>
                            <option>Femenino</option>
                            <option>Otro</option>
                        </select></td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td>DIRECCION:&nbsp; </td>  
                    <td><input type="text" name="txtdir" value="<%= resultado.getString("direccion")%>"/></td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td>CORREO:&nbsp; </td>  
                    <td><input type="text" name="txtcor" value="<%= resultado.getString("correo")%>"/></td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td>CELULAR:&nbsp; </td>  
                    <td><input type="text" name="txtcel" value="<%= resultado.getString("celular")%>"/></td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td>CLAVE:&nbsp; </td>  
                    <td><input type="text" name="txtcla" value="<%= resultado.getString("clave")%>"/></td>
                </tr>               
                </table>
               <br>
               <input type="submit" value="Guardar"/>
               <a href="cliente.jsp?id=<%= nro%>">Regresar</a>
            </form>
         <%}%>
         </div>
    </body>
</html>
<%
       //CONECTANOD A LA BASE DE DATOS:
       String nom,ape,fec,sex,dir,cor,cel,cla;
       
       nom=request.getParameter("txtnom");
       ape=request.getParameter("txtape");
       fec=request.getParameter("txtfec"); 
       sex=request.getParameter("sexo");
       dir=request.getParameter("txtdir");
       cor=request.getParameter("txtcor"); 
       cel=request.getParameter("txtcel");
       cla=request.getParameter("txtcla");
       if(nom!=null && ape!=null && fec!=null && sex!=null && dir!=null && cor!=null && cel!=null && cla!=null){
           PreparedStatement ps=con.prepareStatement("update cliente set nombre='"+nom +"',apellido='"+ape+"',fech_nacimiento='"+fec+"',sexo='"+sex+"',direccion='"+dir+"',correo='"+cor+"',celular='"+cel+"',clave='"+cla+"' where nro_documento="+nro);
           ps.executeUpdate();
           response.sendRedirect("cliente.jsp?id="+ nro);
       }
    %>