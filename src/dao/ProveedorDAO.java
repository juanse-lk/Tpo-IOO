package dao;

import models.Proveedor;
import utils.GenericDAO;
public class ProveedorDAO extends GenericDAO<Proveedor>{

    public ProveedorDAO() throws Exception {
        super(Proveedor.class, "./src/jsons/proveedores.json");
    }

    public int getNextId() throws Exception {
        return this.getAll().size() + 1;
    }
}
