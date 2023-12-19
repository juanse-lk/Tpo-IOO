package dto;

import java.util.Date;
import models.enums.TipoDocumento;
public class FilaLibroIvaDTO {

    public int cuit;
    public String nombre;
    public Date fecha;
    public TipoDocumento tipoDoc;
    public float IVA_2_5;
    public float IVA_5;
    public float IVA_10_5;
    public float IVA_21;
    public float IVA_27;
    public float total;
}
