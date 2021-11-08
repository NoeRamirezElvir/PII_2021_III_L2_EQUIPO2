package hn.edu.ujcv.Objetos;

import java.util.Scanner;

public  class Clase implements IClase{
    private int Id;
    private int NA1;
    private int NA2;
    private int NA3;
    private int NE1;
    private int NE2;
    private int NE3;
    private int NR;
    private String Nombre;
    private int UnidadesValorativas;

    public int  getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public int    getNA1() {
        return NA1;
    }
    public void   setNA1(int NA1) {
        this.NA1 = NA1;
    }
    public int    getNA2() {
        return NA2;
    }
    public void   setNA2(int NA2) {
        this.NA2 = NA2;
    }
    public int    getNA3() {
        return NA3;
    }
    public void   setNA3(int NA3) {
        this.NA3 = NA3;
    }
    public int    getNE1() {
        return NE1;
    }
    public void   setNE1(int NE1) {
        this.NE1 = NE1;
    }
    public int    getNE2() {
        return NE2;
    }
    public void   setNE2(int NE2) {
        this.NE2 = NE2;
    }
    public int    getNE3() {
        return NE3;
    }
    public void   setNE3(int NE3) {
        this.NE3 = NE3;
    }
    public int    getNR() {
        return NR;
    }
    public void   setNR(int NR) {
        this.NR = NR;
    }
    public String getNombre() {
        return Nombre;
    }
    public void   setNombre(String nombre) {
        Nombre = nombre;
    }
    public int    getUnidadesValorativas() {
        return UnidadesValorativas;
    }
    public void   setUnidadesValorativas(int unidadesValorativas) {
        UnidadesValorativas = unidadesValorativas;
    }

    public Clase() {
    }
    public Clase(int pId,String pNombre,int pUnidadesValorativas, int pNA1,int pNE1,int pNA2,int pNE2,
                 int pNA3, int pNE3,int pNR) {
        this.Id = pId;
        this.Nombre = pNombre;
        this.UnidadesValorativas = pUnidadesValorativas;
        this.NA1 = pNA1;
        this.NE1 = pNE1;
        this.NA2 = pNA2;
        this.NE2 = pNE2;
        this.NA3 = pNA3;
        this.NE3 = pNE3;
        this.NR  = pNR;
    }
    public  void registarClase(ListaClases listaClases){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        int id,opcion;
        String repo;
        do{
            System.out.print("Ingrese el ID de la clase: ");
            id = teclado.nextInt();
            if(validarID(listaClases,id))
                System.out.println("Id de clase ya resgistrado.");
        }while(validarID(listaClases,id));
        this.setId(id);
        System.out.print("Ingrese el nombre de la clase: ");
        this.setNombre(teclado.next());
        System.out.print("Ingrese el Numero de Unidades Valorativas de la clase: ");
        this.setUnidadesValorativas(teclado.nextInt());
        System.out.print("Ingrese la Nota de Acumulativo del primer parcial: ");
        this.setNA1(teclado.nextInt());
        System.out.print("Ingrese la Nota de Examen del primer parcial: ");
        this.setNE1(teclado.nextInt());
        System.out.print("Ingrese la Nota de Acumulativo del segundo parcial: ");
        this.setNA2(teclado.nextInt());
        System.out.print("Ingrese la Nota de Examen del segundo parcial: ");
        this.setNE2(teclado.nextInt());
        System.out.println("Relizo examen de reposicion? (1er o 2do parc.)s/n");
        repo = teclado.next();
        if (repo.equalsIgnoreCase("s")){
            System.out.println("1- Primer parcial     2- Segundo Parcial"+"\nElija una opcion> ");
            opcion = teclado.nextInt();
            boolean condicion = false;
            do {
                switch (opcion){
                    case 1:
                        int nota = teclado.nextInt();
                        this.setNE1(nota);
                        this.setNR(nota);
                        break;
                    case 2:
                        int nota1 = teclado.nextInt();
                        this.setNE2(nota1);
                        this.setNR(nota1);
                        break;
                    default:
                        System.out.println("Opcion Invalida");
                        break;
                }
            }while (opcion!=1 && opcion!=2);
        }else
            this.setNR(0);
        System.out.print("Ingrese la Nota de Acumulativo del tercer parcial: ");
        this.setNA3(teclado.nextInt());
        System.out.print("Ingrese la Nota de Examen del tercer parcial: ");
        this.setNE3(teclado.nextInt());

    }
    @Override
    public double calcularNotaFinal() {
        double nota1=0.0,nota2=0.0,nota3=0.0,notaF=0.0;
        nota1 =((getNA1()+getNE1())*0.3);
        nota2 =((getNA2()+getNE2())*0.3);
        nota3 =((getNA3()+getNE3())*0.4);
        notaF = (nota1+nota2+nota3);
        return notaF;
    }
    @Override
    public String toString(){
        return "\n*Asignatura: ".concat(Nombre).concat(" UV: ").concat(String.valueOf(UnidadesValorativas));
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
}
