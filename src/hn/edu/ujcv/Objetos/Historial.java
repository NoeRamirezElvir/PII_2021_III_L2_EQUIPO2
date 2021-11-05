package hn.edu.ujcv.Objetos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Historial implements IHistorial {
    private Alumno Alumno;
    private Campus Campus;
    private Carrera Carrera;
    private ArrayList<Clase> Clases;
    private Periodo Periodo;

    public Historial() {
    }

    public Historial(Alumno pAlumno, Campus pCampus, Carrera pCarrera, ArrayList<Clase> pClases, Periodo pPeriodo) {
        this.Alumno = pAlumno;
        this.Campus = pCampus;
        this.Carrera = pCarrera;
        this.Clases = pClases;
        this.Periodo = pPeriodo;
    }

    public Alumno getAlumno() {
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
                                 ListaPeriodos listaPeriodos, ListaClases listaClases, ListaHistoriales listaHistorial) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Historial historial = new Historial();
        ArrayList<Clase> clases = new ArrayList<>();
        ListaAlumnos  alumnos  = new ListaAlumnos();
        ListaCampus   campus   = new ListaCampus();
        ListaCarreras carreras = new ListaCarreras();
        ListaPeriodos periodos = new ListaPeriodos();

        System.out.println("-----Alumno-----");
        listaAlumnos.imprimirLista();
        historial.setAlumno(alumnos.buscarAlumno(listaAlumnos));
        System.out.println("-----Campus-----");
        listaCampus.imprimirLista();
        historial.setCampus(campus.buscarCampus(listaCampus));
        System.out.println("-----Carrera-----");
        listaCarreras.imprimirLista();
        historial.setCarrera(carreras.buscarCampus(listaCarreras));
        System.out.println("-----Periodo-----");
        listaPeriodos.imprimirLista();
        historial.setPeriodo(periodos.buscarCampus(listaPeriodos));
        listaHistorial.AddHistorial(historial);
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
