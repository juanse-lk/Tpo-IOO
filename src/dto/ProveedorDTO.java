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
