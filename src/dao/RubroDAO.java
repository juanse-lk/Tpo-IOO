package dao;

import models.Rubro;
import utils.GenericDAO;

public class RubroDAO extends GenericDAO<Rubro>{
    public RubroDAO(Class<Rubro> clase, String file) throws Exception {
        super(clase, file);
    }

}
