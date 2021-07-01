/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author ERICKA MARTINEZ
 */
public class ClsEValor_referencial {
    int idValor_referencial;
    float valor_min;
    float valor_max;
    String sexo;
    int edad_min;
    int edad_max;
    int idAnalisis;

    public int getIdValor_referencial() {
        return idValor_referencial;
    }

    public void setIdValor_referencial(int idValor_referencial) {
        this.idValor_referencial = idValor_referencial;
    }

    public float getValor_min() {
        return valor_min;
    }

    public void setValor_min(float valor_min) {
        this.valor_min = valor_min;
    }

    public float getValor_max() {
        return valor_max;
    }

    public void setValor_max(float valor_max) {
        this.valor_max = valor_max;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad_min() {
        return edad_min;
    }

    public void setEdad_min(int edad_min) {
        this.edad_min = edad_min;
    }

    public int getEdad_max() {
        return edad_max;
    }

    public void setEdad_max(int edad_max) {
        this.edad_max = edad_max;
    }

    public int getIdAnalisis() {
        return idAnalisis;
    }

    public void setIdAnalisis(int idAnalisis) {
        this.idAnalisis = idAnalisis;
    }
    
}
