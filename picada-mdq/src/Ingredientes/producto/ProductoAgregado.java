package Ingredientes.producto;

import Ingredientes.Agregado;

import java.util.List;
public class ProductoAgregado extends Producto{
    List<Agregado> agregados;

    public ProductoAgregado(int stock, List<Agregado> agregados) {
        super(stock);
        this.agregados = agregados;
    }

    @Override
    public void actualizarStock() {

    }
}
