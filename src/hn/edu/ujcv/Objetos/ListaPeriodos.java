package hn.edu.ujcv.Objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaPeriodos {
    private final ArrayList<Periodo> listaPeriodos;

    public      ListaPeriodos(){
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
    public Periodo buscarCampus(ListaPeriodos listaCampus){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        int    identidad;
        Periodo periodo = new Periodo();
        do {
            System.out.print(" Ingrese el Id: ");
            identidad = teclado.nextInt();
            for (Periodo item: getListaPeriodos()) {
                if(identidad == item.getID()) {
                    periodo = item;
                }
            }
            if (!periodo.validarID(listaCampus,identidad))
                System.out.println("Digite una Id valida!");

        }while (!periodo.validarID(listaCampus,identidad));
        return periodo;
    }
}
