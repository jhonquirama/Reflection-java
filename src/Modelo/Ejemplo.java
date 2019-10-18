/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Lenovo
 */
public class Ejemplo {
       
    private String cadena1;
    public String cadena2;
    private int numero1;
    public int numero2;

    public Ejemplo(String cadena1, String cadena2, int numero1, int numero2) {
        this.cadena1 = cadena1;
        this.cadena2 = cadena2;
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public Ejemplo() {
    }

    public String getCadena1() {
        return cadena1;
    }

    public void setCadena1(String cadena1) {
        this.cadena1 = cadena1;
    }

    public String getCadena2() {
        return cadena2;
    }

    public void setCadena2(String cadena2) {
        this.cadena2 = cadena2;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }
    
    
    
}