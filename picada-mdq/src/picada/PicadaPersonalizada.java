package picada;

import Ingredientes.producto.Producto;
import Ingredientes.producto.ProductoFiambre;
import Ingredientes.producto.ProductoQueso;
import Ingredientes.producto.ProductoSnack;

import java.util.ArrayList;
import java.util.List;


public class PicadaPersonalizada extends Picada{
    private List<Producto> productos;

    public PicadaPersonalizada() {
        this.productos = new ArrayList<>();
    }

    public PicadaPersonalizada(List<Producto> productos,int id, List<ProductoQueso> productoQuesoList, List<ProductoFiambre> productoFiambreList, List<ProductoSnack> productoSnacksList, double precioTotal, boolean envio, int valoracion, List<Agregado> agregado) {
        super(id, productoQuesoList, productoFiambreList, productoSnacksList, precioTotal, envio, valoracion, agregado);
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    //Vamos a tener un metodo que va a ser crearPicadaPersonalizada, para esto vamos a ir preguntandole al usuario en orden,
    //Si desea comprar queso s/n, que tipo de queso y le mostramos un listado con los quesos que estan disponibles, asi con jamon,
    //snack y agregados, para saber que producto esta disponible vamos a tener una funcion que recorra el json y nos diga, que hay
    //en stock, si es mayor a 0 es porque hay stock y se lo mostramos, si no hay no se lo mostramos. cuando el usuario termine de
    //seleccionar vamos a modificar el stock con una funcion JSON, y una vez creado el pedido le pedimos la confirmacion al usuario
    //y le generamos la picada.

}
