package dao;

import models.Factura;
import utils.GenericDAO;

public class FacturaDAO extends GenericDAO<Factura> {

    public FacturaDAO() throws Exception {
        super(Factura.class, "./src/jsons/facturas.json");
    }

    public int getNextId() throws Exception {
        return this.getAll().size() + 1;
    }
}
