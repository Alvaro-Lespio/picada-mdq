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

/**
 * Clase PicadaPreDefinida que representa una picada predefinida con un conjunto de productos y características.
 */
public class PicadaPreDefinida extends Picada{

    private String nombreCombo;
    private String descripcion;
    private int cantPersonas;
    private List<TipoQueso> tipoQueso; //Hacemos un List para poder agregar mas de un queso en este caso
    private List<TipoFiambre>tipoFiambre;
    private List<TipoSnack> tipoSnack;
    private List<TipoBebida> tipoBebida;
    private int stockCombo;

    /**
     * Constructor completo de la clase PicadaPreDefinida.
     *
     * @param nombreCombo  Nombre del combo.
     * @param descripcion  Descripción del combo.
     * @param cantPersonas Cantidad de personas para las que es adecuado el combo.
     * @param tipoQueso    Lista de tipos de queso en el combo.
     * @param tipoFiambre  Lista de tipos de fiambre en el combo.
     * @param tipoSnack    Lista de tipos de snack en el combo.
     * @param tipoBebida   Lista de tipos de bebida en el combo.
     * @param stockCombo   Stock disponible del combo.
     */
    public PicadaPreDefinida(List<ProductoQueso> productoQuesoList, List<ProductoFiambre> productoFiambreList, List<ProductoSnack> productoSnacksList, List<ProductoBebida> productoBebidaList, String nombreCombo, String descripcion, int cantPersonas, List<TipoQueso> tipoQueso, List<TipoFiambre> tipoFiambre, List<TipoSnack> tipoSnack, List<TipoBebida> tipoBebida, int stockCombo) {
        super(productoQuesoList, productoFiambreList, productoSnacksList, productoBebidaList);
        this.nombreCombo = nombreCombo;
        this.descripcion = descripcion;
        this.cantPersonas = cantPersonas;
        this.tipoQueso = tipoQueso;
        this.tipoFiambre = tipoFiambre;
        this.tipoSnack = tipoSnack;
        this.tipoBebida = tipoBebida;
        this.stockCombo = stockCombo;
    }

    /**
     * Constructor que omite el tipo de fiambre.
     *
     * @param nombreCombo  Nombre del combo.
     * @param descripcion  Descripción del combo.
     * @param cantPersonas Cantidad de personas para las que es adecuado el combo.
     * @param tipoQueso    Lista de tipos de queso en el combo.
     * @param tipoSnack    Lista de tipos de snack en el combo.
     * @param tipoBebida   Lista de tipos de bebida en el combo.
     * @param stockCombo   Stock disponible del combo.
     */

    public PicadaPreDefinida(List<ProductoQueso> productoQuesoList, List<ProductoSnack> productoSnacksList, List<ProductoBebida> productoBebidaList, String nombreCombo, String descripcion, int cantPersonas, List<TipoQueso> tipoQueso, List<TipoFiambre> tipoFiambre, List<TipoSnack> tipoSnack, List<TipoBebida> tipoBebida, int stockCombo) {
        super(productoQuesoList,productoBebidaList, productoSnacksList );
        this.nombreCombo = nombreCombo;
        this.descripcion = descripcion;
        this.cantPersonas = cantPersonas;
        this.tipoQueso = tipoQueso;
        this.tipoSnack = tipoSnack;
        this.tipoBebida = tipoBebida;
        this.stockCombo = stockCombo;
    }

    /**
     * Constructor por defecto de la clase PicadaPreDefinida.
     */
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

    // Métodos Getter y Setter

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

    @Override
    public String toString() {
        return "PicadaPreDefinida{" +
                "nombreCombo='" + nombreCombo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantPersonas=" + cantPersonas +
                ", tipoQueso=" + tipoQueso +
                ", tipoFiambre=" + tipoFiambre +
                ", tipoSnack=" + tipoSnack +
                ", tipoBebida=" + tipoBebida +
                ", stockCombo=" + stockCombo +
                '}';
    }

    /**
     * Compara esta instancia con otro objeto para verificar la igualdad.
     *
     * @param object el objeto con el que se va a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    /**
     * Calcula el código hash para la instancia.
     *
     * @return el código hash.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
