package dto;

import java.util.Date;
import java.util.List;

public class FacturaDTO {

    public List<ItemDTO> detalleFactura;
    public Date fecha;
    public int idDocuemento;
    public float monto;

}
