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

    public static TipoSnack obtenerTipoSnack(String nombre){
        if(nombre.equalsIgnoreCase(PAPAS_FRITAS.getNombre())){
            return PAPAS_FRITAS;
        }else if(nombre.equalsIgnoreCase(PALITOS.getNombre())){
            return PALITOS;
        }else if(nombre.equalsIgnoreCase(MANI.getNombre())){
            return MANI;
        }else{
            return CHIZITO;
        }
    }




}


