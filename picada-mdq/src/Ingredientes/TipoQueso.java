package Ingredientes;

public enum TipoQueso {
    MOZZARELLA("mozzarella"),
    ROQUEFORT("roquefort"),
    CHEDDAR("cheddar"),
    GOUDA("gouda");

    private String nombre;

    TipoQueso(String nombre) {
        this.nombre = nombre;
    }

    public static TipoQueso verificarQueso(String queso) {
        if(queso.equals("mozzarella")) {
            return MOZZARELLA;
        }else if(queso.equals("roquefort")) {
            return ROQUEFORT;
        }else if(queso.equals("cheddar")) {
            return CHEDDAR;
        }else{
            return GOUDA;
        }

    }
}
