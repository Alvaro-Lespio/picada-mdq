package Producto.tipo;

public enum TipoFiambre {
    JAMON_COCIDO("jamon cocido",1.0f),
    JAMON_CRUDO("jamon crudo",1.0f),
    SALAME("salame",1.0f),
    MORTADELA("mortadela",1.0f),
    LOMITO("lomito",1.0f);

    private String nombre;
    private float precio;

    TipoFiambre(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }


    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
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
        } else {
            return LOMITO;
        }
    }
}
