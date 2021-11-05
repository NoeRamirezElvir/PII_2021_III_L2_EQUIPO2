package hn.edu.ujcv.Objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaCarreras {
    private final ArrayList<Carrera> listaCarreras;

    public      ListaCarreras(){
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
    public Carrera buscarCampus(ListaCarreras listaCarreras){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        int    identidad;
        Carrera carrera = new Carrera();
        do {
            System.out.print(" Ingrese el  Id: ");
            identidad = teclado.nextInt();
            for (Carrera item: getListaCarreras()) {
                if(identidad == item.getID()) {
                    carrera = item;
                }
            }
            if (!carrera.validarID(listaCarreras,identidad))
                System.out.println("Digite una Id valida!");

        }while (!carrera.validarID(listaCarreras,identidad));
        return carrera;
    }
}
