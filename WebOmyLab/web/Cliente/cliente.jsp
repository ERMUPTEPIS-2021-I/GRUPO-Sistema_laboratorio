<%-- 
    Document   : cliente
    Created on : 19 jun 2021, 18:04:43
    Author     : Mathius
--%>
<%@page import= "java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="container" style="width: 1500px; height: 1500px">
        <h1>PERFIL</h1>
           
        <hr>
        <%
            Connection con;
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3309/laboratorio_omylab","root","");
            
            String nro=request.getParameter("id");//id es el parametro que bien de cargo
            String SQL="select * from cliente where nro_documento="+nro;
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
          %>
          
        
        
        <!--<h3> <a class="btn btn-success btn-lg" href="agregar.jsp">Agregar Cliente</a></h3>-->
        <table class="table table-bordered" >
            <tr>
                <th class="text-center">Nro Documento</th>
                <th class="text-center">Nombre</th>
                <th class="text-center">Apellido</th>
                <th class="text-center">Fecha Nacimiento</th> 
                <th class="text-center">Sexo</th> 
                <th class="text-center">Direccion</th>
                <th class="text-center">Correo</th>
                <th class="text-center">Celular</th> 
                <th class="text-center">Clave</th>
                <th class="text-center">Acciones</th> 
            </tr>
            
            <%
                while (resultado.next()) {
            %>
            <tr>
               <td class="text-center"><%= resultado.getString("nro_documento") %></td>
               <td class="text-left"><%= resultado.getString("nombre") %></td>
               <td class="text-left"><%= resultado.getString("apellido") %></td>
               <td class="text-left"><%= resultado.getString("fech_nacimiento") %></td>
               <td class="text-left"><%= resultado.getString("sexo") %></td>
               <td class="text-left"><%= resultado.getString("direccion") %></td>
               <td class="text-left"><%= resultado.getString("correo") %></td>
               <td class="text-left"><%= resultado.getString("celular") %></td>
               <td class="text-left"><%= resultado.getString("clave") %></td>
               <td class="text-center">
                   
                   <a class="btn btn-warning btn-sm" href="editar.jsp?id=<%= resultado.getString("nro_documento")%>">Editar</a> 
                  
               </td>
            </tr>
                <% } %>
            
        </table>
        <hr>
        <h3> <a class="btn btn-info btn-lg"  href="../index2.jsp?id=<%= nro%>" >Inicio</a></h3>
   </div>
    </body>
</html>
<%
       //CONECTANOD A LA BASE DE DATOS:
       
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
           response.sendRedirect("cliente.jsp");
       }
%>