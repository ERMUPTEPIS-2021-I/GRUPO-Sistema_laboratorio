/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsETipo_producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsNTipo_producto {
    public static boolean MtdRegistrarTipo_producto(ClsETipo_producto objETP) {
        
        try
        {
            String SQL="CALL USP_I_Tipo_producto(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objETP.getDescripcion());
            
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

    public boolean MtdModificarTipo_producto(ClsETipo_producto objETP) {
        
        try
        {
            String SQL="CALL USP_U_Tipo_producto (?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objETP.getIdTipo_producto());
            st.setString(2, objETP.getDescripcion());
            
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

    public boolean MtdEliminarTipo_producto(ClsETipo_producto objETP) {
        try
        {
            
            String SQL="CALL USP_D_Tipo_producto(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objETP.getIdTipo_producto());
            
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

    public Iterable<ClsETipo_producto> MtdListarTipo_producto() {
        
        try
        {
            String SQL="CALL USP_S_Tipo_producto";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsETipo_producto> lista=new ArrayList<>();
            ClsETipo_producto tdoc;
            
            while (resultado.next())
            {
                tdoc = new ClsETipo_producto();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                tdoc.setIdTipo_producto(resultado.getInt("idTipo_producto"));
                tdoc.setDescripcion(resultado.getString("descripcion"));
                
                lista.add(tdoc);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsETipo_producto> MtdBuscarTipo_producto(ClsETipo_producto objETP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
