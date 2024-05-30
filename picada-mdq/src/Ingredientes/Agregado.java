package Ingredientes;

public class Agregado
{
    private Bebida bebida;
    //private Pan pan;

    public Agregado(Bebida bebida) {
        this.bebida = bebida;
    }

    public Agregado() {
    }

    @Override
    public String toString() {
        return super.toString()+" Agregado{" +
                "bebida=" + bebida +
                '}';
    }
}
