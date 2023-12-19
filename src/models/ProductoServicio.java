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
    private Proveedor proveedor;
    private Rubro rubroAsociado;
    // Metodos

    // Getters y setters

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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Rubro getRubroAsociado() {
        return rubroAsociado;
    }

    public void setRubroAsociado(Rubro rubroAsociado) {
        this.rubroAsociado = rubroAsociado;
    }


    // Constructor
    public ProductoServicio(ProductoServicioDTO productoServicioDTO) {
        this.unidad = productoServicioDTO.unidad;
        this.precioUnidad = productoServicioDTO.precioUnidad;
        this.tipoIva = productoServicioDTO.tipoIva;
        this.idProductoServicio = productoServicioDTO.idProductoServicio;
        this.proveedor = productoServicioDTO.proveedor;
        this.rubroAsociado = productoServicioDTO.rubro;
    }
    public ProductoServicio(Unidad unidad, float precioUnidad, TipoIva tipoIva, int idProductoServicio) {
        this.unidad = unidad;
        this.precioUnidad = precioUnidad;
        this.tipoIva = tipoIva;
        this.idProductoServicio = idProductoServicio;
    }

    public ProductoServicio(Unidad unidad, float precioUnidad, TipoIva tipoIva, int idProductoServicio, Rubro rubro, Proveedor proveedor) {
        this.unidad = unidad;
        this.precioUnidad = precioUnidad;
        this.tipoIva = tipoIva;
        this.idProductoServicio = idProductoServicio;
        this.rubroAsociado = rubro;
        this.proveedor = proveedor;
    }

    public ProductoServicioDTO toDTO() {
        ProductoServicioDTO dto = new ProductoServicioDTO(
                this.getUnidad(),
                this.getPrecioUnidad(),
                this.getTipoIva(),
                this.getIdProductoServicio());
        return dto;
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
                models.unidad,
                models.precioUnidad,
                models.tipoIva,
                models.idProductoServicio
                );
        return datos;
    }
}
