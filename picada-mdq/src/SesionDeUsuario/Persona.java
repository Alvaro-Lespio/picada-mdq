package SesionDeUsuario;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private String direccion;
    private String email;

    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.email = "";
    }

    public Persona(String nombre, String apellido, String direccion, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
    }

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
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
