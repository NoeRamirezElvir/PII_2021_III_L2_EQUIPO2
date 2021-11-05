package hn.edu.ujcv.Objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaClases {
    private final ArrayList<Clase> ListaClases;

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
    public void mostrarClase(){
        System.out.println("ID           Nombre             UV");
        for (Clase item : ListaClases) {
            System.out.println(item.getId() + "        " + item.getNombre() + "         " + item.getUnidadesValorativas());
        }
    }
    public ArrayList<Clase> buscarClases(){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        ArrayList<Clase> lista = new ArrayList<>();
        do {
            System.out.println("Ingrese el ID de la clase: ");
            int id = teclado.nextInt();
            for (Clase item: ListaClases) {
                if (id == item.getId()){
                    lista.add(item);
                }
            }
            System.out.println("Agregar otra clase S/N:");
        }while((teclado.next()).equalsIgnoreCase("s"));

        return lista;
    }

}
