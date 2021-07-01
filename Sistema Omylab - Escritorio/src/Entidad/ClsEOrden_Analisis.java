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
public class ClsEOrden_Analisis {

    int idOrden;
    int idAnalisis;
    double valor_min;
    double valor_max;
    String resultado;
    int idMuestra;
    
    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdAnalisis() {
        return idAnalisis;
    }

    public void setIdAnalisis(int idAnalisis) {
        this.idAnalisis = idAnalisis;
    }

    public double getValor_min() {
        return valor_min;
    }

    public void setValor_min(double valor_min) {
        this.valor_min = valor_min;
    }

    public double getValor_max() {
        return valor_max;
    }

    public void setValor_max(double valor_max) {
        this.valor_max = valor_max;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getIdMuestra() {
        return idMuestra;
    }

    public void setIdMuestra(int idMuestra) {
        this.idMuestra = idMuestra;
    }
    
    
}
