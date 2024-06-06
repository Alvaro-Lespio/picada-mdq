package Producto.tipo;

public enum TipoQueso {
    REGGIANITO("reggianito", 2.0),
    ROQUEFORT("roquefort", 3.0),
    CHEDDAR("cheddar", 2.0),
    GOUDA("gouda", 5.0),
    DE_MAQUINA("de maquina", 6.0),
    MAR_DEL_PLATA("mar del plata", 9.0);

    private String nombre;
    private double precio;

    TipoQueso(String nombre, double precio) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public static TipoQueso verificarQueso(String queso) {
        if (queso.equalsIgnoreCase("reggianito")) {
            return REGGIANITO;
        } else if (queso.equalsIgnoreCase("roquefort")) {
            return ROQUEFORT;
        } else if (queso.equalsIgnoreCase("cheddar")) {
            return CHEDDAR;
        } else if (queso.equalsIgnoreCase("gouda")) {
            return GOUDA;
        } else if (queso.equalsIgnoreCase("de maquina")) {
            return DE_MAQUINA;

        } else if(queso.equalsIgnoreCase("mar del plata")){
            return MAR_DEL_PLATA;
        }
        return null;
    }


}
