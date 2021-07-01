/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEProducto_detalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Mathius
 */
public class ClsNProducto_detalle {
    
    public static boolean MtdRegistrarProducto_detalle(ClsEProducto_detalle objEP) {
        
        try
        {
            String SQL="CALL USP_I_Producto_Detalle(?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setDouble(1, objEP.getCantidad());
            st.setString(2,objEP.getFech_vencimiento());
            st.setInt(3, objEP.getIdProducto());
            
            
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                //JOptionPane.showMessageDialog(null, "Error en procedimiento");
                return false;
            }
        } catch(SQLException e)
        {
                //JOptionPane.showMessageDialog(null, "Error en procedimiento"+e.getMessage());
            
                return false;         
        }
        
    }

    public boolean MtdModificarProducto_detalle(ClsEProducto_detalle objEP) {
        
        try
        {
            String SQL="CALL USP_U_Producto_Detalle (?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objEP.getIdProducto_detalle());
            st.setDouble(2, objEP.getCantidad());
            st.setString(3,objEP.getFech_vencimiento());
            st.setInt(4, objEP.getIdProducto());
            
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

    public boolean MtdEliminarProducto_detalle(ClsEProducto_detalle objEP) {
        try
        {
            
            String SQL="CALL USP_D_Producto_Detalle(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEP.getIdProducto_detalle());
            
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

    public Iterable<ClsEProducto_detalle> MtdListarProducto_detalle() {
        
        try
        {
            String SQL="CALL USP_S_Producto_Detalle";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEProducto_detalle> lista=new ArrayList<>();
            ClsEProducto_detalle prod;
            
            while (resultado.next())
            {
                prod = new ClsEProducto_detalle();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                prod.setIdProducto_detalle(resultado.getInt("idProducto_detalle"));
                prod.setCantidad(resultado.getDouble("cantidad"));
                prod.setFech_vencimiento(resultado.getString("fech_vencimiento"));
                prod.setIdProducto(resultado.getInt("idProducto"));
                
                lista.add(prod);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEProducto_detalle> MtdBuscarProducto_detalle(ClsEProducto_detalle objEP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
