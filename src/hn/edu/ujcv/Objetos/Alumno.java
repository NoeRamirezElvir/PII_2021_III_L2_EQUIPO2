package hn.edu.ujcv.Objetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Alumno extends Persona{
    private long numCuenta;

    public Alumno(){super();}
    public Alumno(long pId, String pNombre, Date pFechaNacimiento,long pNumCuenta){
        super(pId,pNombre,pFechaNacimiento);
        if((String.valueOf(pNumCuenta).length()) < 4){
            throw new IllegalArgumentException("El numero de cuenta es muy corto.");
        }
        this.numCuenta = pNumCuenta;
    }

    public long getNumCuenta() {
        return numCuenta;
    }
    public void setNumCuenta(long pNumCuenta) {
        if((String.valueOf(pNumCuenta).length()) < 4){
            throw new IllegalArgumentException("El numero de cuenta es muy corto.");
        }
        this.numCuenta = pNumCuenta;
    }


    public void registrarAlumno(ListaAlumnos listaAlumnos) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Alumno alumno = new Alumno();
        try {
            long id,cuenta;
            do{
                System.out.print("Ingrese el ID: ");
                id = teclado.nextLong();
                if(validarID(listaAlumnos,id))
                    System.out.println("El ID ya esta en uso.");
            }while(validarID(listaAlumnos,id));
            alumno.setID(id);
            System.out.print("Ingrese el nombre: ");
            alumno.setNombre(teclado.next());
            System.out.print("Ingrese la fecha de nacimiento(dd/MM/YYYY): ");
            Date fechaDeNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(teclado.next());
            alumno.setFechaNacimiento(fechaDeNacimiento);
            do{
                System.out.print("Ingrese el numero de cuenta: ");
                cuenta = teclado.nextLong();
                if(validarCuenta(listaAlumnos,cuenta))
                    System.out.println("El numero de cuenta ya esta en uso.");
            }while(validarCuenta(listaAlumnos,cuenta));
            alumno.setNumCuenta(cuenta);
            listaAlumnos.addAlumno(alumno);

        }catch(ParseException e){
            throw new IllegalArgumentException("Error " + e.getMessage());
        }
    }
    public boolean validarID(ListaAlumnos listaAlumnos, long id){
        boolean condicion = false;
        for (Alumno alumno: listaAlumnos.getListaAlumnos()) {
            if (id == alumno.getID()) {
                condicion = true;
                break;
            }
        }
        return condicion;
    }
    public boolean validarCuenta(ListaAlumnos listaAlumnos,long cuenta){
        boolean condicion = false;
        for (Alumno alumno: listaAlumnos.getListaAlumnos()) {
            if (cuenta == alumno.getNumCuenta()) {
                condicion = true;
                break;
            }
        }
        return condicion;
    }
}
