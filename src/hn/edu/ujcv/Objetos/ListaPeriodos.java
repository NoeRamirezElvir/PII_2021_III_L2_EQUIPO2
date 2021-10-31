package hn.edu.ujcv.Objetos;

import java.util.ArrayList;

public class ListaPeriodos {
    private final ArrayList<Periodo> listaPeriodos;

    public ListaPeriodos(){
        listaPeriodos = new ArrayList<>();
    }
    public void addPeriodo(Periodo periodo){
        listaPeriodos.add(periodo);
    }

    public ArrayList<Periodo> getListaPeriodos() {
        return listaPeriodos;
    }

    public void imprimirLista(){
        System.out.println("  ID           Direccion         Fecha de Inicio         Fecha Final");
        for (Periodo lista: listaPeriodos) {
            System.out.println(lista.getID() + "      " +
                    lista.getDescripcion() + "          " +
                    lista.getFechaInicio() + "      " +
                    lista.getFechaFinal());
        }
    }
}
