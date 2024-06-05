package picada;

import Producto.Producto;
import Producto.ProductoFiambre;
import Producto.ProductoQueso;
import Producto.ProductoSnack;
import Producto.ProductoBebida;

import java.util.ArrayList;
import java.util.List;


public class PicadaPersonalizada extends Picada{

    public PicadaPersonalizada() {
    }

    public PicadaPersonalizada(List<ProductoQueso> productoQuesoList, List<ProductoFiambre> productoFiambreList, List<ProductoSnack> productoSnacksList, List<ProductoBebida> productoBebidaList) {
        super(productoQuesoList, productoFiambreList, productoSnacksList, productoBebidaList);
    }


    //Vamos a tener un metodo que va a ser crearPicadaPersonalizada, para esto vamos a ir preguntandole al usuario en orden,
    //Si desea comprar queso s/n, que tipo de queso y le mostramos un listado con los quesos que estan disponibles, asi con jamon,
    //snack y agregados, para saber que producto esta disponible vamos a tener una funcion que recorra el json y nos diga, que hay
    //en stock, si es mayor a 0 es porque hay stock y se lo mostramos, si no hay no se lo mostramos. cuando el usuario termine de
    //seleccionar vamos a modificar el stock con una funcion JSON, y una vez creado el pedido le pedimos la confirmacion al usuario
    //y le generamos la picada.

}
