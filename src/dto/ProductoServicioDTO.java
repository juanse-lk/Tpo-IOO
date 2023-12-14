package dto;

import models.ProductoServicio;
import models.Rubro;
import models.enums.TipoIva;
import models.enums.Unidad;

public class ProductoServicioDTO {

    // Atributos

    private Unidad unidad;
    private float precioUnidad;
    private TipoIva tipoIva;
    private int idProductoServicio;
    private String idRubro;


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

    public String getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(String idRubro) {
        this.idRubro = idRubro;
    }

    // Constructor


    public ProductoServicioDTO(Unidad unidad, float precioUnidad, TipoIva tipoIva, int idProductoServicio) {
        this.unidad = unidad;
        this.precioUnidad = precioUnidad;
        this.tipoIva = tipoIva;
        this.idProductoServicio = idProductoServicio;
    }

    public static ProductoServicio toModel(ProductoServicioDTO productoServicioDto){
        return new ProductoServicio(
                productoServicioDto.getUnidad(),
                productoServicioDto.getPrecioUnidad(),
                productoServicioDto.getTipoIva(),
                productoServicioDto.getIdProductoServicio()
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
        this.idRubro = rubro.getIdRubro();
    }

}
