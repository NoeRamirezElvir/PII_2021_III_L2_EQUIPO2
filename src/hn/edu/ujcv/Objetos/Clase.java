package hn.edu.ujcv.Objetos;
public abstract class Clase implements IClase{
    private int Id;
    private int NA1;
    private int NA2;
    private int NA3;
    private int NE1;
    private int NE2;
    private int NE3;
    private int NR;
    private String Nombre;
    private int UnidadesValorativas;

    public int  getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public int    getNA1() {
        return NA1;
    }
    public void   setNA1(int NA1) {
        this.NA1 = NA1;
    }
    public int    getNA2() {
        return NA2;
    }
    public void   setNA2(int NA2) {
        this.NA2 = NA2;
    }
    public int    getNA3() {
        return NA3;
    }
    public void   setNA3(int NA3) {
        this.NA3 = NA3;
    }
    public int    getNE1() {
        return NE1;
    }
    public void   setNE1(int NE1) {
        this.NE1 = NE1;
    }
    public int    getNE2() {
        return NE2;
    }
    public void   setNE2(int NE2) {
        this.NE2 = NE2;
    }
    public int    getNE3() {
        return NE3;
    }
    public void   setNE3(int NE3) {
        this.NE3 = NE3;
    }
    public int    getNR() {
        return NR;
    }
    public void   setNR(int NR) {
        this.NR = NR;
    }
    public String getNombre() {
        return Nombre;
    }
    public void   setNombre(String nombre) {
        Nombre = nombre;
    }
    public int    getUnidadesValorativas() {
        return UnidadesValorativas;
    }
    public void   setUnidadesValorativas(int unidadesValorativas) {
        UnidadesValorativas = unidadesValorativas;
    }

    public Clase() {
    }
    public Clase(int pId,String pNombre,int pUnidadesValorativas, int pNA1,int pNE1,int pNA2,int pNE2,
                 int pNA3, int pNE3,int pNR) {
        this.Id = pId;
        this.Nombre = pNombre;
        this.UnidadesValorativas = pUnidadesValorativas;
        this.NA1 = pNA1;
        this.NE1 = pNE1;
        this.NA2 = pNA2;
        this.NE2 = pNE2;
        this.NA3 = pNA3;
        this.NE3 = pNE3;
        this.NR  = pNR;
    }
    public abstract void registarClase(ListaClases listaClases);
    @Override
    public double calcularNotaFinal() {
        return 0d;
    }
    @Override
    public String toString(){
        return "Asignatura: ".concat(Nombre).concat(" UV: ").concat(String.valueOf(UnidadesValorativas));
    }
}
