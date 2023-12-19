package dto;

import models.enums.FormaDePago;

import java.util.Date;

public class OrdenDePagoDTO {
    public FormaDePago formaPago;
    public int idDocumentoAsociado;
    public int idOrdenPago;
    public float importe;

    public Date fecha;
}
