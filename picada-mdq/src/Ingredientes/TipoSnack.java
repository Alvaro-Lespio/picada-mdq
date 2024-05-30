package Ingredientes;

public enum TipoSnack {
    PAPAS_FRITAS("papas fritas"),
    PALITOS("palitos"),
    MANI("mani"),
    CHIZITO("chizito");
    private String nombre;
    private TipoSnack(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }




}


