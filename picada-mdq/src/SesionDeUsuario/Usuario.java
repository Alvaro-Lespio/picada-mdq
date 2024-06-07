package SesionDeUsuario;

import org.json.JSONArray;
import org.json.JSONObject;
import pedido.Pedido;
import picada.Picada;

import java.util.ArrayList;

/**
 * La clase Usuario representa a un usuario del sistema, con su información personal, credenciales de acceso y actividad.
 */
public class Usuario extends Persona{
    //Atributos
    private ArrayList<Pedido> pedidos;
    private String nombreUsuario;
    private String contrasenia;
    private int puntos;
    private double monto;
    private boolean isAdmin;

    /**
     * Constructor vacío de la clase Usuario.
     * Inicializa los atributos con valores por defecto.
     */
    public Usuario() {//Creo el constructor vacio
        this.nombreUsuario = "";
        this.contrasenia = "";
        this.puntos = 0;
        this.monto = 0;
        this.isAdmin = false;
        pedidos = null;
    }

    /**
     * Constructor completo de la clase Usuario.
     * @param nombre El nombre del usuario.
     * @param apellido El apellido del usuario.
     * @param calle El nombre de la calle de la dirección del usuario.
     * @param numero El número de la dirección del usuario.
     * @param email El correo electrónico del usuario.
     * @param nombreUsuario El nombre de usuario para iniciar sesión.
     * @param contrasenia La contraseña del usuario para iniciar sesión.
     * @param puntos Los puntos acumulados por el usuario.
     * @param monto El monto gastado por el usuario.
     * @param isAdmin Indica si el usuario tiene privilegios de administrador.
     */
    public Usuario(String nombre, String apellido, String calle, int numero, String email, String nombreUsuario, String contrasenia, int puntos, double monto, boolean isAdmin) {
        super(nombre, apellido, calle, numero, email);
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.puntos = puntos;
        this.monto = monto;
        this.isAdmin = isAdmin;
        pedidos = new ArrayList<>();
    }

    /**
     * Constructor de la clase Usuario que recibe una instancia de Persona.
     * @param persona La información personal del usuario.
     * @param nombreUsuario El nombre de usuario para iniciar sesión.
     * @param contrasenia La contraseña del usuario para iniciar sesión.
     * @param pedidos La lista de pedidos realizados por el usuario.
     */
    public Usuario(Persona persona, String nombreUsuario, String contrasenia, ArrayList<Pedido> pedidos,double monto) {
        super(persona.getNombre(), persona.getApellido(), persona.getCalle(), persona.getNumero(), persona.getEmail());
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.pedidos = pedidos;
        this.monto = monto;
    }

    //Getters & Setters

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

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

    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Convierte la información del usuario a un objeto JSON.
     * @return Un objeto JSONObject que representa la información del usuario.
     * @throws Exception Si ocurre algún error durante la conversión.
     */
    public JSONObject usuarioToJSON() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("persona", personaToJSON());
        jsonObject.put("usuario", nombreUsuario);
        jsonObject.put("contrasenia", contrasenia);
        jsonObject.put("monto",monto);

        JSONArray arrayPedidos = new JSONArray();
        for(int i=0; i<pedidos.size(); i++){
            arrayPedidos.put(pedidos.get(i).pedidoToJSON());
        }
        jsonObject.put("pedido", arrayPedidos);

        return jsonObject;
    }

    /**
     * Agrega un pedido a la lista de pedidos del usuario.
     * @param pedido El pedido a agregar.
     * @return true si se agrega correctamente, false de lo contrario.
     */
    public boolean agregarPedido(Pedido pedido){
        pedidos.add(pedido);
        return true;
    }

    /**
     * Elimina un pedido de la lista de pedidos del usuario.
     * @param pedido El pedido a eliminar.
     * @return true si se elimina correctamente, false de lo contrario.
     */
    public boolean eliminarPedido(Pedido<Picada> pedido, int id){
        boolean eliminado = false;
        if(pedido.getId() == id){
            pedidos.remove(pedido);
            eliminado = true;
        }
        return eliminado;
    }

    /**
     * Devuelve una representación en forma de cadena de la información del usuario.
     * @return Una cadena que contiene la información del usuario.
     */
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
