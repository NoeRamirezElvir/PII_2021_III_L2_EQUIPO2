package hn.edu.ujcv.Objetos;

import java.util.Scanner;

public class Ingenieria extends General{
    private int NotaProyecto;

    public Ingenieria(){super();}
    public Ingenieria(int pNotaProyecto,boolean pTodasCarreras,int pId,String pNombre,int pUnidadesValorativas,
                      int pNA1,int pNE1,int pNA2,int pNE2, int pNA3, int pNE3,int pNR){
        super(pTodasCarreras,pId,pNombre,pUnidadesValorativas,pNA1,pNE1,pNA2,pNE2,pNA3,pNE3,pNR);
        this.NotaProyecto = pNotaProyecto;
    }

    public int  getNotaProyecto() {
        return NotaProyecto;
    }
    public void setNotaProyecto(int notaProyecto) {
        NotaProyecto = notaProyecto;
    }

    public void registarClaseC(ListaClases listaClases){
        this.registarClaseB(listaClases);
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese La Nota de Proyecto: ");
        this.setNotaProyecto(teclado.nextInt());
        listaClases.AddClase(this);
    }

    @Override
    public double calcularNotaFinal() {
        return super.calcularNotaFinal();
    }
    @Override
    public String toString(){
        return super.toString().concat("\n -Nota de Proyecto: ").concat(String.valueOf(NotaProyecto));
    }
}
