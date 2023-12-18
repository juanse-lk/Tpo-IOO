package dto;

import java.util.List;
import java.util.Date;

public class OrdenDeCompraDTO {

    // Atributos
    public int idOrdenCompra;
    public List<ItemDTO> detalleDeCompra;
    public float total;
    public boolean check;
    public FacturaDTO factura;
    public Date fecha;
}