package models;

import models.enums.TipoDocumento;

import java.util.Date;

public class NotaCredito extends Documento {


    // Metodos
    // Deben implementarse dado que Documentos es abstracto

    //Constructor
    // Metodo que tiene una clase que instancia al objeto

    public NotaCredito(){
        this.fecha = new Date();
        this.monto = 0;
    }
    public NotaCredito(Date fecha, int idDocumento, float monto, Proveedor proveedor, TipoDocumento tipoDocumento) {
        this.idDocumento = idDocumento;
        this.fecha = fecha;
        this.monto = monto;
        this.proveedor = proveedor;
        this.tipoDocumento = tipoDocumento;
    }

   }
