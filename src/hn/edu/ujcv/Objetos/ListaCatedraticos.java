package hn.edu.ujcv.Objetos;

import java.util.ArrayList;

public class ListaCatedraticos {
    private final ArrayList<Catedratico> listaCatedraticos;

    public      ListaCatedraticos(){
        listaCatedraticos = new ArrayList<>();
    }
    public void addCatedratico(Catedratico catedratico){
        listaCatedraticos.add(catedratico);
    }
    public ArrayList<Catedratico> getListaCatedraticos() {
        return listaCatedraticos;
    }
    public void imprimirLista(){
        System.out.println("    ID              Codigo         Nombre           Fecha de nacimiento            Edad  ");
        for (Catedratico lista: listaCatedraticos) {
            System.out.println(lista.getID() + "      " +
                    lista.getCodigo() + "          " +
                    lista.getNombre() + "      " +
                    lista.getFechaNacimiento()+ "        " +
                    lista.calcularEdad());
        }
    }
}
