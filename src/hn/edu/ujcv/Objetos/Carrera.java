package hn.edu.ujcv.Objetos;

import java.util.Scanner;

public class Carrera {
    private int ID;
    private String nombre;

    public Carrera(){}
    public Carrera(int pId,String pNombre){
        if(pId < 4){
            throw new IllegalArgumentException("El ID es muy corto.");
        }
        this.ID = pId;
        if(pNombre.length() < 3){
            throw new IllegalArgumentException("El nombre es muy corto.");
        }
        this.nombre = pNombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int pId) {
        if((String.valueOf(pId).length()) < 4){
            throw new IllegalArgumentException("El ID es muy corto.");
        }
        this.ID = pId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String pNombre) {
        if(pNombre.length() < 3){
            throw new IllegalArgumentException("El nombre es muy corto.");
        }
        this.nombre = pNombre;
    }

    public void registrarCarrera(ListaCarreras listaCarreras){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Carrera carrera = new Carrera();
        int ID;
        do{
            System.out.print("Ingrese el ID: ");
            ID = teclado.nextInt();
            if(validarID(listaCarreras,ID)){
                System.out.println("El ID ya esta en uso.");
            }
        }while(validarID(listaCarreras,ID));
        carrera.setID(ID);
        System.out.print("Ingrese el nombre: ");
        carrera.setNombre(teclado.next());
        listaCarreras.addCarreras(carrera);

    }
    public boolean validarID(ListaCarreras listaCarreras,int ID){
        boolean condicion = false;
        for (Carrera carrera: listaCarreras.getListaCarreras()) {
            if (ID == carrera.getID()) {
                condicion = true;
                break;
            }
        }
        return condicion;
    }
}
