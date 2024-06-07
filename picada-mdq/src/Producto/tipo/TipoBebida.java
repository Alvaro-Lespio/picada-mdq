package Producto.tipo;

/**
 * El enum TipoBebida enumera diferentes tipos de bebidas con sus respectivos nombres y precios.
 * Cada tipo de bebida tiene un nombre y un precio asociado.
 */
public enum TipoBebida {
    COCA_COLA("coca cola",21.0),
    SPRITE("sprite",2.0),
    FANTA("fanta",32.0),
    CERVEZA_QUILMES("cerveza quilmes",9.0),
    AGUA("agua",7.0);

    private String nombre;
    private double precio;

    /**
     * Constructor de TipoBebida.
     * @param nombre El nombre del tipo de bebida.
     * @param precio El precio del tipo de bebida.
     */
    TipoBebida(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del tipo de bebida.
     * @return El nombre del tipo de bebida.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio del tipo de bebida.
     * @return El precio del tipo de bebida.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Verifica y obtiene el tipo de bebida correspondiente al nombre proporcionado.
     * @param bebida El nombre del tipo de bebida a verificar.
     * @return El tipo de bebida correspondiente, o null si no se encuentra.
     */
    public static TipoBebida verificarBebida(String bebida) {
        if(bebida.equalsIgnoreCase(COCA_COLA.getNombre())) {
            return COCA_COLA;
        }else if(bebida.equalsIgnoreCase(SPRITE.getNombre())) {
            return SPRITE;
        }else if(bebida.equalsIgnoreCase(FANTA.getNombre())) {
            return FANTA;
        }else if(bebida.equalsIgnoreCase(CERVEZA_QUILMES.getNombre())){
            return CERVEZA_QUILMES;
        }else if (bebida.equalsIgnoreCase(AGUA.getNombre())){
            return AGUA;
        }else{
            return null;
        }


    }
}
