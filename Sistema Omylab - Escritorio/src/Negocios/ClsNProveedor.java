/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEProveedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsNProveedor {
    public static boolean MtdRegistrarProveedor(ClsEProveedor objEP) {
        
        try
        {
            String SQL="CALL USP_I_Proveedor(?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objEP.getNro_documento());
            st.setString(2, objEP.getRazon_social());
            st.setString(3, objEP.getDireccion());
            st.setString(4, objEP.getCelular());
            st.setInt(5, objEP.getEstado());            
            st.setInt(6, objEP.getIdTipo_documento());
            
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

    public boolean MtdModificarProveedor(ClsEProveedor objEP) {
        
        try
        {
            String SQL="CALL USP_U_Proveedor (?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objEP.getNro_documento());
            st.setString(2, objEP.getRazon_social());
            st.setString(3, objEP.getDireccion());
            st.setString(4, objEP.getCelular());
            st.setInt(5, objEP.getEstado());            
            st.setInt(6, objEP.getIdTipo_documento());
            
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

    public boolean MtdEliminarProveedor(ClsEProveedor objEP) {
        try
        {
            
            String SQL="CALL USP_D_Proveedor(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEP.getNro_documento());
            
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

    public Iterable<ClsEProveedor> MtdListarProveedor() {
        
        try
        {
            String SQL="CALL USP_S_Proveedor";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEProveedor> lista=new ArrayList<>();
            ClsEProveedor emp;
            
            while (resultado.next())
            {
                emp = new ClsEProveedor();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                emp.setNro_documento(resultado.getString("nro_documento"));
                emp.setRazon_social(resultado.getString("razon_social"));
                emp.setDireccion(resultado.getString("direccion"));    
                emp.setCelular(resultado.getString("celular"));
                emp.setEstado(resultado.getInt("estado"));
                emp.setIdTipo_documento(resultado.getInt("idTipo_documento"));
                
                lista.add(emp);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEProveedor> MtdBuscarProveedor(ClsEProveedor objEP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
