/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;

/**
 *
 * @author DEEPIN
 */
public class Bolsa implements Serializable {
    private String nombre;
    private String tipo;
    private Elemento elemento[];

    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Elemento[] getElemento() {
        return this.elemento;
    }

    public void setElemento(Elemento elemento[]) {
        this.elemento = elemento;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
