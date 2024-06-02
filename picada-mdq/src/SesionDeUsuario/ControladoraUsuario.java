package SesionDeUsuario;

import Apis.JsonUtiles;
import SesionDeUsuario.Excepciones.ContraseniaIncorrectaException;
import SesionDeUsuario.Excepciones.UsuarioNoEncontradoException;
import SesionDeUsuario.Excepciones.UsuarioRepetidoException;
import org.json.JSONArray;
import org.json.JSONObject;
import pedido.Pedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ControladoraUsuario {
    private HashMap<String, Usuario> mapaUsuarios;

    public ControladoraUsuario(HashMap<String, Usuario> mapaUsuarios) {
        this.mapaUsuarios = mapaUsuarios;
    }

    public HashMap<String, Usuario> getMapaUsuarios() {
        return mapaUsuarios;
    }

    public void leerArchivoUsuarios() throws Exception{
        JSONArray jsonArray = new JSONArray(JsonUtiles.leer("usuarios"));
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String nombreUsuario = jsonObject.getString("usuario");
            String contrasenia = jsonObject.getString("contrasenia");
            JSONObject persona = jsonObject.getJSONObject("persona");
            Persona persona1 = Persona.JSONToPersona(persona);

            JSONArray arrayPedidos = jsonObject.getJSONArray("pedidos");
            ArrayList<Pedido> arrayPedidosTotal = Pedido.JSONToPedido(arrayPedidos);

            Usuario usuario1 = new Usuario(persona1, nombreUsuario, contrasenia, arrayPedidosTotal);
            mapaUsuarios.put(persona1.getEmail(), usuario1);
        }
    }

    public Usuario verificarUsuario(String mail){
        Usuario usuarioEncontrado = null;
        Iterator<Usuario> iterator = mapaUsuarios.values().iterator();
        while (iterator.hasNext() && usuarioEncontrado == null){
            Usuario aux = iterator.next();
            if(aux.getEmail().equals(mail)){
                usuarioEncontrado = aux;
            }
        }
        return usuarioEncontrado;
    }

    public boolean verificarContrasenia(Usuario usuario, String contrasenia){
        boolean contraseniaEncontrada = false;
        if(usuario.getContrasenia().equals(contrasenia)){
            contraseniaEncontrada = true;
        }
        return contraseniaEncontrada;
    }

    public Usuario iniciarSesion(String mail, String contrasenia) throws UsuarioNoEncontradoException, ContraseniaIncorrectaException {
        Usuario usuarioABuscar = null;
        Usuario usuarioEncontrado = null;
        if(verificarUsuario(mail) != null){
            usuarioABuscar = verificarUsuario(mail);
            if(!verificarContrasenia(usuarioABuscar, contrasenia)){
                throw new ContraseniaIncorrectaException("contrasenia incorrecta");
            }
            else{
                usuarioEncontrado = usuarioABuscar;
            }
        }
        else{
            throw new UsuarioNoEncontradoException("usuario incorrecto");
        }
        return usuarioEncontrado;
    }

    public Usuario registrarse(Usuario usuario) throws UsuarioRepetidoException {
        Usuario aux = null;
        aux = verificarUsuario(usuario.getEmail());
        if(aux == null){
            mapaUsuarios.put(usuario.getEmail(), usuario);
        }
        else{
            throw new UsuarioRepetidoException("usuario repetido");
        }
    }

    public JSONArray mapaToJson() throws Exception{
        Iterator iterator = mapaUsuarios.entrySet().iterator();
        JSONArray jsonArray = new JSONArray();
        for(Map.Entry<String, Usuario> mapa : mapaUsuarios.entrySet()){
            JSONObject jsonObject =mapa.getValue().usuarioToJSON();
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }
}
