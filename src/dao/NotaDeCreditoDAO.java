package dao;

import models.NotaCredito;
import utils.GenericDAO;

public class NotaDeCreditoDAO extends GenericDAO<NotaCredito> {

    public NotaDeCreditoDAO() throws Exception {
        super(NotaCredito.class, "./src/jsons/notasDeCredito.json");
    }

    public int getNextId() throws Exception {
        return this.getAll().size() + 1;
    }
}
