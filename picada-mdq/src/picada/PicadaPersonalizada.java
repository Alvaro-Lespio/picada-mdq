package picada;

import Producto.Producto;
import Producto.ProductoFiambre;
import Producto.ProductoQueso;
import Producto.ProductoSnack;
import Producto.ProductoBebida;

import java.util.ArrayList;
import java.util.List;

/**
 * La clase PicadaPersonalizada representa una picada personalizada, que es un tipo específico de picada que puede
 * contener una combinación de productos de queso, fiambre, snack y bebida.
 */
public class PicadaPersonalizada extends Picada{

    /**
     * Constructor por defecto de PicadaPersonalizada.
     * Crea una instancia de PicadaPersonalizada sin inicializar ninguna lista de productos.
     */
    public PicadaPersonalizada() {
    }

    /**
     * Constructor de PicadaPersonalizada que inicializa las listas de productos de queso, fiambre, snack y bebida
     * con las listas proporcionadas.
     *
     * @param productoQuesoList   Lista de productos de queso que se incluirán en la picada personalizada.
     * @param productoFiambreList Lista de productos de fiambre que se incluirán en la picada personalizada.
     * @param productoSnacksList  Lista de productos de snack que se incluirán en la picada personalizada.
     * @param productoBebidaList  Lista de productos de bebida que se incluirán en la picada personalizada.
     */

    public PicadaPersonalizada(ArrayList<ProductoQueso> productoQuesoList, ArrayList<ProductoFiambre> productoFiambreList, ArrayList<ProductoSnack> productoSnacksList, ArrayList<ProductoBebida> productoBebidaList) {
        super(productoQuesoList, productoFiambreList, productoSnacksList, productoBebidaList);
    }



}
