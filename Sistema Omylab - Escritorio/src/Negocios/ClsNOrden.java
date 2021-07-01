/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEOrden;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Mathius
 */
public class ClsNOrden {
    
    public static boolean MtdRegistrarOrden(ClsEOrden objEO) {
        
        try
        {
            String SQL="CALL USP_I_Orden(?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objEO.getFecha());
            st.setString(2, objEO.getEstado());
            st.setString(3, objEO.getCliente_nro_documento());
            st.setString(4, objEO.getEmpleado_nro_documento());
            
            
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch(SQLException e)
        {
                return false;         
        }
        
    }

    public boolean MtdModificarOrden(ClsEOrden objEO) {
        
        try
        {
            String SQL="CALL USP_U_Orden(?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objEO.getIdOrden());
            st.setString(2, objEO.getFecha());
            st.setString(3, objEO.getEstado());
            st.setString(4, objEO.getCliente_nro_documento());
            st.setString(5, objEO.getEmpleado_nro_documento());
            
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
            
        } catch(SQLException e){
                return false;         
            }
    }

    public boolean MtdEliminarOrden(ClsEOrden objEO) {
        try
        {
            
            String SQL="CALL USP_D_Orden(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEO.getIdOrden());
            
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }catch(SQLException e){
                return false;         
            }
    }

    public Iterable<ClsEOrden> MtdListarOrden() {
        
        try
        {
            String SQL="CALL USP_S_Orden";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEOrden> lista=new ArrayList<>();
            ClsEOrden ord;
            
            while (resultado.next())
            {
                ord = new ClsEOrden();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                ord.setIdOrden(resultado.getInt("idOrden"));
                ord.setFecha(resultado.getString("fecha"));
                ord.setEstado(resultado.getString("estado"));
                ord.setCliente_nro_documento(resultado.getString("Cliente_nro_documento"));
                ord.setEmpleado_nro_documento(resultado.getString("Empleado_nro_documento"));
                
                lista.add(ord);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEOrden> MtdBuscarOrden(ClsEOrden objEO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
