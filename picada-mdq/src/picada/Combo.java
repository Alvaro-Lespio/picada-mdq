package picada;

import Producto.tipo.TipoBebida;
import Producto.tipo.TipoFiambre;
import Producto.tipo.TipoQueso;
import Producto.tipo.TipoSnack;

//Vamos a tener los combos predefinidos con sus atributos y sus cantidades
public enum Combo {
    COMBO1("combo1", "Combo normal", 1, TipoQueso.CHEDDAR, TipoFiambre.JAMON_COCIDO, TipoSnack.CHIZITO, TipoBebida.COCA_COLA),
    COMBO1("combo1v", "Combo para veganos", 1, TipoQueso.MOZZARELLA, TipoSnack.CHIZITO, TipoBebida.COCA_COLA),
    COMBO2("combo2", "Combo normal", 2, TipoQueso.GOUDA, TipoFiambre.MORTADELA, TipoSnack.PAPAS_FRITAS, TipoBebida.FANTA) ,
    COMBO2("combo2", "Combo para veganos", 2, TipoQueso.GOUDA, TipoFiambre.MORTADELA, TipoSnack.PAPAS_FRITAS, TipoBebida.FANTA) ,
    COMBO3("combo3", "Combo normal", 4, ),
    COMBO3("combo3v", "Combo para veganos", 4, ),
    COMBO4("combo4", "Combo normal", 6, ),
    COMBO4("combo4v", "Combo para veganos", 6, ),
    COMBO5("combo5", "Combo normal", 8, ),
    COMBO5("combo5v", "Combo para veganos", 8, ),
    COMBO6("combo6", "Combo normal", 10, ),
    COMBO6("combo6v", "Combo para veganos", 10, );

    private String nombreCombo;
    private String descripcion;
    private int cantPersonas;
    private TipoQueso tipoQueso;
    private TipoFiambre tipoFiambre;
    private TipoSnack tipoSnack;
    private TipoBebida tipoBebida;

    //para personas no vegetarianas
    Combo(String nombreCombo, String descripcion, int cantPersonas, TipoQueso tipoQueso, TipoFiambre tipoFiambre, TipoSnack tipoSnack, TipoBebida tipoBebida) {
        this.nombreCombo = nombreCombo;
        this.descripcion = descripcion;
        this.cantPersonas = cantPersonas;
        this.tipoQueso = tipoQueso;
        this.tipoFiambre = tipoFiambre;
        this.tipoSnack = tipoSnack;
        this.tipoBebida = tipoBebida;
    }

    //para veganos
    Combo(String nombreCombo, String descripcion, int cantPersonas, TipoQueso tipoQueso, TipoSnack tipoSnack, TipoBebida tipoBebida) {
        this.nombreCombo = nombreCombo;
        this.descripcion = descripcion;
        this.cantPersonas = cantPersonas;
        this.tipoQueso = tipoQueso;
        this.tipoSnack = tipoSnack;
        this.tipoBebida = tipoBebida;
    }

    public String getNombreCombo() {
        return nombreCombo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public TipoQueso getTipoQueso() {
        return tipoQueso;
    }

    public TipoFiambre getTipoFiambre() {
        return tipoFiambre;
    }

    public TipoSnack getTipoSnack() {
        return tipoSnack;
    }

    public TipoBebida getTipoBebida() {
        return tipoBebida;
    }

    public static Combo verificarCombo(String nombreCombo) {
        if(nombreCombo.equalsIgnoreCase(COMBO1.getNombreCombo())) {
            return COMBO1;
        }else if(nombreCombo.equalsIgnoreCase(COMBO2.getNombreCombo())) {
            return COMBO2;
        }else{
            return COMBO3;
        }
    }

    @Override
    public String toString() {
        return "Combo{" +
                "nombreCombo='" + nombreCombo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantPersonas=" + cantPersonas +
                ", tipoQueso=" + tipoQueso +
                ", tipoFiambre=" + tipoFiambre +
                ", tipoSnack=" + tipoSnack +
                ", tipoBebida=" + tipoBebida +
                '}';
    }
}
