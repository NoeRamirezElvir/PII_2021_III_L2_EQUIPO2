package hn.edu.ujcv.Objetos;


import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;


public abstract class Persona {
    private long ID;
    private String nombre;
    private Date fechaNacimiento;

    public Persona() {
    }
    public Persona(long pId, String pNombre, Date pFechaNacimiento) {
        if((String.valueOf(pId).length())<7){
            throw new IllegalArgumentException("El ID es muy corto.");
        }
        this.ID = pId;
        if((pNombre.length())<3){
            throw new IllegalArgumentException("El Nombre es muy corto.");
        }
        this.nombre = pNombre;
        this.fechaNacimiento = pFechaNacimiento;
    }
    public long   getID() {
        return ID;
    }
    public void   setID(long pId) {
        if((String.valueOf(pId).length())<7){
            throw new IllegalArgumentException("El ID es muy corto.");
        }
        this.ID = pId;
    }
    public String getNombre() {
        return nombre;
    }
    public void   setNombre(String pNombre) {
        if((pNombre.length())<3){
            throw new IllegalArgumentException("El Nombre es muy corto.");
        }
        this.nombre = pNombre;
    }
    public Date   getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void   setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public int    calcularEdad(){
            LocalDate fechaDeNacimiento = getFechaNacimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate fechaActual = LocalDate.now();
            Period periodo = Period.between(fechaDeNacimiento, fechaActual);

        return periodo.getYears();
    }
}
