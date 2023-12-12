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

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.io.File;
import java.util.ArrayList;


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

    // Metodos de ControllerProductos

}
