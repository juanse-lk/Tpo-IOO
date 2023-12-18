package controllers;

import dto.FacturaDTO;
import dto.ItemDTO;
import dto.OrdenDeCompraDTO;
import dto.ProductoServicioDTO;
import models.*;
import dao.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ControllerDocumentos {

    // INSTANCE
    private static ControllerDocumentos INSTANCE = null;

    // Atributos

    private List<OrdenDeCompra> ordenesDeCompra;
    private List<Factura> facturas;
    private List<NotaCredito> notasDeCredito;
    private List<NotaDebito> notasDeDebito;

    private OrdenDeCompraDAO ordenDeCompraDAO;
    private FacturaDAO facturaDAO;
    private NotaDeCreditoDAO notaDeCreditoDAO;
    private NotaDeDebitoDAO notaDeDebitoDAO;

    public ControllerDocumentos() throws Exception {
        this.ordenDeCompraDAO = new OrdenDeCompraDAO();
        this.ordenesDeCompra = this.ordenDeCompraDAO.getAll();

        this.facturaDAO = new FacturaDAO();
        this.facturas = this.facturaDAO.getAll();

        this.notaDeCreditoDAO = new NotaDeCreditoDAO();
        this.notasDeCredito = this.notaDeCreditoDAO.getAll();

        this.notaDeDebitoDAO = new NotaDeDebitoDAO();
        this.notasDeDebito = this.notaDeDebitoDAO.getAll();

    }
    public static synchronized ControllerDocumentos getInstances() throws Exception {
        if (INSTANCE == null)
            INSTANCE = new ControllerDocumentos();
        return INSTANCE;
    }

    // Ordenes de compra

    public OrdenDeCompraDTO getOrdenCompraById(int ordenId){
        OrdenDeCompraDTO ordenCompra = null;
        for(OrdenDeCompra orden: this.ordenesDeCompra) {
            if(orden.getIdOrdenCompra() == ordenId) {
                ordenCompra = orden.toDTO();
                break;
            }
        }
        return ordenCompra;
    }

    // Facturas


    public void agregarFactura(int cuitProveedor, List<ItemDTO> items) throws Exception {
        Factura nuevaFactura = new Factura();
        nuevaFactura.setIdDocumento(this.facturaDAO.getNextId());

        for (ItemDTO itemDTO: items){
            Item nuevoItem = new Item(itemDTO);
            nuevaFactura.addItem(nuevoItem);
        }
        nuevaFactura.setProveedor(ControllerProovedores.getInstances().obtenerProveedorPorCuit(cuitProveedor));
        this.facturas.add(nuevaFactura);
        this.facturaDAO.save(nuevaFactura);

    }

    public void agregarFacturaTest(int cuitProveedor, List<Item> items) throws Exception {
        Factura nuevaFactura = new Factura();
        nuevaFactura.setIdDocumento(this.facturaDAO.getNextId());

        for (Item item: items){
            nuevaFactura.addItem(item);
        }
        nuevaFactura.setProveedor(ControllerProovedores.getInstances().obtenerProveedorPorCuit(cuitProveedor));
        this.facturas.add(nuevaFactura);
        this.facturaDAO.save(nuevaFactura);

    }

    public FacturaDTO getFacturaById(int id){
        FacturaDTO factura = null;
        for(Factura fact: this.facturas){
            if(fact.getIdDocumento() == id){
                factura = fact.toDTO();
            }
        }
        return factura;
    }

    public List<FacturaDTO> getFacturasByProveedor(int cuit){
        List<FacturaDTO> facturasDTO = new ArrayList<>();
        for(Factura fact: this.facturas){
            if(fact.getProveedor().getCuit() == cuit){
                facturasDTO.add(fact.toDTO());
            }
        }
        return facturasDTO;
    }

    public List<FacturaDTO> getFacturasByDate(Date fecha) {
        List<FacturaDTO> facturasDTO = new ArrayList<>();
        for (Factura fact : this.facturas) {
            if (fact.getFecha().equals(fecha)) {
                facturasDTO.add(fact.toDTO());
            }
        }
        return facturasDTO;
    }

    public List<FacturaDTO> getAllFacturas(){
        List<FacturaDTO> facturasDTO = new ArrayList<>();
        for (Factura fact : this.facturas){
            facturasDTO.add(fact.toDTO());
        }
        return facturasDTO;
    }
}

