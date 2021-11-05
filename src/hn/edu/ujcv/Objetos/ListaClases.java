package hn.edu.ujcv.Objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaClases {
    private ArrayList<Clase> ListaClases;

    public ListaClases(){
        ListaClases = new ArrayList<>();
    }
    public void AddClase(Clase pClase){
        ListaClases.add(pClase);
    }
    public ArrayList<Clase> getListaClases() {
        return ListaClases;
    }
    public void ImprimirLista(){
        String tipoClase = "";
        String tipoFaultad = "";
        StringBuilder listado = new StringBuilder();
        for (Clase lista: ListaClases) {
            listado.append(lista.toString());
            if (lista instanceof  General)
                tipoClase = "General";
            else
                tipoClase = "Avanzada";
            listado.append("\n-Tipo de Clase: " ).append(tipoClase);
            if (lista instanceof  Ingenieria)
                tipoFaultad = "Ingenieria";
            else
                tipoFaultad = "Idioma";
            listado.append("\n-Tipo de Facultad: " ).append(tipoFaultad);
            listado.append("\n-Nota Final de esta clase: ").append(lista.calcularNotaFinal());
        }
        System.out.println(listado);
    }

}
