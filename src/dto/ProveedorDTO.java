package dto;

import models.*;
import models.enums.ResponsabilidadIva;

import java.util.Date;
import java.util.List;

public class ProveedorDTO {
    public int cuit;
    public ResponsabilidadIva responsabilidadIva; //Enum
    public String razonSocial;
    public String nombre;
    public String direccion;
    public String telefono;
    public String correo;
    public String numIngresosBrutos;
    public Date inicioActividades;
    public float montoAdeudadoMaximo;
    public List<CertificadoRetencion> certificadosRetencion;
    public List<Rubro> rubros;
    public List<Factura> listaFacturas;
    public List<NotaDebito> listaNotasDebito;
    public List<NotaCredito> listaNotasCredito;
    public List<ProductoServicio> listaProductoServicio;

    public static ProveedorDTO toDTO(Proveedor prov) {
        return null;
    }

    public int getCuit() {
        return Integer.parseInt(null);
    }




}
