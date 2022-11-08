/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.modeloTabla;

import javax.swing.table.AbstractTableModel;
import modelo.Elemento;

/**
 *
 * @author DEEPIN
 */
public class ModeloTablaElemento extends AbstractTableModel {
    private Elemento elementos[];

    public Elemento[] getElementos() {
        return elementos;
    }

    public void setElementos(Elemento[] elementos) {
        this.elementos = elementos;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return elementos.length;
    }

    @Override
    public String getColumnName(int i) {
        
        switch(i) {
            case 0: return "Nro";
            case 1: return "Tipo";    
            case 2: return "Caracteristica";    
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Elemento e = elementos[i];
        switch(i1) {
            case 0: return (i+1);
            case 1: return (e != null) ? e.getTipo().toString() : "NO DEFINIDO";    
            case 2: return (e != null) ? e.getCaracteristica() : "NO DEFINIDO";    
            default: return null;
        }
    }
    
    
    
    
}
