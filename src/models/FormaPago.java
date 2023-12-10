package models;

public class FormaPago {

    // Atributos
    private float importe;

    // Metodos

    // Getters
    // Acceder a valores del atributo de clase
    public float getImporte() {
        return importe;
    }

    // Setters
    // Informacion que puedo modificar del objeto al que hago referencia
    public void setImporte(float importe) {
        this.importe = importe;
    }


    // Constructor
    public FormaPago(float importe) {
        this.importe = importe;
    }
}
