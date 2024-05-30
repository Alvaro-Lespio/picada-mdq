package Ingredientes.producto;

import Ingredientes.TipoSnack;

public class ProductoSnack extends Producto{
    private TipoSnack tipoSnack;

    public ProductoSnack(int stock, TipoSnack tipoSnack) {
        super(stock);
        this.tipoSnack = tipoSnack;
    }

    @Override
    public void actualizarStock() {

    }
}
