/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEAnalisis_Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Mathius
 */
public class ClsNAnalisis_Producto {
    
    public static boolean MtdRegistrarAnalisis_Producto(ClsEAnalisis_Producto objEA) {
        
        try
        {
            String SQL="CALL USP_I_Analisis_has_Producto(?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objEA.getIdAnalisis());
            st.setInt(2, objEA.getIdProducto());
            st.setDouble(3, objEA.getCantidad());
            
            
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

    public boolean MtdModificarAnalisis_Producto(ClsEAnalisis_Producto objEA) {
        
        try
        {
            String SQL="CALL USP_U_Analisis_has_Producto (?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objEA.getIdAnalisis());
            st.setInt(2, objEA.getIdProducto());
            st.setDouble(3, objEA.getCantidad());
            
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

    public boolean MtdEliminarAnalisis_Producto(ClsEAnalisis_Producto objEA) {
        try
        {
            
            String SQL="CALL USP_D_Analisis_has_Producto(?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEA.getIdAnalisis());
            st.setInt(2, objEA.getIdProducto());
            
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

    public Iterable<ClsEAnalisis_Producto> MtdListarAnalisis_Producto() {
        
        try
        {
            String SQL="CALL USP_S_Analisis_has_Producto";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEAnalisis_Producto> lista=new ArrayList<>();
            ClsEAnalisis_Producto anali;
            
            while (resultado.next())
            {
                anali = new ClsEAnalisis_Producto();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                anali.setIdAnalisis(resultado.getInt("idAnalisis"));
                anali.setIdProducto(resultado.getInt("idProducto"));
                anali.setCantidad(resultado.getFloat("cantidad"));
                
                lista.add(anali);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEAnalisis_Producto> MtdBuscarAnalisis_Producto(ClsEAnalisis_Producto objEA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
