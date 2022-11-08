/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import controlador.excepciones.ArrayLlenoException;
import javax.swing.text.ElementIterator;

import controlador.excepciones.DifferentTypeArrayException;
import controlador.utiles.Utiles;
import modelo.Bolsa;
import modelo.Elemento;
import modelo.Tipo;

/**
 *
 * @author DEEPIN
 */
public class BolsaController {
    public static String NCOMUN = "NO DEFINIDO";
    private Bolsa bolsas [];
    private Bolsa bolsa;
    private Elemento elemento;

  
    public BolsaController (Integer nro_bolsas){
        bolsas = new Bolsa[nro_bolsas];
        for(int i = 0; i < nro_bolsas; i++){
            Bolsa b = new Bolsa();
            b.setNombre(BolsaController.NCOMUN);
            bolsas[i] = b;
        }
    }
    
//    public BolsaController(String nombre, Integer tamanio) {
//        getBolsa().setNombre(nombre);
//        getBolsa().setTipo(nombre);
//        getBolsa().setElemento(new Elemento[tamanio]);
//       // bolsa.setNombre(nombre);
//    }

    public void crearArregloElemento(Integer tam){
        bolsa.setElemento(new Elemento[tam]);
    }
            
    public Bolsa[] getBolsas() {
        return bolsas;
    }

    public void setBolsas(Bolsa[] bolsas) {
        this.bolsas = bolsas;
    }
    
    
    

    public boolean guardarElemento(Elemento elemento) throws ArrayLlenoException {
        if(estaLleno()) {
            throw new ArrayLlenoException("Limite maximo del arreglo");
        } else {
            getBolsa().getElemento()[verificarPosicion() + 1]=elemento;
            return true;
        }
        
    }
    public int verificarPosicion() {
        int pos = -1;//este vacio
        //0 hasta limite real
        for(int i = 0; i < getBolsa().getElemento().length;i++) {
            if(getBolsa().getElemento()[i] == null) {
                break;
            } else {
                pos = i;
            }
        }
        return pos;
    }

    public boolean estaLleno() {
        //boolean band = false;
        //int tamanio = getBolsa().getElemento().length;
        //int pos = verificarPosicion();
        //band = pos < tamanio - 1;
        return getBolsa().getElemento().length <= verificarPosicion() + 1;
    }

    public Bolsa getBolsa() {
        if(bolsa == null)
            bolsa = new Bolsa();
        return this.bolsa;
    }

    public void setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
    }

    public Elemento getElemento() {
        if(elemento == null)
            elemento = new Elemento();
        return this.elemento;
    }

    public void setElemento(Elemento elemento) {
        this.elemento = elemento;
    }
    public void imprimir() {
        for(Tipo tipo: Tipo.values()) {
            System.out.println(tipo.toString());
        }
    }
    public static Tipo getTipo(Integer i) {
        return Tipo.values()[i];
    }

    public Elemento[] unirBolsa(Bolsa a, Bolsa b) throws DifferentTypeArrayException {
        if(a.getTipo().equalsIgnoreCase( b.getTipo())) {
            Elemento e [] = new Elemento[a.getElemento().length + b.getElemento().length];
            e = (Elemento[]) Utiles.agregar(e, a.getElemento(), 0);
            e = (Elemento[]) Utiles.agregar(e, b.getElemento(), a.getElemento().length) ;
            return e;
        } else 
            throw new DifferentTypeArrayException("Lo elementos enviados son de distinti tipo "+a.getTipo()+" ---- "+b.getTipo());
    }

    
}
