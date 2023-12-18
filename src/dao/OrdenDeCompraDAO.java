package dao;

import models.OrdenDeCompra;
import utils.GenericDAO;

public class OrdenDeCompraDAO extends GenericDAO<OrdenDeCompra> {

    public OrdenDeCompraDAO() throws Exception {
        super(OrdenDeCompra.class, "./src/jsons/ordenesDeCompra.json");
    }

    public int getNextId() throws Exception {
        return this.getAll().size() + 1;
    }
}