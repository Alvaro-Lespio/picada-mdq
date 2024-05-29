package Ingredientes;

public class Bebida
{
    private String tipo;
    private int cantidad;
    private String marca;
    private float cantLitros;


    public Bebida()
    {
        tipo="";
        cantidad=0;
        marca="";
        cantLitros=0;
    }
    public Bebida(String tipo, int cantidad, String marca, float cantLitros) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.marca = marca;
        this.cantLitros = cantLitros;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "tipo='" + tipo + '\'' +
                ", cantidad=" + cantidad +
                ", marca='" + marca + '\'' +
                ", cantLitros=" + cantLitros +
                '}';
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getCantLitros() {
        return cantLitros;
    }
}
