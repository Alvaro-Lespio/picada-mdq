package Producto.tipo;

public enum TipoBebida {
    COCA_COLA("coca cola"),
    SPRITE("sprite"),
    FANTA("fanta"),
    CERVEZA_QUILMES("cerveza quilmes"),
    AGUA("agua");

    private String nombre;

    TipoBebida(String nombre) {
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public static TipoBebida verificarBebida(String bebida) {
        if(bebida.equalsIgnoreCase(COCA_COLA.getNombre())) {
            return COCA_COLA;
        }else if(bebida.equalsIgnoreCase(SPRITE.getNombre())) {
            return SPRITE;
        }else if(bebida.equalsIgnoreCase(FANTA.getNombre())) {
            return FANTA;
        }else if(bebida.equalsIgnoreCase(CERVEZA_QUILMES.getNombre())){
            return CERVEZA_QUILMES;
        }else{
            return AGUA;
        }


    }
}
