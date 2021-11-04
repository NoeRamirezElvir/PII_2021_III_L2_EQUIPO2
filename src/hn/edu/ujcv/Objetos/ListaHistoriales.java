package hn.edu.ujcv.Objetos;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaHistoriales {
    private ArrayList<Historial> ListaHistoriales;

    public      ListaHistoriales(){
        ListaHistoriales = new ArrayList<>();
    }
    public void AddHistorial(Historial pHistorial){
        ListaHistoriales.add(pHistorial);
    }
    public ArrayList<Historial> getListaHistoriales() {
        return ListaHistoriales;
    }

    public void ImprimirLista(){
        StringBuilder listado = new StringBuilder();
        for (Historial item : ListaHistoriales) {
            listado.append(item.toString());
            listado.append("     Promedio Global: ").append(CalcularPromedioGlobal());
        }
        System.out.println(listado);
    }
    public double CalcularPromedioGlobal(){
        double promedio = 0.0;
        Iterator<Historial> itClases = getListaHistoriales().iterator();
        while(itClases.hasNext()){
            promedio += itClases.next().calcularPromedio();
        }
        return promedio/getListaHistoriales().size();
    }
}
