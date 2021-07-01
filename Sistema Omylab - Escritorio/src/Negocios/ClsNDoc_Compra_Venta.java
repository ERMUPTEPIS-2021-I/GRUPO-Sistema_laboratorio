/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEDoc_Compra_Venta;
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
public class ClsNDoc_Compra_Venta {
    
    public static boolean MtdRegistrarDoc_Compra_Venta(ClsEDoc_Compra_Venta objED) {
        
        try
        {
            String SQL="CALL USP_I_Doc_compra_venta(?,?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objED.getNro_documento());
            st.setString(2, objED.getRazon_social());
            st.setString(3, objED.getFecha());
            st.setString(4, objED.getTipo());            
            st.setDouble(5, objED.getTotal());
            st.setInt(6, objED.getEstado());            
            st.setInt(7, objED.getIdTipo_documento());
            st.setInt(8, objED.getIdOrden());
            st.setString(9, objED.getProveedor_nro_documento());
            
            
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error del procedimiento");
                
                return false;
            }
        } catch(SQLException e)
        {
                JOptionPane.showMessageDialog(null, e.getMessage());
            
                return false;         
        }
        
    }
    
    public static boolean MtdRegistrarDoc_Compra(ClsEDoc_Compra_Venta objED) {
        
        try
        {
            String SQL="CALL USP_I_Doc_compra(?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objED.getNro_documento());
            st.setString(2, objED.getRazon_social());
            st.setString(3, objED.getFecha());
            st.setString(4, objED.getTipo());            
            st.setDouble(5, objED.getTotal());
            st.setInt(6, objED.getEstado());            
            st.setInt(7, objED.getIdTipo_documento());
            st.setString(8, objED.getProveedor_nro_documento());
            
            
            if(st.executeUpdate()>0)
            {
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error del procedimiento");
                
                return false;
            }
        } catch(SQLException e)
        {
                JOptionPane.showMessageDialog(null, e.getMessage());
            
                return false;         
        }
        
    }

    public boolean MtdModificarDoc_Compra_Venta(ClsEDoc_Compra_Venta objED) {
        
        try
        {
            String SQL="CALL USP_U_Doc_compra_venta(?,?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objED.getNro_documento());
            st.setString(2, objED.getRazon_social());
            st.setString(3, objED.getFecha());
            st.setString(4, objED.getTipo());            
            st.setDouble(5, objED.getTotal());
            st.setInt(6, objED.getEstado());            
            st.setInt(7, objED.getIdTipo_documento());
            st.setInt(8, objED.getIdOrden());
            st.setString(9, objED.getProveedor_nro_documento());
            
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

    public boolean MtdEliminarDoc_Compra_Venta(ClsEDoc_Compra_Venta objED) {
        try
        {
            
            String SQL="CALL USP_D_Doc_compra_venta(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setInt(1, objED.getIdDoc_compra_venta());
            
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

    public Iterable<ClsEDoc_Compra_Venta> MtdListarDoc_Compra_Venta() {
        
        try
        {
            String SQL="CALL USP_S_Doc_compra_venta";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEDoc_Compra_Venta> lista=new ArrayList<>();
            ClsEDoc_Compra_Venta doc;
            
            while (resultado.next())
            {
                doc = new ClsEDoc_Compra_Venta();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                doc.setIdDoc_compra_venta(resultado.getInt("idDoc_compra_venta"));
                doc.setNro_documento(resultado.getString("nro_documento"));
                doc.setRazon_social(resultado.getString("razon_social"));
                doc.setFecha(resultado.getString("fecha"));
                doc.setTipo(resultado.getString("tipo"));
                
                doc.setTotal(resultado.getDouble("total"));
                doc.setEstado(resultado.getInt("estado"));                
                doc.setIdTipo_documento(resultado.getInt("idTipo_documento"));
                doc.setIdOrden(resultado.getInt("idOrden"));
                doc.setProveedor_nro_documento(resultado.getString("Proveedor_nro_documento"));
                
                
                lista.add(doc);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }
    
    public Iterable<ClsEDoc_Compra_Venta> MtdListarDoc_Venta() {
        
        try
        {
            String SQL="CALL USP_S_Doc_compra_venta_Ventas";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEDoc_Compra_Venta> lista=new ArrayList<>();
            ClsEDoc_Compra_Venta doc;
            
            while (resultado.next())
            {
                doc = new ClsEDoc_Compra_Venta();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                doc.setIdDoc_compra_venta(resultado.getInt("idDoc_compra_venta"));
                doc.setNro_documento(resultado.getString("nro_documento"));
                doc.setRazon_social(resultado.getString("razon_social"));
                doc.setFecha(resultado.getString("fecha"));
                doc.setTipo(resultado.getString("tipo"));
                
                doc.setTotal(resultado.getDouble("total"));
                doc.setEstado(resultado.getInt("estado"));                
                doc.setIdTipo_documento(resultado.getInt("idTipo_documento"));
                doc.setIdOrden(resultado.getInt("idOrden"));
                doc.setProveedor_nro_documento(resultado.getString("Proveedor_nro_documento"));
                
                
                lista.add(doc);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }
    
    public Iterable<ClsEDoc_Compra_Venta> MtdListarDoc_Compra() {
        
        try
        {
            String SQL="CALL USP_S_Doc_compra_venta_Compras";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEDoc_Compra_Venta> lista=new ArrayList<>();
            ClsEDoc_Compra_Venta doc;
            
            while (resultado.next())
            {
                doc = new ClsEDoc_Compra_Venta();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                doc.setIdDoc_compra_venta(resultado.getInt("idDoc_compra_venta"));
                doc.setNro_documento(resultado.getString("nro_documento"));
                doc.setRazon_social(resultado.getString("razon_social"));
                doc.setFecha(resultado.getString("fecha"));
                doc.setTipo(resultado.getString("tipo"));
                
                doc.setTotal(resultado.getDouble("total"));
                doc.setEstado(resultado.getInt("estado"));                
                doc.setIdTipo_documento(resultado.getInt("idTipo_documento"));
                doc.setIdOrden(resultado.getInt("idOrden"));
                doc.setProveedor_nro_documento(resultado.getString("Proveedor_nro_documento"));
                
                
                lista.add(doc);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEDoc_Compra_Venta> MtdBuscarDoc_Compra_Venta(ClsEDoc_Compra_Venta objED) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
