/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Mathius
 */
public class ClsEAnalisis {

    public int getIdAnalisis() {
        return idAnalisis;
    }

    public void setIdAnalisis(int idAnalisis) {
        this.idAnalisis = idAnalisis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    int idAnalisis;
    String nombre;
    double costo;
    int estado;
    
    
    
    
    
}
