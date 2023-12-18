package dao;

import models.NotaDebito;
import utils.GenericDAO;

public class NotaDeDebitoDAO extends GenericDAO<NotaDebito> {

    public NotaDeDebitoDAO() throws Exception {
        super(NotaDebito.class, "./src/jsons/notasDeDebito.json");
    }

    public int getNextId() throws Exception {
        return this.getAll().size() + 1;
    }

}
