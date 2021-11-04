package hn.edu.ujcv.Objetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Periodo {
  private int    ID;
  private String descripcion;
  private Date   fechaInicio;
  private Date   fechaFinal;

  public Periodo(){}
  public Periodo(int pId,String pDescripcion,Date pFechaInicio,Date pFechaFinal){
     if(pId <= 0){
     throw new IllegalArgumentException("El ID es incorrecto.");
     }
     this.ID          = pId;
     if(pDescripcion.length() < 5){
        throw new IllegalArgumentException("La descripcion es muy corta.");
     }
     this.descripcion = pDescripcion;
     this.fechaInicio = pFechaInicio;
     this.fechaFinal  = pFechaFinal;
  }

  public int    getID() {
     return ID;
  }
  public void   setID(int pId) {
     if(pId <= 0){
     throw new IllegalArgumentException("El ID es incorrecto.");
     }
     this.ID = pId;
  }
  public String getDescripcion() {
     return descripcion;
  }
  public void   setDescripcion(String pDescripcion) {
     if(pDescripcion.length() < 5){
      throw new IllegalArgumentException("La descripcion es muy corta.");
     }
     this.descripcion = pDescripcion;
  }
  public Date   getFechaInicio() {
      return fechaInicio;
  }
  public void   setFechaInicio(Date fechaInicio) {
     this.fechaInicio = fechaInicio;
  }
  public Date   getFechaFinal() {
     return fechaFinal;
  }
  public void   setFechaFinal(Date fechaFinal) {
     this.fechaFinal = fechaFinal;
  }

  public void   registrarPeriodo(ListaPeriodos listaPeriodos){
     Scanner teclado = new Scanner(System.in).useDelimiter("\n");
     Periodo periodo = new Periodo();
     try{
         int ID;
         do{
         System.out.print("Ingrese el ID: ");
         ID = teclado.nextInt();
         if(validarID(listaPeriodos,ID))
         System.out.println("El ID ya esta en uso.");
         }while(validarID(listaPeriodos,ID));
         periodo.setID(ID);
         System.out.print("Ingrese una descripcion: ");
         periodo.setDescripcion(teclado.next());
         System.out.print("Ingrese la fecha de inicio del periodo:");
         Date fechaInicio = new SimpleDateFormat("dd/MM/yyyy").parse(teclado.next());
         periodo.setFechaInicio(fechaInicio);
         System.out.print("Ingrese la fecha del final del periodo:");
         Date fechaFinal = new SimpleDateFormat("dd/MM/yyyy").parse(teclado.next());
         periodo.setFechaFinal(fechaFinal);
         listaPeriodos.addPeriodo(periodo);
     }catch(ParseException e){
           throw new IllegalArgumentException("Error " + e.getMessage());
     }
  }
 public boolean validarID(ListaPeriodos listaPeriodos,int ID){
  boolean condicion = false;
  for (Periodo periodo: listaPeriodos.getListaPeriodos()) {
   if (ID == periodo.getID()) {
    condicion = true;
    break;
   }
  }
  return condicion;
 }
}
