package models;

import models.enums.TipoDocumento;

import java.util.Date;

public abstract class Documento {

    // Atributos
    private Date fecha;
    private int idDocumento;
    private float monto;
    private Proveedor proveedor;
    private TipoDocumento tipoDocumento;

    // Metodos

    // Getters
    // Acceder a valores del atributo de clase

    public Date getFecha() {
        return fecha;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public float getMonto() {
        return monto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }


    // Setters
    // Informacion que puedo modificar del objeto al que hago referencia

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }


    //Constructor

    public Documento(Date fecha, int idDocumento, float monto, Proveedor proveedor, TipoDocumento tipoDocumento) {
        this.fecha = fecha;
        this.idDocumento = idDocumento;
        this.monto = monto;
        this.proveedor = proveedor;
        this.tipoDocumento = tipoDocumento;
    }
}
