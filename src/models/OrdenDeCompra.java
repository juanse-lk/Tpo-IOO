package models;
import dto.OrdenDeCompraDTO;

import java.util.List;
import java.util.Date;

public class OrdenDeCompra {

    // Atributos
    private int idOrdenCompra;
    private Date fecha;
    private List<Item> detalleDeCompra;
    private float total;
    private boolean check;
    private Factura factura;

    // Metodos

    // Getters

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public List<Item> getDetalleDeCompra() {
        return detalleDeCompra;
    }

    public void setDetalleDeCompra(List<Item> detalleDeCompra) {
        this.detalleDeCompra = detalleDeCompra;
    }

    public float getTotal() {
        return total;
    }

    public Factura getFactura() {
        return factura;
    }



    // Setters
    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }


    // Metodos de OrdenDeCompra
    public float calcularTotal(){
        float total = 0;
        for(Item item: this.detalleDeCompra) {
            total += item.getImporte() * item.getCantidad();
        }
        return total;
    }

    public float getMontoAdeudadoMaximo(){
        //todo: Agregar el desarrollo de la funcion getMontoAdeudadoMaximo
        return 0;
    }

    public boolean superaTopeAdeudado(){
        //todo: Agregar el desarrollo de la funcion superaTopeAdeudado
        return false;
    }

    // Constructor

    public OrdenDeCompra(int idOrdenCompra, float total, boolean check) {
        this.idOrdenCompra = idOrdenCompra;
        this.total = total;
        this.check = check;
    }

    public OrdenDeCompraDTO toDTO() {
        OrdenDeCompraDTO orden = new OrdenDeCompraDTO();
        orden.idOrdenCompra = this.idOrdenCompra;
        orden.fecha = this.fecha;
        orden.total = this.calcularTotal();
        return orden;
    }

}

