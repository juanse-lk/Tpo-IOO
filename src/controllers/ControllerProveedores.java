package controllers;

import java.util.List;
import java.util.Objects;

import dao.ProveedorDAO;

import dto.ProveedorDTO;
import models.Proveedor;

public class ControllerProveedores {

    private static ControllerProveedores INSTANCE = null;
    private static ProveedorDAO proveedorDAO;
    private static List<Proveedor> listaProveedores;

    private ControllerProveedores() throws Exception {
        proveedorDAO = new ProveedorDAO();
        listaProveedores = proveedorDAO.getAll(Proveedor.class);
    }

    public static synchronized ControllerProveedores getInstances() throws Exception {
        if(INSTANCE == null) {
            INSTANCE = new ControllerProveedores();
        }
        return INSTANCE;
    }

    public void cargarProveedor(ProveedorDTO proveedor) throws Exception {

        Proveedor nuevoProveedor = new Proveedor(proveedor);
        if(obtenerProveedorPorCuit(nuevoProveedor.getCuit()) == null){ //verifico que no exista
            proveedorDAO.save(nuevoProveedor);
            listaProveedores.add(nuevoProveedor);
        }
    }

    public ProveedorDTO obtenerProveedorPorCuit(int cuit){
        for (Proveedor proveedor: listaProveedores){
            if(proveedor.getCuit() == cuit)){
                return proveedor.toDTO();
            }
        }
        return null;
    }

    public void eliminarProveedor(int cuit){
        for (Proveedor proveedor : listaProveedores){
            proveedorDAO.delete(proveedor.getCuit());
            listaProveedores.remove(proveedor);
            break;
        }
    }

}
