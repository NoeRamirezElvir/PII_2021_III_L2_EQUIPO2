package hn.edu.ujcv.Objetos;

import java.util.Scanner;

public class Avanzada extends Clase{
    private int ValorVinculacion;

    public Avanzada(){super();}

    @Override
    public void registarClase(ListaClases listaClases) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Avanzada clase = new Avanzada();
        int id,opcion;
        String repo;
        do{
            System.out.print("Ingrese el ID de la clase: ");
            id = teclado.nextInt();
            if(validarID(listaClases,id))
                System.out.println("Id de clase ya resgistrado.");
        }while(validarID(listaClases,id));
        clase.setId(id);
        System.out.print("Ingrese el nombre de la clase: ");
        clase.setNombre(teclado.next());
        System.out.print("Ingrese el Numero de Unidades Valorativas de la clase: ");
        clase.setUnidadesValorativas(teclado.nextInt());
        System.out.print("Ingrese la Nota de Acumulativo del primer parcial: ");
        clase.setNA1(teclado.nextInt());
        System.out.print("Ingrese la Nota de Examen del primer parcial: ");
        clase.setNE1(teclado.nextInt());
        System.out.print("Ingrese la Nota de Acumulativo del segundo parcial: ");
        clase.setNA2(teclado.nextInt());
        System.out.print("Ingrese la Nota de Examen del segundo parcial: ");
        clase.setNE2(teclado.nextInt());
        System.out.println("Relizo examen de reposicion? (1er o 2do parc.)s/n");
        repo = teclado.next();
        if (repo.equalsIgnoreCase("s")){
            System.out.println("1- Primer parcial     2- Segundo Parcial"+"\nElija una opcion> ");
            opcion = teclado.nextInt();
            do {
                switch (opcion){
                    case 1:

                        break;
                    case 2:

                        break;
                    default:
                        System.out.println("Opcion Invalida");
                        break;
                }
            }while (opcion!=1 || opcion!=2);
        }else
            clase.setNR(0);
        System.out.print("Ingrese la Nota de Acumulativo del tercer parcial: ");
        clase.setNA3(teclado.nextInt());
        System.out.print("Ingrese la Nota de Examen del tercer parcial: ");
        clase.setNE3(teclado.nextInt());
        System.out.print("Ingrese El Valor de Vinculacion: ");
        clase.setValorVinculacion(teclado.nextInt());
        listaClases.AddClase(clase);
    }
    public boolean validarID(ListaClases listaClases, int id){
        boolean condicion = false;
        for (Clase clase: listaClases.getListaClases()) {
            if (id == clase.getId()) {
                condicion = true;
                break;
            }
        }
        return condicion;
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
        double nota1=0.0,nota2=0.0,nota3=0.0,notaF=0.0;
        nota1 =((getNA1()+getNE1()+getNR())*0.3);
        nota2 =((getNA2()+getNE2()+getNR())*0.3);
        nota3 =((getNA3()+getNE3())*0.4);
        notaF = (nota1+nota2+nota3)/3;
        return notaF;
    }
    @Override
    public String toString(){
        return super.toString().concat(" Valor Vinculacion : ".concat(String.valueOf(ValorVinculacion)));
    }
}
