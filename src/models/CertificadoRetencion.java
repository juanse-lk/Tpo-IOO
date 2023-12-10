package models;

import models.enums.TipoImpuesto;

import java.util.Date;

public class CertificadoRetencion {

    // Atributos

    private TipoImpuesto tipoImpuesto;
    private Date fechaInicio;
    private Date fechaFinal;

    // Metodos

    // Getters
    public TipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }


    // Setters
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    // Metodos de Certificado de Retencion

    public boolean validarCertificado(){
        // TODO: 02/12/2023  desarrollar funcion validar certificado
        return true;
    }

    // Constructor

    public CertificadoRetencion(TipoImpuesto tipoImpuesto, Date fechaInicio, Date fechaFinal) {
        this.tipoImpuesto = tipoImpuesto;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }
}





