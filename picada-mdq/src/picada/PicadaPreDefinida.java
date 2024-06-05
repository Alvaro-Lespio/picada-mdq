package picada;

import Producto.ProductoBebida;
import Producto.ProductoFiambre;
import Producto.ProductoQueso;
import Producto.ProductoSnack;
import Producto.tipo.TipoBebida;
import Producto.tipo.TipoFiambre;
import Producto.tipo.TipoQueso;
import Producto.tipo.TipoSnack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PicadaPreDefinida extends Picada{
    /*
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
    */
    private String nombreCombo;
    private String descripcion;
    private int cantPersonas;
    private List<TipoQueso> tipoQueso; //Hacemos un List para poder agregar mas de un queso en este caso
    private List<TipoFiambre>tipoFiambre;
    private List<TipoSnack> tipoSnack;
    private List<TipoBebida> tipoBebida;
    private int stockCombo;

    public PicadaPreDefinida(String nombreCombo, String descripcion, int cantPersonas, List<TipoQueso> tipoQueso, List<TipoFiambre> tipoFiambre, List<TipoSnack> tipoSnack, List<TipoBebida> tipoBebida, int stockCombo) {
        this.nombreCombo = nombreCombo;
        this.descripcion = descripcion;
        this.cantPersonas = cantPersonas;
        this.tipoQueso = tipoQueso;
        this.tipoFiambre = tipoFiambre;
        this.tipoSnack = tipoSnack;
        this.tipoBebida = tipoBebida;
        this.stockCombo = stockCombo;
    }

    public PicadaPreDefinida() {
        this.nombreCombo = "";
        this.descripcion = "";
        this.cantPersonas = 0;
        this.tipoQueso = null;
        this.tipoFiambre = null;
        this.tipoSnack = null;
        this.tipoBebida = null;
        this.stockCombo = 0;
    }

    public String getNombreCombo() {
        return nombreCombo;
    }

    public void setStockCombo(int stockCombo) {
        this.stockCombo = stockCombo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public List<TipoQueso> getTipoQueso() {
        return tipoQueso;
    }

    public List<TipoFiambre> getTipoFiambre() {
        return tipoFiambre;
    }

    public List<TipoSnack> getTipoSnack() {
        return tipoSnack;
    }

    public List<TipoBebida> getTipoBebida() {
        return tipoBebida;
    }

    public int getStockCombo() {
        return stockCombo;
    }

    //Llamar a la funcion que hice en Combo(verificarCombo) y pasarle lo que ingreso el usuario, en caso de que ingreso
    //bien el nombre de la picada. Verificar si hay suficiente stock para la picada(va a ser una funcion del JSON verificar stock)
    //una vez verificada, creamos la picada Predefinida y en base a eso descontamos el stock y se armaria el combo.


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PicadaPreDefinida that = (PicadaPreDefinida) object;
        return Objects.equals(nombreCombo, that.nombreCombo);
    }

    @Override
    public int hashCode() {
        return 2;
    }
}
