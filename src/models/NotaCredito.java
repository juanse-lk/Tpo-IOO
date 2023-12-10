package models;

import models.enums.TipoDocumento;

import java.util.Date;

public class NotaCredito extends Documento {


    // Metodos
    // Deben implementarse dado que Documentos es abstracto

    //Constructor
    // Metodo que tiene una clase que instancia al objeto
    public NotaCredito(Date fecha, int idDocumento, float monto, Proveedor proveedor, TipoDocumento tipoDocumento) {
        super(fecha, idDocumento, monto, proveedor, tipoDocumento);
    }

   }
