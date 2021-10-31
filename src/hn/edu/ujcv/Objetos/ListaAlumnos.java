package hn.edu.ujcv.Objetos;

import java.util.ArrayList;

public class ListaAlumnos {
    private final ArrayList<Alumno> listaAlumnos;

    public ListaAlumnos(){
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
}
