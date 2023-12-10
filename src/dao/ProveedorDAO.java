package dao;

import models.Proveedor;
import utils.GenericDAO;
public class ProveedorDAO extends GenericDAO{
    // Se utiliza para abastraer los accesos a la base de datos
    public ProveedorDAO() throws Exception {
        super(Proveedor.class, "./src/jsons/proveedores.json");
    }

    public int getNextId() throws Exception {
        return this.getAll().size() + 1;
    }
}
