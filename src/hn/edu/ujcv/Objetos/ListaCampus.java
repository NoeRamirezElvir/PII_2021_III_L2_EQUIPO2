package hn.edu.ujcv.Objetos;

import java.util.ArrayList;

public class ListaCampus {
    private final ArrayList<Campus> listaCampus;

    public ListaCampus(){
        listaCampus = new ArrayList<>();
    }
    public void addCampus(Campus campus){
        listaCampus.add(campus);
    }

    public ArrayList<Campus> getListaCampus() {
        return listaCampus;
    }

    public void imprimirLista(){
        System.out.println("  ID              Nombre           Direccion            Fecha de Inicio ");
        for (Campus lista: listaCampus) {
            System.out.println(lista.getID() + "      " +
                    lista.getNombre() + "          " +
                    lista.getDireccion() + "      " +
                    lista.getFechaInicio());
        }
    }
}
