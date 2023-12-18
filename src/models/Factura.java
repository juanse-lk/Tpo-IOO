package models;

import dto.FacturaDTO;
import dto.ProveedorDTO;
import models.enums.TipoDocumento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura extends Documento {

    // Atributos
    private List<Item> detalleFactura;

    public Factura(){
        this.detalleFactura = new ArrayList<Item>();
        this.fecha = new Date();
        this.monto = this.calcularMonto();
    }
    public Factura(FacturaDTO nuevaFact){
        this.detalleFactura = new ArrayList<Item>();
        this.idDocumento = nuevaFact.idDocuemento;
        this.fecha = new Date();
        this.monto = this.calcularMonto();

    }
    public Factura(Date fecha, int idDocumento, float monto, Proveedor proveedor, TipoDocumento tipoDocumento) {
        this.detalleFactura = new ArrayList<Item>();
        this.idDocumento = idDocumento;
        this.fecha = fecha;
        this.monto = this.calcularMonto();
    }

    public List<Item> getDetalleFactura() {
        return detalleFactura;
    }

    public float calcularMonto(){
        float total = 0;
        for(Item item: this.detalleFactura) {
            total += item.getImporte() * item.getCantidad();
        }
        return total;
    }

    // Metodos propios de Factura

    public float calcularImpuesto(){
        // TODO: 02/12/2023 agregar funcion
        return 0;
    }

    public Boolean tieneOrdenDePagoAsociada(){
        // TODO: 02/12/2023 agregar funcion
        return false;
    }
    // Constructor
    // Metodo que tiene una clase que instancia al objeto




    public void addItem(Item nuevoItem) {
        this.detalleFactura.add(nuevoItem);
    }

    public void addProveedor(ProveedorDTO proveedorDTO) throws Exception{
        this.proveedor = new Proveedor(proveedorDTO);
    }

    public FacturaDTO toDTO() {
        FacturaDTO facturaDTO = new FacturaDTO();
        facturaDTO.idDocuemento = this.getIdDocumento();
        facturaDTO.fecha = this.getFecha();
        facturaDTO.monto = this.calcularMonto();
        return facturaDTO;
    }
}


