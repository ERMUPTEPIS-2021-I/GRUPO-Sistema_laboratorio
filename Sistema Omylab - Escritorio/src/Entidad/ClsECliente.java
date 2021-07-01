/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Date;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsECliente {
    String nro_documento;
    String nombre;
    String apellido;
    String fech_nacimiento;
    String sexo;
    String direccion;
    String correo;
    String celular;
    String clave;
    int idTip_documento;

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFech_nacimiento() {
        return fech_nacimiento;
    }

    public void setFech_nacimiento(String fech_nacimiento) {
        this.fech_nacimiento = fech_nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdTip_documento() {
        return idTip_documento;
    }

    public void setIdTip_documento(int idTip_documento) {
        this.idTip_documento = idTip_documento;
    }

    
    
}
