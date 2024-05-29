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
    
    public JSONObject personaToJSON() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nombre",nombre);
        jsonObject.put("apellido", apellido);
        JSONObject direccion = new JSONObject();
        direccion.put("calle", calle);
        direccion.put("numero", numero);
        jsonObject.put("direccion", direccion);
        jsonObject.put("email", email);
        return jsonObject;
    }

    public static Persona JSONToPersona(JSONObject persona) throws Exception{
        String nombre = persona.getString("nombre");
        String apellido = persona.getString("apellido");
        JSONObject direccion = persona.getJSONObject("direccion");
        String calle = direccion.getString("calle");
        int numero = direccion.getInt("numero");
        String email = persona.getString("email");
        Persona persona1 = new Persona(nombre, apellido, calle, numero, email);
        return persona1;
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
