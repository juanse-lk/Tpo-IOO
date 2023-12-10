package models;
import models.enums.ResponsabilidadIva;
import java.time.LocalDate;
import java.util.List;

public class Proveedor {


    // Atributos

    private String cuit;
    private ResponsabilidadIva responsabilidadIva; //Enum
    private String razonSocial;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String numIngresosBrutos;
    private LocalDate inicioActividades;
    private float montoAdeudadoMaximo;
    private List<CertificadoRetencion> certificadosRetencion;
    private List<Rubro> rubros;
    private List<Factura> listaFacturas;
    private List<NotaDebito> listaNotasDebito;
    private List<NotaCredito> listaNotasCredito;
    private List<ProductoServicio> listaProductoServicio;

/*
    public Proveedor(ProveedorDTO prov){
        this.razonSocial = prov.razonSocial;
        this.nombre = prov.nombre;
    }

 */

    public Proveedor(String cuit, ResponsabilidadIva responsabilidadIva, String razonSocial, String nombre, String direccion, String telefono, String correo, String numIngresosBrutos, LocalDate inicioActividades, float montoAdeudadoMaximo) {
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
    }
}
