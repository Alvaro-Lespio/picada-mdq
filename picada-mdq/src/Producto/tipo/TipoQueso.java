package Producto.tipo;

public enum TipoQueso {
    MOZZARELLA("mozzarella"),
    ROQUEFORT("roquefort"),
    CHEDDAR("cheddar"),
    GOUDA("gouda");

    private String nombre;

    TipoQueso(String nombre) {
        this.nombre = nombre;
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
