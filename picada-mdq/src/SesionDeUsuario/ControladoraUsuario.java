package SesionDeUsuario;

import Apis.JsonUtiles;
import Producto.ProductoBebida;
import Producto.ProductoFiambre;
import Producto.ProductoQueso;
import Producto.ProductoSnack;
import Producto.tipo.TipoBebida;
import Producto.tipo.TipoFiambre;
import Producto.tipo.TipoQueso;
import Producto.tipo.TipoSnack;
import SesionDeUsuario.Excepciones.ContraseniaIncorrectaException;
import SesionDeUsuario.Excepciones.UsuarioNoEncontradoException;
import SesionDeUsuario.Excepciones.UsuarioRepetidoException;
import org.json.JSONArray;
import org.json.JSONObject;
import pedido.Pedido;
import picada.Picada;
import picada.PicadaPersonalizada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ControladoraUsuario {
    private HashMap<String, Usuario> mapaUsuarios;

    public ControladoraUsuario() {
        mapaUsuarios = new HashMap<>();
    }

    public ControladoraUsuario(HashMap<String, Usuario> mapaUsuarios) {
        this.mapaUsuarios = mapaUsuarios;
    }

    public HashMap<String, Usuario> getMapaUsuarios() {
        return mapaUsuarios;
    }

    public ArrayList<Usuario> leerArchivoUsuarios() throws Exception{
        ArrayList<Usuario> usuarios = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(JsonUtiles.leer("usuarios"));
        System.out.println(jsonArray);
        for(int i=0; i<jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String nombreUsuario = jsonObject.getString("usuario");
            String contrasenia = jsonObject.getString("contrasenia");
            double monto = jsonObject.getDouble("monto");
            JSONObject persona = jsonObject.getJSONObject("persona");
            Persona persona1 = Persona.JSONToPersona(persona);
            JSONArray arrayPedidos = jsonObject.getJSONArray("pedido");
            ArrayList<Pedido>pedidosList = new ArrayList<>();
            for(int j=0; j<arrayPedidos.length(); j++){
                Pedido<PicadaPersonalizada> pedido1 = new Pedido<>();
                ArrayList<PicadaPersonalizada> picadaPersonalizadasList = new ArrayList<>();
                JSONObject pedido = arrayPedidos.getJSONObject(j);
                Boolean envio = pedido.getBoolean("envio");
                Double precioFin = pedido.getDouble("precioFinalPedido");
                pedido1.setEnvio(envio);
                pedido1.setPrecioFinalPedido(precioFin);
                JSONArray picadas = pedido.getJSONArray("picadas");
                for(int k=0;k<picadas.length();k++){
                    Picada picada1 = new PicadaPersonalizada();
                    JSONObject picada = picadas.getJSONObject(k);
                    Double precioTotal = picada.getDouble("precioTotal");
                    Integer id = picada.getInt("id");
                    PicadaPersonalizada picadaPersonalizada = new PicadaPersonalizada();
                    JSONArray queso = picada.getJSONArray("productoQuesoList");
                    JSONArray fiambre = picada.getJSONArray("productoFiambreList");
                    JSONArray snack = picada.getJSONArray("productoSnackList");
                    JSONArray bebida = picada.getJSONArray("productoBebidaList");
                    picada1.setPrecioTotal(precioTotal);
                    picada1.setId(id);
                    ArrayList<ProductoQueso> quesoList = new ArrayList<>();
                    ArrayList<ProductoFiambre> fiambreList = new ArrayList<>();
                    ArrayList<ProductoSnack> snackList = new ArrayList<>();
                    ArrayList<ProductoBebida> bebidaList = new ArrayList<>();
                    for(int t=0;t<queso.length();t++){
                        JSONObject quesito = queso.getJSONObject(t);
                        TipoQueso queso1 = TipoQueso.valueOf(quesito.getString("TipoQueso"));
                        int stock = quesito.getInt("stock");

                        ProductoQueso objetoQueso = new ProductoQueso(stock,queso1);
                        quesoList.add(objetoQueso);
                    }
                    picadaPersonalizada.setProductoQuesoList(quesoList);
                    for(int h=0;h<fiambre.length();h++){
                        JSONObject fiambrin = fiambre.getJSONObject(h);
                        TipoFiambre fiambre1 = TipoFiambre.valueOf(fiambrin.getString("TipoFiambre"));
                        int stock = fiambrin.getInt("stock");

                        ProductoFiambre objetoFiambre = new ProductoFiambre(stock,fiambre1);
                        fiambreList.add(objetoFiambre);
                    }
                    picadaPersonalizada.setProdcutoFiambreList(fiambreList);
                    for(int p=0;p<snack.length();p++){
                        JSONObject snacksito = snack.getJSONObject(p);
                        TipoSnack snack1 = TipoSnack.valueOf((snacksito.getString("TipoSnack")));
                        int stock = snacksito.getInt("stock");

                        ProductoSnack objetoSnack = new ProductoSnack(stock,snack1);
                        snackList.add(objetoSnack);
                    }
                    picadaPersonalizada.setProductoSnackList(snackList);
                    for(int l=0;l<bebida.length();l++){
                        JSONObject bebidita = bebida.getJSONObject(l);
                        TipoBebida bebida1 = TipoBebida.valueOf(bebidita.getString("TipoBebida"));
                        int stock = bebidita.getInt("stock");

                        ProductoBebida objetoBebida = new ProductoBebida(stock,bebida1);
                        bebidaList.add(objetoBebida);

                    }
                    picadaPersonalizada.setProductoBebidaList(bebidaList);
                    picadaPersonalizadasList.add(picadaPersonalizada);
                    //ponerle todas las propiedades
                }
                pedido1.setPicadas(picadaPersonalizadasList);
                pedidosList.add(pedido1);
            }

            //ArrayList<Pedido> arrayPedidosTotal = Pedido.JSONToPedido(arrayPedidos);

            Usuario usuario1 = new Usuario(persona1, nombreUsuario, contrasenia, pedidosList,monto);
            usuarios.add(usuario1);
            mapaUsuarios.put(persona1.getEmail(), usuario1);
        }
        return usuarios;
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

    public void registrarse(Usuario usuario) throws UsuarioRepetidoException {
        Usuario aux = null;
        aux = verificarUsuario(usuario.getEmail());
        if(aux == null){
            mapaUsuarios.put(usuario.getEmail(), usuario);
        }
        else{
            throw new UsuarioRepetidoException("usuario repetido");
        }
    }

    /*public JSONArray mapaToJson() throws Exception{
        Iterator iterator = mapaUsuarios.entrySet().iterator();
        JSONArray jsonArray = new JSONArray();
        for(Map.Entry<String, Usuario> mapa : mapaUsuarios.entrySet()){
            JSONObject jsonObject =mapa.getValue().usuarioToJSON();
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

     */
    public JSONArray mapaToJson() throws Exception {
        JSONArray jsonArray = new JSONArray();
        for (Map.Entry<String, Usuario> entry : mapaUsuarios.entrySet()) {
            jsonArray.put(entry.getValue().usuarioToJSON());
        }
        return jsonArray;
    }

}
