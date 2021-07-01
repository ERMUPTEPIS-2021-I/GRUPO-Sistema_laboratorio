/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEDoc_compra_venta_Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Mathius
 */
public class ClsNDoc_compra_venta_Producto {
    
    public static boolean MtdRegistrarDoc_compra_venta_Producto(ClsEDoc_compra_venta_Producto objED) {
        
        try
        {
            String SQL="CALL USP_I_Doc_compra_venta_has_Producto(?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objED.getIdDoc_compra_venta());
            st.setInt(2, objED.getIdProducto());
            st.setDouble(3, objED.getPrecio_compra());
            st.setInt(4, objED.getCantidad());
            
            
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

    public boolean MtdModificarDoc_compra_venta_Producto(ClsEDoc_compra_venta_Producto objED) {
        
        try
        {
            String SQL="CALL USP_U_Doc_compra_venta_has_Producto (?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setInt(1, objED.getIdDoc_compra_venta());
            st.setInt(2, objED.getIdProducto());
            st.setDouble(3, objED.getPrecio_compra());
            st.setInt(4, objED.getCantidad());
            
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

    public boolean MtdEliminarDoc_compra_venta_Producto(ClsEDoc_compra_venta_Producto objED) {
        try
        {
            
            String SQL="CALL USP_D_Doc_compra_venta_has_Producto(?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objED.getIdDoc_compra_venta());
            st.setInt(2, objED.getIdProducto());
            
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

    public Iterable<ClsEDoc_compra_venta_Producto> MtdListarDoc_compra_venta_Producto() {
        
        try
        {
            String SQL="CALL USP_S_Doc_compra_venta_has_Producto";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEDoc_compra_venta_Producto> lista=new ArrayList<>();
            ClsEDoc_compra_venta_Producto doc;
            
            while (resultado.next())
            {
                doc = new ClsEDoc_compra_venta_Producto();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                doc.setIdDoc_compra_venta(resultado.getInt("idDoc_compra_venta"));
                doc.setIdProducto(resultado.getInt("idProducto"));
                doc.setPrecio_compra(resultado.getFloat("precio_compra"));
                doc.setCantidad(resultado.getInt("cantidad"));
                
                lista.add(doc);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEDoc_compra_venta_Producto> MtdBuscarDoc_compra_venta_Producto(ClsEDoc_compra_venta_Producto objED) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
