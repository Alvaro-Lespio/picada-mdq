package Ingredientes.producto;

import Ingredientes.TipoBebida;
import Ingredientes.TipoFiambre;
import Ingredientes.TipoQueso;
import Ingredientes.TipoSnack;
import org.json.JSONArray;
import org.json.JSONException;
import picada.Picada;

import java.util.HashSet;

//lo que vamos a hacer aca es cargar e interactuar directo con el JSON
public class ControladoraPicada {

    private HashSet<Picada> picadas;

    public ControladoraPicada() {
        picadas = new HashSet<>();

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

        try{
            pb1.productoBebidaToJSON();
            q1.productoQuesoToJSON();
            f1.productoFiambreToJSON();
            s1.productoSnackToJSON();
        }catch (JSONException e){
            throw new RuntimeException(e);
        }
    }
}
