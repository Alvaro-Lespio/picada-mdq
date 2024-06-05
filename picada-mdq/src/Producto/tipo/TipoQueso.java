package Producto.tipo;

public enum TipoQueso {
    MOZZARELLA("mozzarella",1.0f),
    ROQUEFORT("roquefort",1.0f),
    CHEDDAR("cheddar",1.0f),
    GOUDA("gouda",1.0f),;

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
        if(queso.equalsIgnoreCase("mozzarella")) {
            return MOZZARELLA;
        }else if(queso.equalsIgnoreCase("roquefort")) {
            return ROQUEFORT;
        }else if(queso.equalsIgnoreCase("cheddar")) {
            return CHEDDAR;
        }else{
            return GOUDA;
        }

    }
}
