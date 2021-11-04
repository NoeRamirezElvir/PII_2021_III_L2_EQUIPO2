package hn.edu.ujcv;

import hn.edu.ujcv.Objetos.*;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        try {
            //Instancias
            Alumno                       alumno   = new Alumno();
            Catedratico             catedratico   = new Catedratico();
            Campus                       campus   = new Campus();
            Carrera                     carrera   = new Carrera();
            Periodo                     periodo   = new Periodo();
            Clase                       clase1    = new Idioma();
            Clase                       clase2    = new Ingenieria();
            Clase                       clase3    = new Avanzada();
            Historial                   historial = new Historial();
            //Listas
            ListaAlumnos           listaAlumnos  = new ListaAlumnos();
            ListaCatedraticos listaCatedraticos  = new ListaCatedraticos();
            ListaCampus             listaCampus  = new ListaCampus();
            ListaCarreras         listaCarreras  = new ListaCarreras();
            ListaPeriodos         listaPeriodos  = new ListaPeriodos();
            ListaClases             listaClases  = new ListaClases();
            ListaHistoriales      listaHistorial = new ListaHistoriales();
            do {
                System.out.println("                     MENU  ");
                System.out.println("1. Agregar Alumno             8. Lista de Alumnos");
                System.out.println("2. Agregar Catedratico        9. Lista de Catedraticos");
                System.out.println("3. Agregar Campus            10. Lista de Campus");
                System.out.println("4. Agregar Carrera           11. Lista de las Carreras ");
                System.out.println("5. Agregar Periodo           12. Lista de los Periodos");
                System.out.println("6. Agregar Historial         13. Lista de Historiales ");
                System.out.println("7. Agregar Clases            14. Lista de Clases ");
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
                        historial.agregarHistorial(listaAlumnos,listaCampus,listaCarreras,listaPeriodos,listaClases);
                        break;
                    case 7:
                        //agregar Clases
                        do {
                            System.out.println("                Menu Clases  ");
                            System.out.println("1. Agregar Clase General          2. Agregar Clase Avanzada");
                            System.out.print("Elija una opcion: ");
                            switch (teclado.nextInt()){
                                case 1:
                                    do {

                                        System.out.println("                Clases Generales  ");
                                        System.out.println("1. Agregar Ingenieria          2. Agregar Idioma");
                                        System.out.print("Elija una opcion: ");
                                        switch (teclado.nextInt()){
                                            case 1:
                                                clase2.registarClase(listaClases);
                                                break;
                                            case 2:
                                                clase1.registarClase(listaClases);
                                                break;
                                            default:
                                                System.out.println("Opcion Invalida!");
                                                break;
                                        }
                                        System.out.print("Desea continuar S/N: ");
                                    }while (teclado.next().equalsIgnoreCase("s"));
                                case 2:
                                    clase3.registarClase(listaClases);
                                    break;
                                default:
                                    System.out.println("Opcion Invalida!");
                                    break;
                            }
                            System.out.print("Desea continuar S/N: ");
                        }while (teclado.next().equalsIgnoreCase("s"));
                        break;
                    case 8:
                        //Lista de Alumnos
                        listaAlumnos.imprimirLista();
                        break;
                    case 9:
                        //Lista de Catedraticos
                        listaCatedraticos.imprimirLista();
                        break;
                    case 10:
                        //Lista de Campus
                        listaCampus.imprimirLista();
                        break;
                    case 11:
                        //Lista de Carreras
                        listaCarreras.imprimirLista();
                        break;
                    case 12:
                        //Lista de Periodos
                        listaPeriodos.imprimirLista();
                        break;
                    case 13:
                        //Lista de Historiales
                        listaHistorial.ImprimirLista();
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
