package Ingredientes.producto;

import Ingredientes.TipoFiambre;

public class ProductoFiambre extends Producto{
    private TipoFiambre tipoFiambre;

    public ProductoFiambre(int stock, TipoFiambre tipoFiambre) {
        super(stock);
        this.tipoFiambre = tipoFiambre;
    }

    @Override
    public void actualizarStock() {

    }
}
