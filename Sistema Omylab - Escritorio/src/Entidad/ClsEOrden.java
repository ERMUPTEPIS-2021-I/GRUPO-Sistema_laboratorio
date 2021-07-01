/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Date;
/**
 *
 * @author Mathius
 */
public class ClsEOrden {

    int idOrden;
    String fecha;
    String estado;
    String Cliente_nro_documento;
    String Empleado_nro_documento;

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCliente_nro_documento() {
        return Cliente_nro_documento;
    }

    public void setCliente_nro_documento(String Cliente_nro_documento) {
        this.Cliente_nro_documento = Cliente_nro_documento;
    }

    public String getEmpleado_nro_documento() {
        return Empleado_nro_documento;
    }

    public void setEmpleado_nro_documento(String Empleado_nro_documento) {
        this.Empleado_nro_documento = Empleado_nro_documento;
    }
    
    
}
