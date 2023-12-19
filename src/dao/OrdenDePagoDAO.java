package dao;

import models.OrdenDePago;
import utils.GenericDAO;

public class OrdenDePagoDAO extends GenericDAO<OrdenDePago> {

    public OrdenDePagoDAO() throws Exception {
        super(OrdenDePago.class, "./src/jsons/ordenesDePago.json");
    }

    public int getNextId() throws Exception {
        return this.getAll().size() + 1;
    }
}