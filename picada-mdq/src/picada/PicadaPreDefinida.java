package picada;

import Ingredientes.producto.Producto;

import java.util.ArrayList;
import java.util.List;

public class PicadaPreDefinida {
    private List<Combo> combos;
    private List<Producto> productos;
    
    public PicadaPreDefinida() {
        combos = new ArrayList<>();
        productos = new ArrayList<>();
    }

    public PicadaPreDefinida(List<Combo> combos, List<Producto> productos) {
        this.combos = combos;
        this.productos = productos;
    }

    public List<Combo> getCombos() {
        return combos;
    }

    public List<Producto> getProductos() {
        return productos;
    }



    //Llamar a la funcion que hice en Combo(verificarCombo) y pasarle lo que ingreso el usuario, en caso de que ingreso
    //bien el nombre de la picada. Verificar si hay suficiente stock para la picada(va a ser una funcion del JSON verificar stock)
    //una vez verificada, creamos la picada Predefinida y en base a eso descontamos el stock y se armaria el combo.


}
