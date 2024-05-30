package Ingredientes.producto;

import Ingredientes.TipoFiambre;

public class ProdcutoFiambre extends Producto{
    private TipoFiambre tipoFiambre;

    public ProdcutoFiambre(double stock, TipoFiambre tipoFiambre) {
        super(stock);
        this.tipoFiambre = tipoFiambre;
    }
}
