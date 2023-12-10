package models;

import models.enums.TipoImpuesto;

public class Impuestos {

    // Atributos
    private TipoImpuesto tipoImpuesto;

    // Metodos

    // Getters
    public TipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }


    // Setters
    public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    // Constructor
    public Impuestos(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }
}
