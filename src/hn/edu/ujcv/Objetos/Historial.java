package hn.edu.ujcv.Objetos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Historial implements IHistorial{
    private Alumno  Alumno;
    private Campus  Campus;
    private Carrera Carrera;
    private ArrayList<Clase> Clases;
    private Periodo Periodo;
    public Historial(){}
    public Historial(Alumno pAlumno,Campus pCampus, Carrera pCarrera, ArrayList<Clase> pClases,Periodo pPeriodo){
        this.Alumno  = pAlumno;
        this.Campus  = pCampus;
        this.Carrera = pCarrera;
        this.Clases  = pClases;
        this.Periodo = pPeriodo;
    }

    public hn.edu.ujcv.Objetos.Alumno getAlumno() {
        return Alumno;
    }

    public void setAlumno(Alumno alumno) {
        Alumno = alumno;
    }

    public Campus getCampus() {
        return Campus;
    }

    public void setCampus(Campus campus) {
        Campus = campus;
    }

    public Carrera getCarrera() {
        return Carrera;
    }

    public void setCarrera(Carrera carrera) {
        Carrera = carrera;
    }

    public Periodo getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(Periodo periodo) {
        Periodo = periodo;
    }

    public ArrayList<Clase> getClases() {
        return Clases;
    }

    public void setClases(ArrayList<Clase> clases) {
        Clases = clases;
    }

    public void agregarHistorial(ListaAlumnos listaAlumnos, ListaCampus listaCampus, ListaCarreras listaCarreras,
                                 ListaPeriodos listaPeriodos,ListaClases listaClases){
        Scanner teclado     = new Scanner(System.in).useDelimiter("\n");
        Historial historial = new Historial();
        Alumno alumno   = new Alumno();
        Campus campus   = new Campus();
        Carrera carrera = new Carrera();
        Periodo periodo = new Periodo();
        ArrayList<Clase> clases = new ArrayList<>();
            System.out.println("-----Alumno-----");
            alumno.registrarAlumno(listaAlumnos);
            historial.setAlumno(alumno);
            System.out.println("-----Campus-----");
            campus.registrarCampus(listaCampus);
            historial.setCampus(campus);

            System.out.println("-----Carrera-----");
            carrera.registrarCarrera(listaCarreras);
            historial.setCarrera(carrera);

            System.out.println("-----Periodo-----");
            periodo.registrarPeriodo(listaPeriodos);
            historial.setPeriodo(periodo);
            System.out.println("-----Clases-----");
        do {
            do {
                General claseGeneral   = new Ingenieria();
                General claseGeneral2  = new Idioma();
                Avanzada claseAvanzada = new Avanzada();
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
                                    claseGeneral.registarClase(listaClases);
                                    clases.add(claseGeneral);
                                    break;
                                case 2:
                                    claseGeneral2.registarClase(listaClases);
                                    clases.add(claseGeneral2);
                                    break;
                                default:
                                    System.out.println("Opcion Invalida!");
                                    break;
                            }
                            System.out.print("Desea continuar S/N: ");
                        }while (teclado.next().equalsIgnoreCase("s"));
                    case 2:
                        claseAvanzada.registarClase(listaClases);
                        clases.add(claseAvanzada);
                        break;
                    default:
                        System.out.println("Opcion Invalida!");
                        break;
                }
                System.out.print("Desea Añadir otra clase General? S/N: ");
            }while (teclado.next().equalsIgnoreCase("s"));

            System.out.print("Desea Añadir otra Clase? S/N: ");
            }while (teclado.next().equalsIgnoreCase("s"));
        historial.setClases(clases);
            }

    @Override
    public String toString(){

        return " Alumno: ".concat(getAlumno().getNombre()).concat(" Carnet: ".concat(String.valueOf(getAlumno().getNumCuenta())
                .concat("\nCarrera: ").concat(getCarrera().getNombre())).concat("\nCampus: ").concat(getCampus().getNombre())
                .concat("\nPeriodo: ").concat(getPeriodo().getDescripcion())).concat("    Promedio del periodo: ")
                .concat(String.valueOf(calcularPromedio()));
    }
    @Override
    public double calcularPromedio() {
        double promedio = 0.0;
            Iterator<Clase> itClases = getClases().iterator();
        while(itClases.hasNext()){
            promedio += itClases.next().calcularNotaFinal();
        }
        return promedio/getClases().size();
    }
}
