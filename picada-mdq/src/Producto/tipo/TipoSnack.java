package Producto.tipo;

public enum TipoSnack {
    PAPAS_FRITAS("papas fritas",9.0),
    PALITOS("palitos",10.0),
    MANI("mani",12.0),
    CHIZITO("chizito",9.0);

    private String nombre;
    private double precio;

    TipoSnack(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

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


