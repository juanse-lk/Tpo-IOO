package controllers;

import dto.*;
import models.*;
import dao.*;
import models.enums.FormaDePago;

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
    private List<OrdenDePago> ordenesDePago;

    private OrdenDeCompraDAO ordenDeCompraDAO;
    private FacturaDAO facturaDAO;
    private NotaDeCreditoDAO notaDeCreditoDAO;
    private NotaDeDebitoDAO notaDeDebitoDAO;
    private OrdenDePagoDAO ordenDePagoDAO;

    public ControllerDocumentos() throws Exception {
        this.ordenDeCompraDAO = new OrdenDeCompraDAO();
        this.ordenesDeCompra = this.ordenDeCompraDAO.getAll();

        this.facturaDAO = new FacturaDAO();
        this.facturas = this.facturaDAO.getAll();

        this.notaDeCreditoDAO = new NotaDeCreditoDAO();
        this.notasDeCredito = this.notaDeCreditoDAO.getAll();

        this.notaDeDebitoDAO = new NotaDeDebitoDAO();
        this.notasDeDebito = this.notaDeDebitoDAO.getAll();

        this.ordenDePagoDAO = new OrdenDePagoDAO();
        this.ordenesDePago = this.ordenDePagoDAO.getAll();

    }

    public static synchronized ControllerDocumentos getInstances() throws Exception {
        if (INSTANCE == null)
            INSTANCE = new ControllerDocumentos();
        return INSTANCE;
    }

    // Ordenes de compra

    public OrdenDeCompraDTO getOrdenCompraById(int ordenId) {
        OrdenDeCompraDTO ordenCompra = null;
        for (OrdenDeCompra orden : this.ordenesDeCompra) {
            if (orden.getIdOrdenCompra() == ordenId) {
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

        for (ItemDTO itemDTO : items) {
            Item nuevoItem = new Item(itemDTO);
            nuevaFactura.addItem(nuevoItem);
        }
        nuevaFactura.setProveedor(ControllerProovedores.getInstances().obtenerProveedorPorCuit(cuitProveedor));
        this.facturas.add(nuevaFactura);
        this.facturaDAO.save(nuevaFactura);

    }

    public void agregarFacturaTest(int cuitProveedor, List<Item> items) throws Exception { // TODO Borrar
        Factura nuevaFactura = new Factura();
        nuevaFactura.setIdDocumento(this.facturaDAO.getNextId());

        for (Item item : items) {
            nuevaFactura.addItem(item);
        }
        nuevaFactura.setProveedor(ControllerProovedores.getInstances().obtenerProveedorPorCuit(cuitProveedor));
        this.facturas.add(nuevaFactura);
        this.facturaDAO.save(nuevaFactura);

    }

    public FacturaDTO getFacturaById(int id) {
        FacturaDTO factura = null;
        for (Factura fact : this.facturas) {
            if (fact.getIdDocumento() == id) {
                factura = fact.toDTO();
            }
        }
        return factura;
    }

    public List<FacturaDTO> getFacturasByProveedor(int cuit) {
        List<FacturaDTO> facturasDTO = new ArrayList<>();
        for (Factura fact : this.facturas) {
            if (fact.getProveedor().getCuit() == cuit) {
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

    public List<FacturaDTO> getAllFacturas() {
        List<FacturaDTO> facturasDTO = new ArrayList<>();
        for (Factura fact : this.facturas) {
            facturasDTO.add(fact.toDTO());
        }
        return facturasDTO;
    }


    // Libro IVA Compras

    public ArrayList<FilaLibroIvaDTO> obtenerLibroIva() {

        ArrayList<FilaLibroIvaDTO> filas = new ArrayList<>();
        for (Factura factura : this.facturas) {
            FilaLibroIvaDTO fila = new FilaLibroIvaDTO();
            if (factura.getOrdenDePagoAsociada() != null) {
                Proveedor proveedor = factura.getProveedor();
                fila.cuit = proveedor.getCuit();
                fila.fecha = factura.getFecha();
                fila.nombre = proveedor.getNombre();
                fila.tipoDoc = factura.getTipoDocumento();
                fila.IVA_2_5 = factura.getIva2_5();
                fila.IVA_5 = factura.getIva_5();
                fila.IVA_10_5 = factura.getIva_10_5();
                fila.IVA_21 = factura.getIva_21();
                fila.IVA_27 = factura.getIva_27();
                fila.total = factura.calcularMonto();

                filas.add(fila);
            }
        }
        for (NotaDebito nd : this.notasDeDebito) {
            FilaLibroIvaDTO fila = new FilaLibroIvaDTO();
            if (nd.getOrdenDePagoAsociada() != null) {
                Proveedor proveedor = nd.getProveedor();
                fila.cuit = proveedor.getCuit();
                fila.fecha = nd.getFecha();
                fila.nombre = proveedor.getNombre();
                fila.tipoDoc = nd.getTipoDocumento();
                fila.IVA_2_5 = 0;
                fila.IVA_5 = 0;
                fila.IVA_10_5 = 0;
                fila.IVA_21 = 0;
                fila.IVA_27 = 0;
                fila.total = nd.getMonto();

                filas.add(fila);
            }
        }
        for (NotaCredito nc : this.notasDeCredito) {
            FilaLibroIvaDTO fila = new FilaLibroIvaDTO();
            Proveedor proveedor = nc.getProveedor();
            fila.cuit = proveedor.getCuit();
            fila.fecha = nc.getFecha();
            fila.nombre = proveedor.getNombre();
            fila.tipoDoc = nc.getTipoDocumento();
            fila.IVA_2_5 = 0;
            fila.IVA_5 = 0;
            fila.IVA_10_5 = 0;
            fila.IVA_21 = 0;
            fila.IVA_27 = 0;
            fila.total = nc.getMonto();

            filas.add(fila);
        }

        return filas;

    }

    // Ordenes de Pago

    public void agregarOrdenDePago(int idDocuentoAsociado, int importe, FormaDePago formaDePago) throws Exception {
        OrdenDePago nuevaOrdenDePago = new OrdenDePago(this.ordenDePagoDAO.getNextId(), formaDePago, idDocuentoAsociado, importe);

        this.ordenesDePago.add(nuevaOrdenDePago);
        this.ordenDePagoDAO.save(nuevaOrdenDePago);

    }

    public List<OrdenDePagoDTO> getOrdenesDePagoByDate(Date fecha) {
        List<OrdenDePagoDTO> OrdenesDePagoDTO = new ArrayList<>();
        for (OrdenDePago orden : this.ordenesDePago) {
            if (orden.getFecha().equals(fecha)) {
                OrdenesDePagoDTO.add(orden.toDTO());
            }
        }
        return OrdenesDePagoDTO;
    }

    public List<OrdenDePagoDTO> getAllOrdenesDePago() {
        List<OrdenDePagoDTO> ordenesDePagoDTO = new ArrayList<>();
        for (OrdenDePago orden : this.ordenesDePago) {
            ordenesDePagoDTO.add(orden.toDTO());
        }
        return ordenesDePagoDTO;
    }

    public List<OrdenDePagoDTO> getOrdenesDePagoByDocumentoAsociado(int idDocuentoAsociado) {
        List<OrdenDePagoDTO> OrdenesDePagoDTO = new ArrayList<>();
        for (OrdenDePago orden : this.ordenesDePago) {
            if (orden.getIdDocumentoAsociado() == idDocuentoAsociado) {
                OrdenesDePagoDTO.add(orden.toDTO());
            }
        }
        return OrdenesDePagoDTO;
    }

}
