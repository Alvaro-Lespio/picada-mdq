package Producto.tipo;

/**
 * El enum TipoFiambre enumera diferentes tipos de fiambres con sus respectivos nombres y precios.
 * Cada tipo de fiambre tiene un nombre y un precio asociado.
 */
public enum TipoFiambre {
    JAMON_COCIDO("jamon cocido",4.0),
    JAMON_CRUDO("jamon crudo",6.0),
    SALAME("salame",7.0),
    MORTADELA("mortadela",10.0),
    LOMITO("lomito",3.0);

    private String nombre;
    private double precio;

    /**
     * Constructor de TipoFiambre.
     * @param nombre El nombre del tipo de fiambre.
     * @param precio El precio del tipo de fiambre.
     */
    TipoFiambre(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del tipo de fiambre.
     * @return El nombre del tipo de fiambre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio del tipo de fiambre.
     * @return El precio del tipo de fiambre.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Verifica y obtiene el tipo de fiambre correspondiente al nombre proporcionado.
     * @param fiambre El nombre del tipo de fiambre a verificar.
     * @return El tipo de fiambre correspondiente, o null si no se encuentra.
     */
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
