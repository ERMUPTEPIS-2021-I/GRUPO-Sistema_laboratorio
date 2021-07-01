<%-- 
    Document   : cliente
    Created on : 19 jun 2021, 18:04:43
    Author     : Mathius
--%>
<%@page import= "java.sql.*" %>
<%@page import= "java.util.Date"%>
<%@page import= "java.text.SimpleDateFormat"%>
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
            
            //String ayuda=request.getParameter("id2");
            String nro=request.getParameter("id");
            //String total1="";
            //if(ayuda!=null){
                //nro=ayuda.split("-")[0];
                //total1= ayuda.split("-")[1];
            //}

            //id es el parametro que bien de cargo
            
            String SQL="select * from cliente where nro_documento="+nro;
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            String fech="";
            Date date=new Date();
            SimpleDateFormat formatoFecha=new SimpleDateFormat("YYYY/MM/dd HH:mm");
            fech=formatoFecha.format(date);
            String newfecha = fech.replace(" ", "T");
            String newfecha2 = newfecha.replace("/", "-");
            while (resultado.next()){
          %>
        <h1>RESERVAR ORDEN</h1>
        <hr>
        <h4><b>Registrar Reserva</b></h4>
            <form action="" method="post" style="width: 500px; height: 200px">
                <table>
                
                <tr>
                    <td>NRO DOCUMENTO:&nbsp; </td>   
                    <td><input type="text" readonly="" name="txtdoc" value="<%= resultado.getString("nro_documento")%>"/></td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td>FECHA:&nbsp; </td>  
                    <td><input type="datetime-local"  name="txtfec" min="<%= newfecha2%>"/></td>
                </tr>
                <tr><td><br></td></tr>
                <tr>
                    <td>ESTADO:&nbsp; </td>  
                    <td><input type="text" readonly="" name="txtest" value="Pendiente"/></td>
                </tr>
                <tr><td><br></td></tr>
                
                
                
                
                </table>
               <input type="submit" value="Registrar Orden" />
                </form>

                <br>
                    <hr>
                <%}%>    
        <%  
            //Connection con;
            //Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3309/db_ejemplo","root","");
            //String SQL="CALL USP_S_ListarTodoslosCargos()";
            String SQL2="select idOrden,fecha,estado from orden where Cliente_nro_documento="+nro;
            PreparedStatement sr=con.prepareStatement(SQL2);
            ResultSet resultado2=sr.executeQuery();
            
          %>
          
        
        
        <!--<h3> <a class="btn btn-success btn-lg" href="agregar.jsp">Agregar Cliente</a></h3>-->
        <table class="table table-bordered">
            <tr>
                <th class="text-center">idOrden</th>
                <th class="text-center">Fecha</th>
                <th class="text-center">Estado</th>
                <th class="text-center">Costo S/.</th>
                <th class="text-center">Analisis</th>
 
            </tr>
            
            <%
                while (resultado2.next()) {
                    
            %>
            <tr>
               <td class="text-center"><%= resultado2.getString("idOrden") %></td>
               <td class="text-left"><%= resultado2.getString("fecha") %></td>
               <td class="text-left"><%= resultado2.getString("estado") %></td>
               <td class="text-left"> </td>
               <td class="text-left"> </td>


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
       String doc, fec,est;
       doc=request.getParameter("txtdoc");
       fec=request.getParameter("txtfec");
       est=request.getParameter("txtest");

       if(doc!=null && fec!=null && est!=null){
           PreparedStatement ps=con.prepareStatement("insert into orden(fecha,"
                   + " estado,"+"Cliente_nro_documento) values('"+fec+"','"+est+"','"+doc+"')");
           ps.executeUpdate();
           
           String SQL4="select idOrden from orden where Cliente_nro_documento="+nro;
           PreparedStatement se=con.prepareStatement(SQL4);
           ResultSet resultado4=se.executeQuery();
           String idO="";
            while (resultado4.next()) {
                idO= resultado4.getString("idOrden");
            }
           //JOptionPane.showMessageDialog(null,"Se Agrego Correctamete");           
           response.sendRedirect("agregar_analisis.jsp?id2="+ nro+"-"+idO);
       }
%>


