package models;

import models.enums.TipoIva;
import models.enums.Unidad;
import dto.ProductoServicioDTO;

import dto.ProductoServicioDTO;
import dto.RubroDTO;

public class ProductoServicio {

    // Atributos

    private Unidad unidad;
    private float precioUnidad;
    private TipoIva tipoIva;
    private int idProductoServicio;

    // DTOs
    public RubroDTO rubroAsociado;
    // Metodos

    // Getters y setters
    // Borrar setters?
    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public TipoIva getTipoIva() {
        return tipoIva;
    }

    public void setTipoIva(TipoIva tipoIva) {
        this.tipoIva = tipoIva;
    }

    public int getIdProductoServicio() {
        return idProductoServicio;
    }

    public void setIdProductoServicio(int idProductoServicio) {
        this.idProductoServicio = idProductoServicio;
    }

    public RubroDTO getRubroAsociado() {
        return rubroAsociado;
    }

    public void setRubroAsociado(RubroDTO rubroAsociado) {
        this.rubroAsociado = rubroAsociado;
    }
    // Funciones de ProductoServicio

    public String getProveedor(){
        //Todo: desarrollar la funcion getproveedor
        return "idProveedor";
    }

    // Constructor

    public ProductoServicio(Unidad unidad, float precioUnidad, TipoIva tipoIva, int idProductoServicio) {
        this.unidad = unidad;
        this.precioUnidad = precioUnidad;
        this.tipoIva = tipoIva;
        this.idProductoServicio = idProductoServicio;
    }

    public static ProductoServicioDTO toDTO(ProductoServicio productoServicio) {
        ProductoServicioDTO dto = new ProductoServicioDTO(
                productoServicio.getUnidad(),
                productoServicio.getPrecioUnidad(),
                productoServicio.getTipoIva(),
                productoServicio.getIdProductoServicio());
        return dto;
    }

    public static ProductoServicio toModel(ProductoServicioDTO models){
        ProductoServicio datos = new ProductoServicio(
                models.getUnidad(),
                models.getPrecioUnidad(),
                models.getTipoIva(),
                models.getIdProductoServicio()
                );
        return datos;
    }
}
