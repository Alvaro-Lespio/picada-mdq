package Producto.tipo;

public enum TipoQueso {
    REGGIANITO("reggianito", 1.0f),
    ROQUEFORT("roquefort", 1.0f),
    CHEDDAR("cheddar", 1.0f),
    GOUDA("gouda", 1.0f),
    DE_MAQUINA("de maquina", 1.0f),
    MAR_DEL_PLATA("mar del plata", 1.0F);

    private String nombre;
    private float precio;

    TipoQueso(String nombre, float precio) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public float getPrecio() {
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

        } else {
            return MAR_DEL_PLATA;
        }
    }


}
