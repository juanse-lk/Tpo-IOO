package controllers;

import java.util.ArrayList;
import java.util.List;

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
            if(proveedor.getCuit() == cuit){
                return proveedor.toDTO();
            }
        }
        return null;
    }

    public void eliminarProveedor(int cuit) throws Exception {
        for (Proveedor proveedor : listaProveedores){
            if(proveedor.getCuit() == cuit) {
                proveedorDAO.delete(proveedor.getCuit());
                listaProveedores.remove(proveedor);
                break;
            }
        }
    }

    // Devuelve todos los proveedores como DTO
    public ArrayList<ProveedorDTO> obtenerProveedores(){ //TODO Revisar que con nombre, cuit y direccion alcance o le pasamos todo
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

    //public getPrdocutos ?? TODO ?



}
