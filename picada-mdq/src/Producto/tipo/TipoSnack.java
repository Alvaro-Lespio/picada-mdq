package Producto.tipo;

/**
 * El enum TipoSnack enumera diferentes tipos de snacks con sus respectivos nombres y precios.
 * Cada tipo de snack tiene un nombre y un precio asociado.
 */
public enum TipoSnack {
    PAPAS_FRITAS("papas fritas",9.0),
    PALITOS("palitos",10.0),
    MANI("mani",12.0),
    CHIZITO("chizito",9.0);

    private String nombre;
    private double precio;

    /**
     * Constructor de TipoSnack.
     * @param nombre El nombre del tipo de snack.
     * @param precio El precio del tipo de snack.
     */
    TipoSnack(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Obtiene el nombre del tipo de snack.
     * @return El nombre del tipo de snack.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio del tipo de snack.
     * @return El precio del tipo de snack.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Verifica y obtiene el tipo de snack correspondiente al nombre proporcionado.
     * @param nombre El nombre del tipo de snack a verificar.
     * @return El tipo de snack correspondiente, o null si no se encuentra.
     */
    public static TipoSnack verificarSnack(String nombre){
        if(nombre.equalsIgnoreCase(PAPAS_FRITAS.getNombre())){
            return PAPAS_FRITAS;
        }else if(nombre.equalsIgnoreCase(PALITOS.getNombre())){
            return PALITOS;
        }else if(nombre.equalsIgnoreCase(MANI.getNombre())){
            return MANI;
        }else if(nombre.equalsIgnoreCase(CHIZITO.getNombre())){
            return CHIZITO;
        }else{
            return null;
        }
    }
}


