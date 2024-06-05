package Producto.Excepciones;

public class ComboAgotadoException extends RuntimeException{
    public ComboAgotadoException(String message) {
        super(message);
    }
}
