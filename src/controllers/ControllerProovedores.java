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
        rubroDAO = new RubroDAO(Rubro.class,getPathOutModel(Rubro.class.getSimpleName()));
        listaRubros = rubroDAO.getAll(Rubro.class);
        productoServicioDAO = new ProductoServicioDAO(ProductoServicio.class,getPathOutModel(ProductoServicio.class.getSimpleName()));
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
     * Toma un idRubro y valida su existencia.
     * @param idRubro Valor a consultar.
     * @return boolean.
     */
    public boolean existeRubro(String idRubro){
        for(Rubro r: listaRubros){
            if(Objects.equals(r.getIdRubro(), idRubro))
                return true;
        }
        return false;
    }

    /**
     * Crea un nuevo rubro si no existe.
     * @param rubroDto nuevo rubro a crear
     * @return void.
     */
    public void crearRubro(RubroDTO rubroDto) throws Exception {
        if(!existeRubro(rubroDto.getIdRubro())){
            rubroDAO.save(RubroDTO.toModel(rubroDto));
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
    public void crearProveedor(ProveedorDTO proveedor) throws Exception {

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
    public Proveedor obtenerProveedorPorCuit(int cuit){
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
                break;
            }
        }
    }

    /**
     * Devuelve todos los proveedores como DTO.
     * @return listProveedoresDTO.
     */
    public ArrayList<ProveedorDTO> getAllProveedores(){ //TODO Revisar que con nombre, cuit y direccion alcance o le pasamos todo
        ArrayList<ProveedorDTO> listProveedoresDTO = new ArrayList<>();
        for (Proveedor proveedor : listaProveedores){
            ProveedorDTO prov = new ProveedorDTO();
            prov.nombre = proveedor.getNombre();
            prov.cuit = proveedor.getCuit();
            prov.direccion = proveedor.getDireccion();
            listProveedoresDTO.add(prov);
        }
        return listProveedoresDTO;
    }

    // Metodos de productos

    /**
     * Toma un idRubro y valida su existencia.
     * @param idProductoServicio Valor a consultar.
     * @return boolean.
     */
    public boolean existeProducto(int idProductoServicio){
        for(ProductoServicio p: listaProductosServicios){
            if(Objects.equals(p.getIdProductoServicio(), idProductoServicio))
                return true;
        }
        return false;
    }


    /**
     * Crea un nuevo producto si no existe.
     * @param productoServicioDto nuevo producto a crear
     * @return void.
     */
    public void crearProducto(ProductoServicioDTO productoServicioDto) throws Exception {
        if(!existeProducto(productoServicioDto.getIdProductoServicio())){
            productoServicioDAO.save(ProductoServicioDTO.toModel(productoServicioDto));
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
            }
        }
    }

    /**
     * Devuelve todos los productos como DTO.
     * @return listProveedoresDTO.
     */
    public ArrayList<ProductoServicioDTO> getAllProductoServicio() throws Exception {
        ArrayList<ProductoServicioDTO> dtoList = new ArrayList<>();
        for (ProductoServicio p : productoServicioDAO.getAll(ProductoServicio.class)) {
            dtoList.add(ProductoServicioDTO.toDTO(p));
        }
        return dtoList;
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
}
