package SesionDeUsuario;

public abstract class Persona {
    //Atributos
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;

    public Persona() {//Constructor vacio
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.email = "";
    }

    //Constructor completo
    public Persona(String nombre, String apellido, String direccion, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
    }

    //Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {//Metodo toString para mostrar los datos de la clase persona
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
