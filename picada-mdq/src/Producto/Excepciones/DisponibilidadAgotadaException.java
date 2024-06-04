package Producto.Excepciones;

public class DisponibilidadAgotadaException extends RuntimeException{
    public DisponibilidadAgotadaException(String message) {
        super(message);
    }
}
