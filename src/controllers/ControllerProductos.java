package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.ProveedorDAO;
import models.ProductoServicio;
import models.Rubro;
import dao.RubroDAO;
import dao.ProductoServicioDAO;
import dao.ProveedorDAO;
import dto.RubroDTO;
import dto.ProductoServicioDTO;
import dto.ProveedorDTO;
import models.Rubro;
import models.ProductoServicio;
import models.Proveedor;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;


public class ControllerProductos {

    // INSTANCE
    private static ControllerProductos INSTANCE = null;


    // Atributos
    private static List<ProductoServicio> listaProductosServicios;
    private static List<Rubro> listaRubros;

    // DAOs
    private static RubroDAO rubroDAO;
    private static ProductoServicioDAO productoServicioDAO;
    private static ProveedorDAO proveedorDAO;


    // Constructor

    private ControllerProductos() throws Exception {
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

    public static synchronized ControllerProductos getInstances() throws Exception {
        if(INSTANCE == null)
            INSTANCE = new ControllerProductos();
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
     * @param dto nuevo rubro a crear
     * @return void.
     */
    public void crearRubro(RubroDTO dto) throws Exception {
        if(!existeRubro(dto.getIdRubro())){
            rubroDAO.save(RubroDTO.toModel(dto));
        }
    }

    /**
     * Busca el rubro de un producto
     * @param dto producto a validar
     * @return String rubroAsociado
     */
    public RubroDTO getRubroPorProducto(ProductoServicioDTO dto) throws Exception{
        for(ProductoServicio sp: listaProductosServicios) {
            if(sp.getRubroAsociado() != null);{
                return sp.getRubroAsociado();
            }
        }
        return null;
    }
    public void asignarRubroAProveedor(){

    }

}
