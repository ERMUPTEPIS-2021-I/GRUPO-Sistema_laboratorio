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
public class ClsEProducto_detalle {

    int idProducto_detalle;
    double cantidad;
    String fech_vencimiento;
    int idProducto;
    
    public int getIdProducto_detalle() {
        return idProducto_detalle;
    }

    public void setIdProducto_detalle(int idProducto_detalle) {
        this.idProducto_detalle = idProducto_detalle;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFech_vencimiento() {
        return fech_vencimiento;
    }

    public void setFech_vencimiento(String fech_vencimiento) {
        this.fech_vencimiento = fech_vencimiento;
    }

    

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
