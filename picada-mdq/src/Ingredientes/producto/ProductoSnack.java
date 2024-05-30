package Ingredientes.producto;

import Ingredientes.TipoSnack;

public class ProductoSnack extends Producto{
    private TipoSnack tipoSnack;

    public ProductoSnack(double stock, TipoSnack tipoSnack) {
        super(stock);
        this.tipoSnack = tipoSnack;
    }
}
