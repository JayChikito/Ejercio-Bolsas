/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.utilidades;

import com.google.gson.Gson;
import controlador.BolsaController;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JComboBox;
import modelo.Bolsa;
import modelo.Tipo;

/**
 *
 * @author DEEPIN
 */
public class Utilidades {

    public static String DIRCARPDATA = "data";
    Gson gson = new Gson();

    public static JComboBox cargarComboTipo(JComboBox cbx) {
        cbx.removeAllItems();
        for (Tipo tipo : Tipo.values()) {
            cbx.addItem(tipo);
        }
        return cbx;
    }

    public static Tipo getTipoCombo(JComboBox cbx) {
        return (Tipo) cbx.getSelectedItem();
    }

    public static JComboBox cargarComboBolsa(JComboBox cbx, BolsaController bc) {
        cbx.removeAllItems();
        for (int i = 0; i < bc.getBolsas().length; i++) {
            cbx.addItem(bc.getBolsas()[i]);
        }
        return cbx;
    }

    public static Bolsa getBolsaCombo(JComboBox cbx) {
        return (Bolsa) cbx.getSelectedItem();
    }

    public static boolean guardarArchivo(Bolsa[] bolsas) {
        try {
            File archivo = new File(DIRCARPDATA + File.separatorChar + "bolsa.dato");
            FileOutputStream salida = new FileOutputStream(archivo);
            ObjectOutputStream ous = new ObjectOutputStream(salida);
            ous.writeObject(bolsas);
            ous.flush();
            ous.close();
            salida.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error" + e);
            return false;
        }
    }

    public static Bolsa[] cargarArchivo() {
        Bolsa[] bolsas = null;
        try {
            File archivo = new File(DIRCARPDATA + File.separatorChar + "bolsa.dato");
            FileInputStream entrada = new FileInputStream(archivo);
            ObjectInputStream ous = new ObjectInputStream(entrada);
            bolsas = (Bolsa[]) ous.readObject();
            ous.close();
            entrada.close();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return bolsas;
    }

    public static boolean guardarJson(Bolsa[] bolsas) {
        Gson gson = new Gson();
        String json = gson.toJson(bolsas);
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("datos.json"))) {
            bw.write(json);

            bw.close();
            return true;

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

    }

    public static Bolsa[] cargarJson() {
        Bolsa[] bolsas = null;
        Gson gson = new Gson();
        String json = gson.toJson(bolsas);
            

        try (BufferedReader br = new BufferedReader(new FileReader("datos.json"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                json += linea;
                
                bolsas = gson.fromJson(json, Bolsa[].class); 
                
                System.out.println(bolsas);
                System.out.println(json);
                System.out.println(bolsas);
                

            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return bolsas;
    }

}
