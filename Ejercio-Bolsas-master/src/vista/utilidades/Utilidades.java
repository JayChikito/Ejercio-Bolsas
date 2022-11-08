/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.utilidades;

import controlador.BolsaController;
import javax.swing.JComboBox;
import modelo.Bolsa;
import modelo.Tipo;

/**
 *
 * @author DEEPIN
 */
public class Utilidades {
    public static JComboBox cargarComboTipo(JComboBox cbx){
        cbx.removeAllItems();
        for(Tipo tipo: Tipo.values()) {
            cbx.addItem(tipo);
        }
        return cbx;
    }
    
    public static Tipo getTipoCombo(JComboBox cbx){
        return (Tipo)cbx.getSelectedItem();
    }
//    
//    public boolean guardarArchivo(Bolsa[] bolsas){
//        try {
//            FIle archivo = new FIle(DIRCARDATA+File.separtorChar+"bolsa"
//        } catch (Exception e) {
//            return e;
//        }
//    }
    
    public static JComboBox cargarComboBolsa(JComboBox cbx, BolsaController bc){
        cbx.removeAllItems();
        for(int i = 0; i < bc.getBolsas().length; i++){
            cbx.addItem(bc.getBolsas()[i]);
        }
        return cbx;
    }
    
    public static Bolsa getBolsaCombo(JComboBox cbx){
        return (Bolsa)cbx.getSelectedItem();
    }
}


