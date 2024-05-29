package SesionDeUsuario;

import org.json.JSONObject;

public class Persona {
    //Atributos
    private String nombre;
    private String apellido;
    private String calle;
    private int numero;
    private String email;

    public Persona() {//Constructor vacio
        this.nombre = "";
        this.apellido = "";
        this.calle = "";
        this.numero = 0;
        this.email = "";
    }

    //Constructor completo
    public Persona(String nombre, String apellido, String calle, int numero, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.calle = calle;
        this.numero = numero;
        this.email = email;
    }

    //Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }
    

    @Override
    public String toString() {//Metodo toString para mostrar los datos de la clase persona
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", email='" + email + '\'' +
                '}';
    }
}
