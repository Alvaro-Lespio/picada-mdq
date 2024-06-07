package SesionDeUsuario;

import org.json.JSONObject;

/**
 * La clase Persona representa a una persona con su información personal y de contacto.
 */
public class Persona {
    //Atributos
    private String nombre;
    private String apellido;
    private String calle;
    private int numero;
    private String email;

    /**
     * Constructor vacío de la clase Persona.
     * Inicializa los atributos con valores por defecto.
     */
    public Persona() {//Constructor vacio
        this.nombre = "";
        this.apellido = "";
        this.calle = "";
        this.numero = 0;
        this.email = "";
    }

    /**
     * Constructor completo de la clase Persona.
     * @param nombre El nombre de la persona.
     * @param apellido El apellido de la persona.
     * @param calle El nombre de la calle de la dirección de la persona.
     * @param numero El número de la dirección de la persona.
     * @param email El correo electrónico de la persona.
     */
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

    /**
     * Convierte la información de la persona a un objeto JSON.
     * @return Un objeto JSONObject que representa la información de la persona.
     * @throws Exception Si ocurre algún error durante la conversión.
     */
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

    /**
     * Convierte un objeto JSON a una instancia de la clase Persona.
     * @param persona El objeto JSON que contiene la información de la persona.
     * @return Una instancia de la clase Persona con la información proporcionada por el objeto JSON.
     * @throws Exception Si ocurre algún error durante la conversión.
     */
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

    /**
     * Devuelve una representación en forma de cadena de la información de la persona.
     * @return Una cadena que contiene la información de la persona.
     */
    @Override
    public String toString() {//Metodo toString para mostrar los datos de la clase persona
        return "{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", calle='" + calle + '\'' +
                ", numero=" + numero +
                ", email='" + email + '\''
                + ", ";
    }
}
