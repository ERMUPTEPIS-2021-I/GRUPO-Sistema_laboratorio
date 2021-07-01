/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Entidad.ClsEEmpleado;
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
public class ClsNEmpleado {
    
    public static boolean MtdRegistrarEmpleado(ClsEEmpleado objEE) {
        
        try
        {
            String SQL="CALL USP_I_Empleado(?,?,?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objEE.getNro_documento());
            st.setString(2, objEE.getNombre());
            st.setString(3, objEE.getApellido());
            st.setString(4, objEE.getFecha_nacimiento());
            st.setString(5, objEE.getDireccion());
            st.setString(6, objEE.getCelular());
            st.setString(7, objEE.getClave());
            st.setInt(8, objEE.getEstado());
            st.setInt(9, objEE.getIdRol());
            st.setInt(10, objEE.getIdTipo_doc());
            
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

    public boolean MtdModificarEmpleado(ClsEEmpleado objEE) {
        
        try
        {
            String SQL="CALL USP_U_Empleado (?,?,?,?,?,?,?,?,?,?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, objEE.getNro_documento());
            st.setString(2, objEE.getNombre());
            st.setString(3, objEE.getApellido());
            st.setString(4, objEE.getFecha_nacimiento());
            st.setString(5, objEE.getDireccion());
            st.setString(6, objEE.getCelular());
            st.setString(7, objEE.getClave());
            st.setInt(8, objEE.getEstado());
            st.setInt(9, objEE.getIdRol());
            st.setInt(10, objEE.getIdTipo_doc());
            
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

    public boolean MtdEliminarEmpleado(ClsEEmpleado objEE) {
        try
        {
            
            String SQL="CALL USP_D_Empleado(?)";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            st.setString(1, objEE.getNro_documento());
            
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

    public Iterable<ClsEEmpleado> MtdListarEmpleado() {
        
        try
        {
            String SQL="CALL USP_S_Empleado";
            Connection con = ClsConexion.Conectar();
            
            PreparedStatement st=con.prepareStatement(SQL);
            ResultSet resultado=st.executeQuery();
            ArrayList<ClsEEmpleado> lista=new ArrayList<>();
            ClsEEmpleado emp;
            
            while (resultado.next())
            {
                emp = new ClsEEmpleado();
                //getString("nombre_De_la_columna_en_la_base_de_datos")
                emp.setNro_documento(resultado.getString("nro_documento"));
                emp.setNombre(resultado.getString("nombre"));
                emp.setApellido(resultado.getString("apellido"));
                emp.setFecha_nacimiento(resultado.getString("fech_nacimiento"));
                emp.setDireccion(resultado.getString("direccion"));
                emp.setCelular(resultado.getString("celular"));
                emp.setClave(resultado.getString("clave"));
                emp.setEstado(resultado.getInt("estado"));
                emp.setIdRol(resultado.getInt("idRol"));
                emp.setIdTipo_doc(resultado.getInt("idTipo_documento"));
                
                lista.add(emp);
            }
            return lista;
            
            
        }catch(SQLException e){
                return null;         
            }
    }

    public Iterable<ClsEEmpleado> MtdBuscarEmpleado(ClsEEmpleado objEE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
