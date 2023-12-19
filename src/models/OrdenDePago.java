package models;

import dto.FacturaDTO;
import models.enums.ResponsabilidadIva;
import models.enums.FormaDePago;
import java.util.Date;
import dto.OrdenDePagoDTO;

public class OrdenDePago {

    // Atributos

    private FormaDePago formaPago;
    private int idDocumentoAsociado;
    private int idOrdenPago;
    private float importe;

    private Date fecha;

    public OrdenDePago(int idOrdenPago, FormaDePago formaDePago, int idDocumentoAsociado, float importe){
        this.formaPago = formaDePago;
        this.idOrdenPago = idOrdenPago;
        this.idDocumentoAsociado = idDocumentoAsociado;
        this.importe = importe;
        this.fecha = new Date();
    }

    public OrdenDePago(OrdenDePagoDTO ordenDePagoDTO){
        this.formaPago = ordenDePagoDTO.formaPago;
        this.idOrdenPago = ordenDePagoDTO.idOrdenPago;
        this.idDocumentoAsociado = ordenDePagoDTO.idDocumentoAsociado;
        this.importe = ordenDePagoDTO.importe;
        this.fecha = new Date();
    }

    public OrdenDePagoDTO toDTO() {
        OrdenDePagoDTO ordenDePagoDTO = new OrdenDePagoDTO();
        ordenDePagoDTO.idDocumentoAsociado = this.getIdDocumentoAsociado();
        ordenDePagoDTO.fecha = this.getFecha();
        ordenDePagoDTO.importe = this.importe;
        ordenDePagoDTO.formaPago = this.getFormaPago();
        return ordenDePagoDTO;
    }

    // Metodos

    // Getters
    public FormaDePago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaDePago formaPago) {
        this.formaPago = formaPago;
    }

    public int getIdDocumentoAsociado() {
        return idDocumentoAsociado;
    }

    public float getImporte() {
        return importe;
    }

    public Date getFecha() {
        return fecha;
    }
    // Setters
    public void setImporte(float importe) {
        this.importe = importe;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setIdDocumentoAsociado(int idDocumento) {
        this.idDocumentoAsociado = idDocumento;
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
