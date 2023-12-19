package dto;

import models.ProductoServicio;
import models.Proveedor;
import models.Rubro;
import models.enums.TipoIva;
import models.enums.Unidad;

public class ProductoServicioDTO {

    // Atributos

    public Unidad unidad;
    public float precioUnidad;
    public TipoIva tipoIva;
    public int idProductoServicio;
    public Rubro rubro;

    public Proveedor proveedor;
    // Constructor
    public ProductoServicioDTO() {

    }


    public ProductoServicioDTO(Unidad unidad, float precioUnidad, TipoIva tipoIva, int idProductoServicio) {
        this.unidad = unidad;
        this.precioUnidad = precioUnidad;
        this.tipoIva = tipoIva;
        this.idProductoServicio = idProductoServicio;
    }

    public ProductoServicioDTO(Unidad unidad, float precioUnidad, TipoIva tipoIva, int idProductoServicio, Proveedor proveedor, Rubro rubro) {
        this.unidad = unidad;
        this.precioUnidad = precioUnidad;
        this.tipoIva = tipoIva;
        this.idProductoServicio = idProductoServicio;
        this.rubro = rubro;
        this.proveedor = proveedor;

    }

    public static ProductoServicio toModel(ProductoServicioDTO productoServicioDto){
        return new ProductoServicio(
                productoServicioDto.unidad,
                productoServicioDto.precioUnidad,
                productoServicioDto.tipoIva,
                productoServicioDto.idProductoServicio,
                productoServicioDto.rubro,
                productoServicioDto.proveedor
        );
    }

    public static ProductoServicioDTO toDTO(ProductoServicio productoServicio) throws Exception{
        return new ProductoServicioDTO(
                productoServicio.getUnidad(),
                productoServicio.getPrecioUnidad(),
                productoServicio.getTipoIva(),
                productoServicio.getIdProductoServicio()
        );
    }

    // Funciones de ProductoServicio


    public String getProveedor(){
        //Todo: desarrollar la funcion getproveedor
        return "idProveedor";
    }

    /**
     * Asigna un idRubro al proveedor.
     * @param rubro nuevo rubro a crear
     * @return void.
     */
    public void asignarRubroAProveedor(Rubro rubro){
        this.rubro = rubro;
    }


}
