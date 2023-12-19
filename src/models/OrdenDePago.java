package models;

import models.enums.ResponsabilidadIva;
import models.enums.FormaDePago;
import java.util.Date;

public class OrdenDePago {

    // Atributos

    private FormaDePago formaPago;
    private int idDocumento;
    private int idOrdenPago;



    // Metodos

    // Getters
    public FormaDePago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaDePago formaPago) {
        this.formaPago = formaPago;
    }

    public int getIdDocumento() {
        return idDocumento;
    }


    // Setters
    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public int getIdOrdenPago() {
        return idOrdenPago;
    }

    public void setIdOrdenPago(int idOrdenPago) {
        this.idOrdenPago = idOrdenPago;
    }

    // Metodos de OrdenDePago

    public float getTotalRetenciones(){
        //todo: Agregar el desarrollo de la funcion getTotalRetenciones
        return 0;
    }

    public float calcularTotal(){
        //todo: Agregar el desarrollo de la funcion calcularTotal
        return 0;
    }

    public Proveedor getProveedor() throws Exception {
        //todo: Agregar el desarrollo de la funcion getProveedor
        Proveedor p = new Proveedor(123, ResponsabilidadIva.MONOTRIBUTO, "a", "a", "a", "a", "a", "123", new Date(), 123);
        return p;
    }

    // A validar: Agregar o no getFecha y getDocumentoId
}
