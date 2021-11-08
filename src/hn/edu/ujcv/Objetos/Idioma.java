package hn.edu.ujcv.Objetos;

import java.util.Scanner;

public class Idioma extends General{
    private int NotaLab;

    public Idioma(){super();}
    public Idioma(int pNotaLab,boolean pTodasCarreras,int pId,String pNombre,int pUnidadesValorativas,
                      int pNA1,int pNE1,int pNA2,int pNE2, int pNA3, int pNE3,int pNR){
        super(pTodasCarreras,pId,pNombre,pUnidadesValorativas,pNA1,pNE1,pNA2,pNE2,pNA3,pNE3,pNR);
        this.NotaLab = pNotaLab;
    }

    public int  getNotaLab() {
        return NotaLab;
    }
    public void setNotaLab(int notaLab) {
        NotaLab = notaLab;
    }


    public void registarClaseC(ListaClases listaClases){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        this.registarClaseB(listaClases);
        System.out.print("Ingrese La Nota de Laboratorio: ");
        this.setNotaLab(teclado.nextInt());
        listaClases.AddClase(this);
    }


    @Override
    public double calcularNotaFinal() {
        return super.calcularNotaFinal();
    }
    @Override
    public String toString(){
        return super.toString().concat("\n -Nota Laboratorio: ".concat(String.valueOf(NotaLab)));
    }
}
