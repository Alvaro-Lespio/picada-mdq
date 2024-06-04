package picada;

import Producto.ProductoBebida;
import Producto.ProductoFiambre;
import Producto.ProductoQueso;
import Producto.ProductoSnack;

import java.util.ArrayList;
import java.util.List;

public class PicadaPreDefinida extends Picada{
    private List<Combo> combos;

    public PicadaPreDefinida() {
        combos = new ArrayList<>();
    }

    public PicadaPreDefinida(List<ProductoQueso> productoQuesoList, List<ProductoFiambre> productoFiambreList, List<ProductoSnack> productoSnacksList, List<ProductoBebida> productoBebidaList, double precioTotal, List<Combo> combos) {
        super(productoQuesoList, productoFiambreList, productoSnacksList, productoBebidaList, precioTotal);
        this.combos = combos;
    }

    public List<Combo> getCombos() {
        return combos;
    }



    //Llamar a la funcion que hice en Combo(verificarCombo) y pasarle lo que ingreso el usuario, en caso de que ingreso
    //bien el nombre de la picada. Verificar si hay suficiente stock para la picada(va a ser una funcion del JSON verificar stock)
    //una vez verificada, creamos la picada Predefinida y en base a eso descontamos el stock y se armaria el combo.


}
