package controllers;

import dao.ProveedorDAO;
import dto.ProductoServicioDTO;
import models.ProductoServicio;
import models.Rubro;
import dao.RubroDAO;
import dao.ProductoServicioDAO;
import dto.RubroDTO;
import dao.ProveedorDAO;
import dto.ProveedorDTO;
import models.Proveedor;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;


public class ControllerProovedores {

    // INSTANCE
    private static ControllerProovedores INSTANCE = null;


    // Atributos
    private static List<ProductoServicio> listaProductosServicios;
    private static List<Rubro> listaRubros;

    // DAOs
    private static RubroDAO rubroDAO;
    private static ProductoServicioDAO productoServicioDAO;
    private static ProveedorDAO proveedorDAO;
    private static List<Proveedor> listaProveedores;
    // Constructor

    private ControllerProovedores() throws Exception {
        proveedorDAO = new ProveedorDAO();
        listaProveedores = proveedorDAO.getAll(Proveedor.class);
        rubroDAO = new RubroDAO();
        listaRubros = rubroDAO.getAll(Rubro.class);
        productoServicioDAO = new ProductoServicioDAO();
        listaProductosServicios = productoServicioDAO.getAll(ProductoServicio.class);
    }

    // Metodos
    private static String getPathOutModel(String simpleName) {
        String dir = new File("").getAbsolutePath();
        return  new File(simpleName+".json").getPath();
    }

    public static synchronized ControllerProovedores getInstances() throws Exception {
        if(INSTANCE == null)
            INSTANCE = new ControllerProovedores();
        return INSTANCE;
    }


    public void guardarListaRubros(){
        try {
            rubroDAO.saveAll(listaRubros);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    // Metodos de ControllerProductos

    // Metodos sobre rubros

    /**
     * Devuelve todos los rubros como DTO.
     * @return listRubrosDto.
     */
    public ArrayList<RubroDTO> getAllRubros(){
        ArrayList<RubroDTO> listRubrosDto = new ArrayList<>();
        for (Rubro rubro : listaRubros){
            RubroDTO rub = new RubroDTO();
            rub.idRubro = rubro.getIdRubro();
            rub.nombreRubro = rubro.getNombreRubro();
            rub.listaProductoServicio = rubro.getListaProductoServicio();
            listRubrosDto.add(rub);
        }
        return listRubrosDto;
    }


    public ArrayList<Integer> getAllRubrosId(){
        ArrayList<Integer> listRubrosId = new ArrayList<>();
        for (Rubro rubro : listaRubros){
            listRubrosId.add(rubro.getIdRubro());
        }
        return listRubrosId;
    }

    /**
     * Busca un rubro por id.
     * @param idRubro
     * @return Rubro
     */
    public static Rubro obtenerRubroPorId(int idRubro){
        for (Rubro rubro : listaRubros){
            if(rubro.getIdRubro() == idRubro){
                return rubro;
            }
        }
        return null;
    }

    /**
     * Toma un idRubro y valida su existencia.
     * @param idRubro Valor a consultar.
     * @return boolean.
     */
    public static boolean existeRubro(int idRubro){
        for(Rubro r: listaRubros){
            if(Objects.equals(r.getIdRubro(), idRubro))
                return true;
        }
        return false;
    }

    /**
     * Crea un nuevo rubro si no existe.
     * @param rubro nuevo rubro a crear
     * @return void.
     */
    public static void crearRubro(RubroDTO rubro) throws Exception {
        Rubro nuevoRubro = new Rubro(rubro);
        if(obtenerRubroPorId(nuevoRubro.getIdRubro())==null){
            rubroDAO.save(nuevoRubro);
            listaRubros.add(nuevoRubro);
        }
    }

    /**
     * Asigna un rubro a un proveedor.
     * @param rubroDto rubro a asignar.
     * @param cuitProovedor cuit de proveedor.
     * @return void.
     */
    public void asignarRubroAProveedor(RubroDTO rubroDto, int cuitProovedor){
        try {
            Proveedor proveedor = this.obtenerProveedorPorCuit(cuitProovedor);
            if(proveedor != null){
                Rubro nuevoRubro = new Rubro(rubroDto);
                proveedor.agregarRubro(nuevoRubro);
                this.proveedorDAO.update(proveedor);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }


    // Metodos sobre proveedores

    /**
     * Crea un nuevo proveedor.
     * @param proveedor nuevo proveedor.
     * @return void.
     */
    public static void crearProveedor(ProveedorDTO proveedor) throws Exception {

        Proveedor nuevoProveedor = new Proveedor(proveedor);
        if(obtenerProveedorPorCuit(nuevoProveedor.getCuit()) == null){ //verifico que no exista
            proveedorDAO.save(nuevoProveedor);
            listaProveedores.add(nuevoProveedor);
        }
    }

    /**
     * Busca un proveedor por cuit.
     * @param cuit cuit de proveedor.
     * @return ProveedorDTO.
     */
    public ProveedorDTO obtenerProveedorPorCuitDto(int cuit){
        for (Proveedor proveedor: listaProveedores){
            if(proveedor.getCuit() == cuit){
                return proveedor.toDTO();
            }
        }
        return null;
    }

    /**
     * Busca un proveedor por cuit.
     * @param cuit cuit de proveedor.
     * @return Proveedor
     */
    public static Proveedor obtenerProveedorPorCuit(int cuit){
        for (Proveedor proveedor: listaProveedores){
            if(proveedor.getCuit() == cuit){
                return proveedor;
            }
        }
        return null;
    }

    /**
     * Elimina un proveedor.
     * @param cuit cuit de proveedor.
     * @return void.
     */
    public void eliminarProveedor(int cuit) throws Exception {
        for (Proveedor proveedor : listaProveedores){
            if(proveedor.getCuit() == cuit) {
                proveedorDAO.delete(proveedor.getCuit());
                listaProveedores.remove(proveedor);
                guardar();
                break;
            }
        }
    }

    /**
     * Devuelve todos los proveedores como DTO.
     * @return listProveedoresDTO.
     */
    public ArrayList<ProveedorDTO> getAllProveedores(){
        ArrayList<ProveedorDTO> listProveedoresDTO = new ArrayList<>();
        for (Proveedor proveedor : listaProveedores){
            ProveedorDTO prov = new ProveedorDTO();
            prov.nombre = proveedor.getNombre();
            prov.cuit = proveedor.getCuit();
            prov.razonSocial = proveedor.getRazonSocial();
            prov.direccion = proveedor.getDireccion();
            listProveedoresDTO.add(prov);
        }
        return listProveedoresDTO;
    }

    public ArrayList<Integer> getAllProveedoresCuit(){
        ArrayList<Integer> cuits = new ArrayList<>();
        for(Proveedor proveedor: listaProveedores){
            cuits.add(proveedor.getCuit());
        }
        return cuits;
    }

    // Metodos de productos

    /**
     * Toma un idRubro y valida su existencia.
     * @param idProductoServicio Valor a consultar.
     * @return boolean.
     */
    public static boolean existeProducto(int idProductoServicio, int cuit){
        for(ProductoServicio p: listaProductosServicios){
            if(Objects.equals(p.getIdProductoServicio(), idProductoServicio) & p.getProveedor().getCuit() == cuit)
                return true;
        }
        return false;
    }


    /**
     * Crea un nuevo producto si no existe.
     * @param productoServicioDto nuevo producto a crear
     * @return void.
     */
    public static void crearProducto(ProductoServicioDTO productoServicioDto) throws Exception {
        ProductoServicio nuevoProductoServicio = new ProductoServicio(productoServicioDto);
        if(!existeProducto(productoServicioDto.idProductoServicio, productoServicioDto.proveedor.getCuit())){
            productoServicioDAO.save(ProductoServicioDTO.toModel(productoServicioDto));
            listaProductosServicios.add(nuevoProductoServicio);
        }
    }


    /**
     * Elimina un producto.
     * @param idProductoServicio
     * @return void.
     */
    public void eliminarProducto(int idProductoServicio) throws Exception {
        for(ProductoServicio productoServicio: listaProductosServicios){
            if(idProductoServicio == productoServicio.getIdProductoServicio()){
                productoServicioDAO.delete(productoServicio.getIdProductoServicio());
                listaProductosServicios.remove(productoServicio);
                guardar();
                break;
            }
        }
    }


    /**
     * Devuelve todos los productos como DTO.
     * @return listProveedoresDTO.
     */
    public ArrayList<ProductoServicioDTO> getAllProductoServicio() {
        ArrayList<ProductoServicioDTO> listProductoServicioDto = new ArrayList<>();
        for (ProductoServicio productoServicio: listaProductosServicios) {
            ProductoServicioDTO prod = new ProductoServicioDTO();
            prod.unidad = productoServicio.getUnidad();
            prod.precioUnidad = productoServicio.getPrecioUnidad();
            prod.tipoIva = productoServicio.getTipoIva();
            prod.idProductoServicio = productoServicio.getIdProductoServicio();
            prod.rubro = productoServicio.getRubroAsociado();
            prod.proveedor = productoServicio.getProveedor();
            listProductoServicioDto.add(prod);
        }
        return listProductoServicioDto;
    }

    /**
     * Busca un proveedor por cuit.
     * @param idProducto
     * @return ProductoServicioDTO.
     */
    /**
    public ProductoServicioDTO obtenerProductoPorId(int idProducto){
        for (ProductoServicio productoServicio: listaProductosServicios){
            if(productoServicio.getIdProductoServicio() == idProducto){
                return ProductoServicioDTO.toDTO();
            }
        }
        return null;
    }
    */
    public void guardar(){
        try {
            proveedorDAO.saveAll(listaProveedores);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
