package models;
import java.util.List;

public class OrdenDeCompra {

    // Atributos
    private int idOrdenCompra;
    private List<ItemOrdenCompra> detalleDeCompra;
    private float total;
    private boolean check;

    // Metodos

    // Getters

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public List<ItemOrdenCompra> getDetalleDeCompra() {
        return detalleDeCompra;
    }

    public void setDetalleDeCompra(List<ItemOrdenCompra> detalleDeCompra) {
        this.detalleDeCompra = detalleDeCompra;
    }

    public float getTotal() {
        return total;
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

    // Metodos de OrdenDeCompra
    public float calcularTotal(){
        //todo: Agregar el desarrollo de la funcion calcularTotal
        return 0;
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
}

