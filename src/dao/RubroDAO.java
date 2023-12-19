package dao;

import models.ProductoServicio;
import models.Rubro;
import utils.GenericDAO;

public class RubroDAO extends GenericDAO<Rubro>{
    public RubroDAO(Class<Rubro> clase, String file) throws Exception {
        super(clase, file);
    }

    public RubroDAO() throws Exception {
        super(Rubro.class, "./src/jsons/rubros.json");
    }
}
