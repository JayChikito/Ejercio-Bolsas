package controlador.utiles;

import modelo.Elemento;

public class Utiles {
    public static Object [] agregar(Object [] base, Object [] a, Integer pos) {
        System.out.println(base.length+"  "+pos+"  "+a.length);
        Integer cont = 0;
        for(int i = pos; i < base.length; i++) {
            base[i] = a[cont];
            cont++;
            if(cont == a.length)
                break;
        }
        return base;
    }

    public static void imprimirArreglo(Object [] arreglo) {
        for(int i = 0; i < arreglo.length; i++) {
            System.out.println(arreglo[i] + "\t");
        }
    }

}
