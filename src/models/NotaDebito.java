package models;

import models.enums.TipoDocumento;

import java.util.Date;

public class NotaDebito extends Documento{

    // Metodos
    // Deben implementarse dado que Documentos es abstracto

    // Getters
    // Acceder a valores del atributo de clase


    // Constructor
    // Metodo que tiene una clase que instancia al objeto

    public NotaDebito(Date fecha, int idDocumento, float monto, Proveedor proveedor, TipoDocumento tipoDocumento) {
        super(fecha, idDocumento, monto, proveedor, tipoDocumento);
    }

    // Metodos propios de Nota Debito
    public Boolean tieneOrdenDePagoAsociada(){
        // TODO: 02/12/2023 agregar funcion. Validar funcion duplicada con Factura.
        return false;
    }
    }
