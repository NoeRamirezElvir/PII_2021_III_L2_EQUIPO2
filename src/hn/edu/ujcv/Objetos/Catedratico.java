package hn.edu.ujcv.Objetos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Catedratico extends Persona{
    private int codigo;

    public Catedratico() {
        super();
    }
    public Catedratico(long pId, String pNombre, Date pFechaNacimiento,int pCodigo){
        super(pId,pNombre,pFechaNacimiento);
        if((String.valueOf(pCodigo).length()) < 2 ){
            throw new IllegalArgumentException("El codigo es muy corto.");
        }
        this.codigo = pCodigo;
    }

    public int  getCodigo() {
        return codigo;
    }
    public void setCodigo(int pCodigo) {
        if((String.valueOf(pCodigo).length()) <2 ){
            throw new IllegalArgumentException("El codigo es muy corto.");
        }
        this.codigo = pCodigo;
    }

    public void    registrarCatedratico(ListaCatedraticos listaCatedraticos){
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Catedratico catedratico = new Catedratico();
        try{
            int codigo;
            long ID;
            do{
                System.out.print("Ingrese el ID: ");
                ID = teclado.nextLong();
                if(validarID(listaCatedraticos,ID))
                    System.out.println("El ID ya esta en uso.");
            }while(validarID(listaCatedraticos,ID));
            catedratico.setID(ID);
            System.out.print("Ingrese el nombre: ");
            catedratico.setNombre(teclado.next());
            System.out.print("Ingrese la fecha de nacimiento(dd/MM/YYYY): ");
            Date fechaDeNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(teclado.next());
            catedratico.setFechaNacimiento(fechaDeNacimiento);
            do{
                System.out.print("Ingrese el codigo: ");
                 codigo = teclado.nextInt();
                if(validarCodigo(listaCatedraticos,codigo))
                    System.out.println("El codigo ya esta en uso.");
            }while(validarCodigo(listaCatedraticos,codigo));
            catedratico.setCodigo(codigo);
            listaCatedraticos.addCatedratico(catedratico);
        }catch(ParseException e){
            throw new IllegalArgumentException("Error " + e.getMessage());
        }


    }
    public boolean validarID(ListaCatedraticos listaCatedraticos, long id){
        boolean condicion = false;
        for (Catedratico catedratico: listaCatedraticos.getListaCatedraticos()) {
            if (id == catedratico.getID()) {
                condicion = true;
                break;
            }
        }
        return condicion;
    }
    public boolean validarCodigo(ListaCatedraticos listaCatedraticos,long codigo){
        boolean condicion = false;
        for (Catedratico catedratico: listaCatedraticos.getListaCatedraticos()) {
            if (codigo == catedratico.getCodigo()) {
                condicion = true;
                break;
            }
        }
        return condicion;
    }
}
