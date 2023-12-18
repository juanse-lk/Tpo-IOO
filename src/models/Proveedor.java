package models;

import dto.ProveedorDTO;

import java.util.Date;
import java.util.List;
import models.enums.ResponsabilidadIva;
public class Proveedor {


    private int cuit;
    private ResponsabilidadIva responsabilidadIva; //Enum
    private String razonSocial;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String numIngresosBrutos;
    private Date inicioActividades;
    private float montoAdeudadoMaximo;
    private boolean certificadosRetencion;
    private List<Rubro> rubros;
    private List<Factura> listaFacturas;
    private List<NotaDebito> listaNotasDebito;
    private List<NotaCredito> listaNotasCredito;
    private List<ProductoServicio> listaProductoServicio;

    public Proveedor(int cuit, ResponsabilidadIva responsabilidadIva, String razonSocial, String nombre, String direccion, String telefono, String correo, String numIngresosBrutos, Date inicioActividades, float montoAdeudadoMaximo) {
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
    public Proveedor(ProveedorDTO prov){
        this.cuit = prov.cuit;
        this.responsabilidadIva = prov.responsabilidadIva;
        this.razonSocial = prov.razonSocial;
        this.nombre = prov.nombre;
        this.direccion = prov.direccion;
        this.telefono = prov.telefono;
        this.correo = prov.correo;
        this.numIngresosBrutos = prov.numIngresosBrutos;
        this.inicioActividades = prov.inicioActividades;
        this.montoAdeudadoMaximo = prov.montoAdeudadoMaximo;
        this.certificadosRetencion = prov.certificadosRetencion;
        this.rubros = prov.rubros;
        this.listaFacturas = prov.listaFacturas;
        this.listaNotasDebito = prov.listaNotasDebito;
        this.listaNotasCredito = prov.listaNotasCredito;
        this.listaProductoServicio = prov.listaProductoServicio;
    }

    //Geters

    public int getCuit() {
        return cuit;
    }

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

    // Seters

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public void setResponsabilidadIva(ResponsabilidadIva responsabilidadIva) {
        this.responsabilidadIva = responsabilidadIva;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumIngresosBrutos(String numIngresosBrutos) {
        this.numIngresosBrutos = numIngresosBrutos;
    }

    public void setInicioActividades(Date inicioActividades) {
        this.inicioActividades = inicioActividades;
    }

    public void setMontoAdeudadoMaximo(float montoAdeudadoMaximo) {
        this.montoAdeudadoMaximo = montoAdeudadoMaximo;
    }

    public void setCertificadosRetencion(boolean certificadosRetencion) {
        this.certificadosRetencion = certificadosRetencion;
    }

    public void setRubros(List<Rubro> rubros) {
        this.rubros = rubros;
    }

    public void setListaFacturas(List<Factura> listaFacturas) {
        this.listaFacturas = listaFacturas;
    }

    public void setListaNotasDebito(List<NotaDebito> listaNotasDebito) {
        this.listaNotasDebito = listaNotasDebito;
    }

    public void setListaNotasCredito(List<NotaCredito> listaNotasCredito) {
        this.listaNotasCredito = listaNotasCredito;
    }

    public void setListaProductoServicio(List<ProductoServicio> listaProductoServicio) {
        this.listaProductoServicio = listaProductoServicio;
    }


    // Metodos de Proovedor
    public ProveedorDTO toDTO() {
        ProveedorDTO dto = new ProveedorDTO();
        dto.cuit = this.cuit;
        dto.responsabilidadIva = this.responsabilidadIva;
        dto.razonSocial = this.razonSocial;
        dto.nombre = this.nombre;
        dto.direccion = this.direccion;
        dto.telefono = this.telefono;
        dto.correo = this.correo;
        dto.numIngresosBrutos = this.numIngresosBrutos;
        dto.inicioActividades = this.inicioActividades;
        dto.montoAdeudadoMaximo = this.montoAdeudadoMaximo;
        return dto;
    }

    public void agregarRubro(Rubro rubro){
        this.rubros.add(rubro);
    }
}
