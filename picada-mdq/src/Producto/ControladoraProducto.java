package Producto;

import Apis.JsonUtiles;
import Producto.Excepciones.DisponibilidadAgotadaException;
import Producto.tipo.TipoBebida;
import Producto.tipo.TipoFiambre;
import Producto.tipo.TipoQueso;
import Producto.tipo.TipoSnack;
import SesionDeUsuario.Usuario;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pedido.Pedido;
import picada.Picada;
import picada.PicadaPreDefinida;

import java.util.HashSet;

//lo que vamos a hacer aca es cargar e interactuar directo con el JSON
public class ControladoraProducto {
    private HashSet<Producto> productos;

    public ControladoraProducto() {
        productos = new HashSet<>();
    }

    public void cargarProductos() throws JSONException{
        ProductoBebida pb1 = new ProductoBebida(20, TipoBebida.AGUA);
        ProductoBebida pb2 = new ProductoBebida(20, TipoBebida.COCA_COLA);
        ProductoBebida pb3 = new ProductoBebida(20, TipoBebida.CERVEZA_QUILMES);
        ProductoBebida pb4 = new ProductoBebida(20, TipoBebida.FANTA);
        ProductoBebida pb5 = new ProductoBebida(20, TipoBebida.SPRITE);

        ProductoQueso q1 = new ProductoQueso(20, TipoQueso.MOZZARELLA);
        ProductoQueso q2 = new ProductoQueso(20, TipoQueso.CHEDDAR);
        ProductoQueso q3 = new ProductoQueso(20, TipoQueso.GOUDA);
        ProductoQueso q4 = new ProductoQueso(20, TipoQueso.ROQUEFORT);

        ProductoFiambre f1 = new ProductoFiambre(20, TipoFiambre.JAMON_COCIDO);
        ProductoFiambre f2 = new ProductoFiambre(20, TipoFiambre.JAMON_CRUDO);
        ProductoFiambre f3 = new ProductoFiambre(20, TipoFiambre.SALAME);
        ProductoFiambre f4 = new ProductoFiambre(20, TipoFiambre.MORTADELA);

        ProductoSnack s1 = new ProductoSnack(20, TipoSnack.PAPAS_FRITAS);
        ProductoSnack s2 = new ProductoSnack(20, TipoSnack.MANI);
        ProductoSnack s3 = new ProductoSnack(20, TipoSnack.PALITOS);
        ProductoSnack s4 = new ProductoSnack(20, TipoSnack.CHIZITO);

        productos.add(pb1);
        productos.add(pb2);
        productos.add(pb3);
        productos.add(pb4);
        productos.add(pb5);

        productos.add(q1);
        productos.add(q2);
        productos.add(q3);
        productos.add(q4);

        productos.add(f1);
        productos.add(f2);
        productos.add(f3);
        productos.add(f4);

        productos.add(s1);
        productos.add(s2);
        productos.add(s3);
        productos.add(s4);
        try{
            JSONObject pb1JSON = pb1.productoBebidaToJSON();
            JSONObject pb2JSON = pb2.productoBebidaToJSON();
            JSONObject pb3JSON = pb3.productoBebidaToJSON();
            JSONObject pb4JSON = pb4.productoBebidaToJSON();
            JSONObject pb5JSON = pb5.productoBebidaToJSON();

            JSONObject q1JSON = q1.productoQuesoToJSON();
            JSONObject q2JSON = q2.productoQuesoToJSON();
            JSONObject q3JSON = q3.productoQuesoToJSON();
            JSONObject q4JSON = q4.productoQuesoToJSON();

            JSONObject f1JSON = f1.productoFiambreToJSON();
            JSONObject f2JSON = f2.productoFiambreToJSON();
            JSONObject f3JSON = f3.productoFiambreToJSON();
            JSONObject f4JSON = f4.productoFiambreToJSON();

            JSONObject s1JSON = s1.productoSnackToJSON();
            JSONObject s2JSON = s2.productoSnackToJSON();
            JSONObject s3JSON = s3.productoSnackToJSON();
            JSONObject s4JSON = s4.productoSnackToJSON();

            JSONArray productosArray = new JSONArray();
            productosArray.put(pb1JSON);
            productosArray.put(pb2JSON);
            productosArray.put(pb3JSON);
            productosArray.put(pb4JSON);
            productosArray.put(pb5JSON);

            productosArray.put(q1JSON);
            productosArray.put(q2JSON);
            productosArray.put(q3JSON);
            productosArray.put(q4JSON);

            productosArray.put(f1JSON);
            productosArray.put(f2JSON);
            productosArray.put(f3JSON);
            productosArray.put(f4JSON);

            productosArray.put(s1JSON);
            productosArray.put(s2JSON);
            productosArray.put(s3JSON);
            productosArray.put(s4JSON);

            JsonUtiles.grabar(productosArray, "productos");
        }catch (JSONException e){
            throw new RuntimeException(e);
        }
    }
    //comprar picada predefinida
    public Pedido<Picada> comprarPicada(Usuario usuario, PicadaPreDefinida picadaAPedir) throws DisponibilidadAgotadaException {
        Pedido<Picada> pedido=null;

        if(picadaAPedir.getCombos())




    }

    public HashSet<Producto> getProductos() {
        return productos;
    }


    public String toStringProductos() {
        return "ControladoraPicada{" +
                "productos=" + productos +
                '}';
    }
}
