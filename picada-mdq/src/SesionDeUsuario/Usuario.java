package SesionDeUsuario;

import java.util.ArrayList;

public class Usuario extends Persona{
    //Atributos
    //private ArrayList<Pedido> pedidoArrayList;
    private String nombreUsuario;
    private String contrasenia;
    private int puntos;
    private double monto;
    private boolean isAdmin;

    public Usuario() {//Creo el constructor vacio
        this.nombreUsuario = "";
        this.contrasenia = "";
        this.puntos = 0;
        this.monto = 0;
        this.isAdmin = false;
    }

    //Constructor completo
    public Usuario(String nombre, String apellido, String direccion, String email, String nombreUsuario, String contrasenia, int puntos, double monto, Boolean isAdmin) {
        super(nombre, apellido, direccion, email);
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.puntos = puntos;
        this.monto = monto;
        this.isAdmin = isAdmin;
    }

    //Getters & Setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public int getPuntos() {
        return puntos;
    }

    public double getMonto() {
        return monto;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    @Override
    public String toString() {//Metodo toString que ademas de mostrar la clase usuario muestra lo de persona por el llamado al super
        return super.toString() + "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", puntos=" + puntos +
                ", monto=" + monto +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
