/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsECliente;
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
public class ClsNCliente {
    public static boolean MtdRegistrarCliente(ClsECliente objEC) {
        
        try
        {
            String SQL="CALL USP_I_Cliente(?,?,?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objEC.getNro_documento());
            st.setString(2, objEC.getNombre());
            st.setString(3, objEC.getApellido());
            st.setString(4, objEC.getFech_nacimiento());
            st.setString(5, objEC.getSexo());
            st.setString(6, objEC.getDireccion());
            st.setString(7, objEC.getCorreo());
            st.setString(8, objEC.getCelular());
            st.setString(9, objEC.getClave());
            st.setInt(10, objEC.getIdTip_documento());
            
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

    public boolean MtdModificarCliente(ClsECliente objEC) {
        
        try
        {
            String SQL="CALL USP_U_Cliente (?,?,?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objEC.getNro_documento());
            st.setString(2, objEC.getNombre());
            st.setString(3, objEC.getApellido());
            st.setString(4, objEC.getFech_nacimiento());
            st.setString(5, objEC.getSexo());
            st.setString(6, objEC.getDireccion());
            st.setString(7, objEC.getCorreo());
            st.setString(8, objEC.getCelular());
            st.setString(9, objEC.getClave());
            st.setInt(10, objEC.getIdTip_documento());
            
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

    public boolean MtdEliminarCliente(ClsECliente objEC) {
        try
        {
            
            String SQL="CALL USP_D_Cliente(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEC.getNro_documento());
            
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

    public Iterable<ClsECliente> MtdListarCliente() {
        
        try
        {
            String SQL="CALL USP_S_Cliente";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsECliente> lista=new ArrayList<>();
            ClsECliente emp;
            
            while (resultado.next())
            {
                emp = new ClsECliente();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                emp.setNro_documento(resultado.getString("nro_documento"));
                emp.setNombre(resultado.getString("nombre"));
                emp.setApellido(resultado.getString("apellido"));             
                emp.setFech_nacimiento(resultado.getString("fech_nacimiento"));
                emp.setSexo(resultado.getString("sexo"));                
                emp.setDireccion(resultado.getString("direccion"));    
                emp.setCorreo(resultado.getString("correo"));                               
                emp.setCelular(resultado.getString("celular"));
                emp.setClave(resultado.getString("clave"));
                emp.setIdTip_documento(resultado.getInt("idTipo_documento"));
                
                lista.add(emp);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsECliente> MtdBuscarCliente(ClsECliente objEC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
