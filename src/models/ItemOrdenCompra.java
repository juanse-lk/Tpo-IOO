package models;

public class ItemOrdenCompra {

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

    // Constructor
    public ItemOrdenCompra(int cantidad, ProductoServicio producto, float importe) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.importe = importe;
    }
}
