/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEProducto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Mathius
 */
public class ClsNProducto {
    
     public static boolean MtdRegistrarProducto(ClsEProducto objEP) {
        
        try
        {
            String SQL="CALL USP_I_Producto(?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objEP.getDescripcion());
            st.setDouble(2, objEP.getCantidad());
            st.setInt(3, objEP.getStock());
            st.setInt(4, objEP.getIdMarca());
            st.setInt(5, objEP.getIdTipo_producto());
            st.setInt(6, objEP.getIdTipo_medida());
            
            
            
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error procedimiento");
                return false;
            }
        } catch(SQLException e)
        {
                JOptionPane.showMessageDialog(null, "Error catch");            
                return false;         
        }
        
    }
     
     public boolean MtdModificarProductoStock(ClsEProducto objEP) {
        
        try
        {
            String SQL="CALL USP_U_Producto_Stock(?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objEP.getIdProducto());
            st.setInt(2, objEP.getStock());

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
     
     public boolean MtdModificarProductoStockCompra(ClsEProducto objEP) {
        
        try
        {
            String SQL="CALL USP_U_Producto_Stock_compra(?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objEP.getIdProducto());
            st.setInt(2, objEP.getStock());

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
    public boolean MtdModificarProducto(ClsEProducto objEP) {
        
        try
        {
            String SQL="CALL USP_U_Producto(?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objEP.getIdProducto());
            st.setString(2, objEP.getDescripcion());
            st.setDouble(3, objEP.getCantidad());
            st.setInt(4, objEP.getStock());
            st.setInt(5, objEP.getIdMarca());
            st.setInt(6, objEP.getIdTipo_producto());
            st.setInt(7, objEP.getIdTipo_medida());
            
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

    public boolean MtdEliminarProducto(ClsEProducto objEP) {
        try
        {
            
            String SQL="CALL USP_D_Producto(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objEP.getIdProducto());
            
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

    public Iterable<ClsEProducto> MtdListarProducto() {
        
        try
        {
            String SQL="CALL USP_S_Producto";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEProducto> lista=new ArrayList<>();
            ClsEProducto pro;
            
            while (resultado.next())
            {
                pro = new ClsEProducto();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                pro.setIdProducto(resultado.getInt("idProducto"));
                pro.setDescripcion(resultado.getString("descripcion"));
                pro.setCantidad(resultado.getDouble("cantidad"));
                pro.setStock(resultado.getInt("stock"));
                pro.setIdMarca(resultado.getInt("idMarca"));
                pro.setIdTipo_producto(resultado.getInt("idTipo_producto"));
                pro.setIdTipo_medida(resultado.getInt("idTipo_medida"));
                
                lista.add(pro);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEProducto> MtdBuscarProducto(ClsEProducto objEP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
