package Producto.tipo;

public enum TipoFiambre {
    JAMON_COCIDO("jamon cocido",4.0),
    JAMON_CRUDO("jamon crudo",6.0),
    SALAME("salame",7.0),
    MORTADELA("mortadela",10.0),
    LOMITO("lomito",3.0);

    private String nombre;
    private double precio;

    TipoFiambre(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }


    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public static TipoFiambre verificarFiambre(String fiambre) {
        if (fiambre.equalsIgnoreCase(JAMON_COCIDO.getNombre())) {
            return JAMON_COCIDO;
        } else if (fiambre.equalsIgnoreCase(JAMON_CRUDO.getNombre())) {
            return JAMON_CRUDO;
        } else if (fiambre.equalsIgnoreCase(SALAME.getNombre())) {
            return SALAME;
        } else if (fiambre.equalsIgnoreCase(MORTADELA.getNombre())) {
            return MORTADELA;
        } else if(fiambre.equalsIgnoreCase(LOMITO.getNombre())){
            return LOMITO;
        }else{
            return null;
        }
    }
}
