package picada;

import Ingredientes.TipoFiambre;

//Vamos a tener los combos predefinidos con sus atributos y sus cantidades
public enum Combo {
    COMBO1("combo1"),
    COMBO2("combo2"),
    COMBO3("combo3");

    private String nombreCombo;

    Combo(String nombreCombo) {
        this.nombreCombo = nombreCombo;
    }

    public String getNombreCombo() {
        return nombreCombo;
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
}
