package hn.edu.ujcv.Objetos;

public class General extends Clase{
    private boolean TodasCarreras;

    public General(){super();}

    @Override
    public void registarClase(ListaClases listaClases){

    }

    public General(boolean pTodasCarreras,int pId,String pNombre,int pUnidadesValorativas, int pNA1,int pNE1,int pNA2,int pNE2,
                   int pNA3, int pNE3,int pNR){
        super(pId,pNombre,pUnidadesValorativas,pNA1,pNE1,pNA2,pNE2,pNA3,pNE3,pNR);
        this.TodasCarreras = pTodasCarreras;
    }

    public boolean isTodasCarreras() {
        return TodasCarreras;
    }

    public void setTodasCarreras(boolean todasCarreras) {
        this.TodasCarreras = todasCarreras;
    }
    @Override
    public String toString(){
        return super.toString();
    }
}
