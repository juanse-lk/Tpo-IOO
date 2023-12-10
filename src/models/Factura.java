package models;
import models.enums.TipoDocumento;
import java.util.Date;

public class Factura extends Documento {

    // Atributos
    private String detalleFactura;

    // Metodos
    // Deben implementarse dado que Documentos es abstracto

    // Getters
    // Acceder a valores del atributo de clase

    public String getDetalleFactura() {
        return detalleFactura;
    }


    // Metodos propios de Factura

    public float calcularImpuesto(){
        // TODO: 02/12/2023 agregar funcion
        return 0;
    }

    public Boolean tieneOrdenDePagoAsociada(){
        // TODO: 02/12/2023 agregar funcion
        return false;
    }
    // Constructor
    // Metodo que tiene una clase que instancia al objeto

    public Factura(Date fecha, int idDocumento, float monto, Proveedor proveedor, TipoDocumento tipoDocumento) {
        super(fecha, idDocumento, monto, proveedor, tipoDocumento);
    }

}


