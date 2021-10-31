package hn.edu.ujcv.Objetos;

import java.util.ArrayList;

public class ListaCarreras {
    private final ArrayList<Carrera> listaCarreras;

    public ListaCarreras(){
        listaCarreras = new ArrayList<>();
    }
    public void addCarreras(Carrera carrera){
        listaCarreras.add(carrera);
    }

    public ArrayList<Carrera> getListaCarreras() {
        return listaCarreras;
    }

    public void imprimirLista(){
        System.out.println("  ID             Nombre");
        for (Carrera lista: listaCarreras) {
            System.out.println(lista.getID() + "            " +
                    lista.getNombre());
        }
    }
}
