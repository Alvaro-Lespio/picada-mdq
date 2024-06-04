package Producto.tipo;

public enum TipoFiambre {
    JAMON_COCIDO("jamon cocido"),
    JAMON_CRUDO("jamon crudo"),
    SALAME("salame"),
    MORTADELA("mortadela");

    private String nombre;

    TipoFiambre(String nombre) {
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public static TipoFiambre verificarFiambre(String fiambre) {
        if(fiambre.equalsIgnoreCase(JAMON_COCIDO.getNombre())) {
            return JAMON_COCIDO;
        }else if(fiambre.equalsIgnoreCase(JAMON_CRUDO.getNombre())) {
            return JAMON_CRUDO;
        }else if(fiambre.equalsIgnoreCase(SALAME.getNombre())) {
            return SALAME;
        }else{
            return MORTADELA;
        }

    }
}
