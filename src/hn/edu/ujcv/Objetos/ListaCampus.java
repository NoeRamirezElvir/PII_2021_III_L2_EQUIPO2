package hn.edu.ujcv.Objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaCampus {
    private final ArrayList<Campus> listaCampus;

    public      ListaCampus(){
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
    public Campus buscarCampus(ListaCampus listaCampus){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        int    identidad;
        Campus campus = new Campus();
        do {
            System.out.print(" Ingrese el Id: ");
            identidad = teclado.nextInt();
            for (Campus item: getListaCampus()) {
                if(identidad == item.getID()) {
                    campus = item;
                }
            }
            if (!campus.validarID(listaCampus,identidad))
                System.out.println("Digite una Id valida!");

        }while (!campus.validarID(listaCampus,identidad));
        return campus;
    }
}
