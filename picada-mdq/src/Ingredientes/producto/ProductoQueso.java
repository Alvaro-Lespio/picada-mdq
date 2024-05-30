package Ingredientes.producto;

import Ingredientes.TipoQueso;

public class ProductoQueso extends Producto{
    private TipoQueso tipoQueso;

    public ProductoQueso(double stock, TipoQueso tipoQueso) {
        super(stock);
        this.tipoQueso = tipoQueso;
    }
}
