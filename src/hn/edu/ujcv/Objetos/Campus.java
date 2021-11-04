package hn.edu.ujcv.Objetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Campus {
    private int    ID;
    private String nombre;
    private String direccion;
    private Date   fechaInicio;

    public Campus(){
    }
    public Campus(int pId,String pNombre,String pDireccion,Date pFechaInicio){
        if( pId < 0 || (String.valueOf(pId).length())<4){
            throw new IllegalArgumentException("El ID es incorrecto.");
        }
        this.ID = pId;
        if(pNombre.length()<3){
            throw new IllegalArgumentException("El nombre es muy corto.");
        }
        this.nombre = pNombre;
        if(pDireccion.length()<4){
            throw new IllegalArgumentException("La direccion es muy corta.");
        }
        this.direccion = pDireccion;
        this.fechaInicio = pFechaInicio;
    }

    public int    getID() {
        return ID;
    }
    public void   setID(int pId) {
        if( pId < 0 || (String.valueOf(pId).length())<4){
            throw new IllegalArgumentException("El ID es incorrecto.");
        }
        this.ID = pId;
    }
    public String getNombre() {
        return nombre;
    }
    public void   setNombre(String pNombre) {
        if(pNombre.length()<3){
            throw new IllegalArgumentException("El nombre es muy corto.");
        }
        this.nombre = pNombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void   setDireccion(String pDireccion) {
        if(pDireccion.length()<4){
            throw new IllegalArgumentException("La direccion es muy corta.");
        }
        this.direccion = pDireccion;
    }
    public Date   getFechaInicio() {
        return fechaInicio;
    }
    public void   setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void    registrarCampus(ListaCampus listaCampus){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Campus campus = new Campus();
        int ID;
        try{
            do{
                System.out.print("Ingrese el ID: ");
                ID = teclado.nextInt();
                if(validarID(listaCampus,ID))
                    System.out.println("El ID ya esta en uso.");
            }while(validarID(listaCampus,ID));
            campus.setID(ID);
            System.out.print("Ingrese el nombre: ");
            campus.setNombre(teclado.next());
            System.out.print("Ingrese la direccion: ");
            campus.setDireccion(teclado.next());
            System.out.print("Ingrese la fecha de inicio: ");
            Date fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse(teclado.next());
            campus.setFechaInicio(fechaInicio);
            listaCampus.addCampus(campus);

        }catch(ParseException e){
            throw new IllegalArgumentException("Error " + e.getMessage());
        }
    }
    public boolean validarID(ListaCampus listaCampus,int ID){
        boolean condicion = false;
        for (Campus campus: listaCampus.getListaCampus()) {
            if (ID == campus.getID()) {
                condicion = true;
                break;
            }
        }
        return condicion;
    }
}
