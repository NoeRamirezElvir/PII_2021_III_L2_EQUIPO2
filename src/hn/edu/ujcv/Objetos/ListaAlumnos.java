package hn.edu.ujcv.Objetos;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaAlumnos {
    private final ArrayList<Alumno> listaAlumnos;

    public      ListaAlumnos(){
        listaAlumnos = new ArrayList<>();
    }
    public void addAlumno(Alumno pAlumno){
            listaAlumnos.add(pAlumno);
    }
    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }
    public void imprimirLista(){
        System.out.println("    ID         Numero de cuenta          Nombre           Fecha de nacimiento            Edad  ");
        for (Alumno lista: listaAlumnos) {
            System.out.println(lista.getID() + "      " +
                    lista.getNumCuenta() + "          " +
                    lista.getNombre() + "      " +
                    lista.getFechaNacimiento()+ "        " +
                    lista.calcularEdad());
        }
    }
    public Alumno buscarAlumno(ListaAlumnos listaAlumnos){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        long    identidad;
        Alumno alumno = new Alumno();
        do {
            System.out.print(" Ingrese el Numero de Identidad: ");
            identidad = teclado.nextLong();
            for (Alumno alumnos: getListaAlumnos()) {
                if(identidad == alumnos.getID()) {
                    alumno = alumnos;
                }
            }
            if (!alumno.validarID(listaAlumnos,identidad))
                System.out.println("Digite una Id valida!");

        }while (!alumno.validarID(listaAlumnos,identidad));

        return alumno;
    }
}
