package dao;

import models.ProductoServicio;
import utils.GenericDAO;

public class ProductoServicioDAO extends GenericDAO<ProductoServicio>{

    public ProductoServicioDAO(Class<ProductoServicio> clase, String file) throws Exception {
        super(clase, file);
    }
}
