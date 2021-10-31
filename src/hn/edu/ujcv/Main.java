package hn.edu.ujcv;

import hn.edu.ujcv.Objetos.*;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        try {
            //Instancias
            Alumno                       alumno = new Alumno();
            Catedratico             catedratico = new Catedratico();
            Campus                       campus = new Campus();
            Carrera                     carrera = new Carrera();
            Periodo                     periodo = new Periodo();
            ListaAlumnos           listaAlumnos = new ListaAlumnos();
            ListaCatedraticos listaCatedraticos = new ListaCatedraticos();
            ListaCampus             listaCampus = new ListaCampus();
            ListaCarreras         listaCarreras = new ListaCarreras();
            ListaPeriodos         listaPeriodos = new ListaPeriodos();
            //Variables
            do {
                System.out.println("                     MENU  ");
                System.out.println("1. Agregar Alumno             7. Lista de Alumnos");
                System.out.println("2. Agregar Catedratico        8. Lista de Catedraticos");
                System.out.println("3. Agregar Campus             9. Lista de Campus");
                System.out.println("4. Agregar Carrera           10. Lista de las Carreras ");
                System.out.println("5. Agregar Periodo           11. Lista de los Periodos");
                System.out.println("6. Agregar Historial         12. Lista de Historiales ");
                System.out.print("Escriba el numero de la opcion: ");
                switch (teclado.nextInt()){
                    case 1:
                        //Agregar Alumno
                        alumno.registrarAlumno(listaAlumnos);
                        break;
                    case 2:
                        //Agregar Catedratico
                        catedratico.registrarCatedratico(listaCatedraticos);
                        break;
                    case 3:
                        //Agregar Campus
                        campus.registrarCampus(listaCampus);
                        break;
                    case 4:
                        //Agregar Carrera
                        carrera.registrarCarrera(listaCarreras);
                        break;
                    case 5:
                        //Agregar Periodo
                        periodo.registrarPeriodo(listaPeriodos);

                        break;
                    case 6:
                        //Agregar Historial

                        break;
                    case 7:
                        //Lista de Alumnos
                        listaAlumnos.imprimirLista();

                        break;
                    case 8:
                        //Lista de Catedraticos
                        listaCatedraticos.imprimirLista();
                        break;
                    case 9:
                        //Lista de Campus
                        listaCampus.imprimirLista();
                        break;
                    case 10:
                        //Lista de Carreras
                        listaCarreras.imprimirLista();
                        break;
                    case 11:
                        //Lista de Periodos
                        listaPeriodos.imprimirLista();
                        break;
                    case 12:
                        //Lista de Historiales
                        break;
                    default:
                        break;
                }

                System.out.print("Desea continuar S/N: ");
            }while((teclado.next()).equalsIgnoreCase("s"));

        }catch(Exception e){
            System.err.println("Error " + e.getMessage());
        }

    }
}
