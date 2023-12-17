package dto;

import models.*;
import models.enums.ResponsabilidadIva;

import java.util.Date;
import java.util.List;

public class ProveedorDTO {
    public int cuit;
    public ResponsabilidadIva responsabilidadIva; //Enum
    public String razonSocial;
    public String nombre;
    public String direccion;
    public String telefono;
    public String correo;
    public String numIngresosBrutos;
    public Date inicioActividades;
    public float montoAdeudadoMaximo;
    public List<CertificadoRetencion> certificadosRetencion;
    public List<Rubro> rubros;
    public List<Factura> listaFacturas;
    public List<NotaDebito> listaNotasDebito;
    public List<NotaCredito> listaNotasCredito;
    public List<ProductoServicio> listaProductoServicio;

    public static ProveedorDTO toDTO(Proveedor prov) {
        return null;
    }

    // Getters

    public ResponsabilidadIva getResponsabilidadIva() {
        return responsabilidadIva;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumIngresosBrutos() {
        return numIngresosBrutos;
    }

    public Date getInicioActividades() {
        return inicioActividades;
    }

    public float getMontoAdeudadoMaximo() {
        return montoAdeudadoMaximo;
    }

    public List<CertificadoRetencion> getCertificadosRetencion() {
        return certificadosRetencion;
    }

    public List<Rubro> getRubros() {
        return rubros;
    }

    public List<Factura> getListaFacturas() {
        return listaFacturas;
    }

    public List<NotaDebito> getListaNotasDebito() {
        return listaNotasDebito;
    }

    public List<NotaCredito> getListaNotasCredito() {
        return listaNotasCredito;
    }

    public List<ProductoServicio> getListaProductoServicio() {
        return listaProductoServicio;
    }

    public int getCuit() {
        return Integer.parseInt(null);
    }

    // Metodos de ProveedeorDTO






}
