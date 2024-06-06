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



}
