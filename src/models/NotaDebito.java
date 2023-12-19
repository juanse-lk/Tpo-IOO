package models;

import models.enums.TipoDocumento;

import java.util.ArrayList;
import java.util.Date;

public class NotaDebito extends Documento{

    private OrdenDePago ordenDePagoAsociada;

    public OrdenDePago getOrdenDePagoAsociada() {
        return ordenDePagoAsociada;
    }

    public void setOrdenDePagoAsociada(OrdenDePago ordenDePagoAsociada) {
        this.ordenDePagoAsociada = ordenDePagoAsociada;
    }
    // Constructor
    // Metodo que tiene una clase que instancia al objeto
    public NotaDebito(){
        this.fecha = new Date();
        this.monto = 0;
    }
    public NotaDebito(Date fecha, int idDocumento, float monto, Proveedor proveedor, TipoDocumento tipoDocumento) {
        this.idDocumento = idDocumento;
        this.fecha = fecha;
        this.monto = monto;
        this.proveedor = proveedor;
        this.tipoDocumento = tipoDocumento;
    }

    // Metodos propios de Nota Debito
    public Boolean tieneOrdenDePagoAsociada(){
        // TODO: 02/12/2023 agregar funcion. Validar funcion duplicada con Factura.
        return false;
    }
    }
