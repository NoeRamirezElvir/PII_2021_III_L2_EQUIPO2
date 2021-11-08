package hn.edu.ujcv.Objetos;

import java.util.Scanner;

public class Avanzada extends Clase{
    private int ValorVinculacion;

    public Avanzada(){
        super();
    }


    public void registarClaseB(ListaClases listaClases) {
        this.registarClase(listaClases);
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        System.out.print("Ingrese El Valor de Vinculacion: ");
        this.setValorVinculacion(teclado.nextInt());
        listaClases.AddClase(this);
    }

    public Avanzada(int pValorVinculacion,int pId,String pNombre,int pUnidadesValorativas, int pNA1,int pNE1,int pNA2,int pNE2,
                   int pNA3, int pNE3,int pNR){
        super(pId,pNombre,pUnidadesValorativas,pNA1,pNE1,pNA2,pNE2,pNA3,pNE3,pNR);
        this.ValorVinculacion = pValorVinculacion;
    }

    public int  getValorVinculacion() {
        return ValorVinculacion;
    }
    public void setValorVinculacion(int valorVinculacion) {
        this.ValorVinculacion = valorVinculacion;
    }

    @Override
    public double calcularNotaFinal() {
        return super.calcularNotaFinal();
    }
    @Override
    public String toString(){
        return super.toString().concat("\n -Valor Vinculacion : ".concat(String.valueOf(ValorVinculacion)));
    }
}
