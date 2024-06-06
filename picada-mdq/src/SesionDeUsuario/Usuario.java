package SesionDeUsuario;

import org.json.JSONArray;
import org.json.JSONObject;
import pedido.Pedido;

import java.util.ArrayList;

public class Usuario extends Persona{
    //Atributos
    private ArrayList<Pedido> pedidos;
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
        pedidos = null;
    }

    //Constructor completo


    public Usuario(String nombre, String apellido, String calle, int numero, String email, String nombreUsuario, String contrasenia, int puntos, double monto, boolean isAdmin) {
        super(nombre, apellido, calle, numero, email);
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.puntos = puntos;
        this.monto = monto;
        this.isAdmin = isAdmin;
        pedidos = new ArrayList<>();
    }

    public Usuario(Persona persona, String nombreUsuario, String contrasenia, ArrayList<Pedido> pedidos) {
        super(persona.getNombre(), persona.getApellido(), persona.getCalle(), persona.getNumero(), persona.getEmail());
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.pedidos = pedidos;
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

    //METODOS
    public JSONObject usuarioToJSON() throws Exception{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("persona", personaToJSON());
        jsonObject.put("usuario", nombreUsuario);
        jsonObject.put("contrasenia", contrasenia);

        JSONArray arrayPedidos = new JSONArray();
        for(int i=0; i<pedidos.size(); i++){
            arrayPedidos.put(pedidos.get(i).pedidoToJSON());
        }
        jsonObject.put("pedidos", arrayPedidos);

        return jsonObject;
    }



    public boolean agregarPedido(Pedido pedido){
        pedidos.add(pedido);
        return true;
    }

    public boolean eliminarPedido(Pedido pedido){
        boolean eliminado = false;
        eliminado = pedidos.remove(pedido);
        //Si llegamos a hacer pedidos cancelados lo agregariamos ahí
        return true;
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
