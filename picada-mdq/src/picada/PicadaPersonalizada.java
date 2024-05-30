package picada;

import Ingredientes.Agregado;

import java.util.ArrayList;
import java.util.List;


public class PicadaPersonalizada extends Picada{
    List<Ingrediente> ingredientes;

    public PicadaPersonalizada() {
        this.ingredientes = new ArrayList<>();
    }

    public PicadaPersonalizada(Ingrediente ingrediente, double precioTotal, boolean envio, int valoracion, Agregado agregado, ArrayList<Ingrediente> ingredientes) {
        super(ingrediente, precioTotal, envio, valoracion, agregado);
        this.ingredientes = ingredientes;
    }


}
