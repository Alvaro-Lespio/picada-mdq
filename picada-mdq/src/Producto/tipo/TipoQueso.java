package Producto.tipo;

/**
 * El enum TipoQueso enumera diferentes tipos de quesos con sus respectivos nombres y precios.
 * Cada tipo de queso tiene un nombre y un precio asociado.
 */
public enum TipoQueso {
    REGGIANITO("reggianito", 2.0),
    ROQUEFORT("roquefort", 3.0),
    CHEDDAR("cheddar", 2.0),
    GOUDA("gouda", 5.0),
    DE_MAQUINA("de maquina", 6.0),
    MAR_DEL_PLATA("mar del plata", 9.0);

    private String nombre;
    private double precio;

    /**
     * Constructor de TipoQueso.
     * @param nombre El nombre del tipo de queso.
     * @param precio El precio del tipo de queso.
     */
    TipoQueso(String nombre, double precio) {
        this.precio = precio;
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del tipo de queso.
     * @return El precio del tipo de queso.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Obtiene el nombre del tipo de queso.
     * @return El nombre del tipo de queso.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Verifica y obtiene el tipo de queso correspondiente al nombre proporcionado.
     * @param queso El nombre del tipo de queso a verificar.
     * @return El tipo de queso correspondiente, o null si no se encuentra.
     */
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
