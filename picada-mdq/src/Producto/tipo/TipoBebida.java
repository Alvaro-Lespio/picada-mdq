package Producto.tipo;

public enum TipoBebida {
    COCA_COLA("coca cola",21.0),
    SPRITE("sprite",2.0),
    FANTA("fanta",32.0),
    CERVEZA_QUILMES("cerveza quilmes",9.0),
    AGUA("agua",7.0);

    private String nombre;
    private double precio;

    TipoBebida(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
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
        }else if (bebida.equalsIgnoreCase(AGUA.getNombre())){
            return AGUA;
        }else{
            return null;
        }


    }
}
