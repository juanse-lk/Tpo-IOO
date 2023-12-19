package models;

import dto.ItemDTO;

public class Item {

    // Atributos

    private int cantidad;
    private ProductoServicio producto;
    private float importe;


    // Metodos

    // Getters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoServicio getProducto() {
        return producto;
    }

    public void setProducto(ProductoServicio producto) {
        this.producto = producto;
    }

    public float getImporte() {
        return importe;
    }

    // Setters
    public void setImporte(float importe) {
        this.importe = importe;
    }

    private float calcularImporte(ProductoServicio prod, int cantidad){
        float total = cantidad * prod.getPrecioUnidad() * ( 1 + prod.getTipoIva().getPercentage());
        return total;
    }

    // Constructor
    public Item(int cantidad, ProductoServicio producto) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.importe = calcularImporte(producto, cantidad);
    }

    public Item(ItemDTO itemDTO){
        this.cantidad = itemDTO.cantidad;
        this.importe = itemDTO.importe;
        this.producto = ProductoServicio.toModel(itemDTO.producto);
    }

}
