package dto;

import models.*;
import models.enums.ResponsabilidadIva;

import java.time.LocalDate;
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
    public boolean certificadosRetencion;
    public List<Rubro> rubros;
    public List<Factura> listaFacturas;
    public List<NotaDebito> listaNotasDebito;
    public List<NotaCredito> listaNotasCredito;
    public List<ProductoServicio> listaProductoServicio;

    public ProveedorDTO() {

    }

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

    public boolean getCertificadosRetencion() {
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

   // Getters

    public int getCuit() {
        return cuit;
    }

    public boolean isCertificadosRetencion() {
        return certificadosRetencion;
    }

    // Constructor


    public ProveedorDTO(int cuit, ResponsabilidadIva responsabilidadIva, String razonSocial, String nombre, String direccion, String telefono, String correo, String numIngresosBrutos, Date inicioActividades, float montoAdeudadoMaximo, boolean certificadosRetencion, List<Rubro> rubros, List<Factura> listaFacturas, List<NotaDebito> listaNotasDebito, List<NotaCredito> listaNotasCredito, List<ProductoServicio> listaProductoServicio) {
        this.cuit = cuit;
        this.responsabilidadIva = responsabilidadIva;
        this.razonSocial = razonSocial;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.numIngresosBrutos = numIngresosBrutos;
        this.inicioActividades = inicioActividades;
        this.montoAdeudadoMaximo = montoAdeudadoMaximo;
        this.certificadosRetencion = certificadosRetencion;
        this.rubros = rubros;
        this.listaFacturas = listaFacturas;
        this.listaNotasDebito = listaNotasDebito;
        this.listaNotasCredito = listaNotasCredito;
        this.listaProductoServicio = listaProductoServicio;
    }
}
