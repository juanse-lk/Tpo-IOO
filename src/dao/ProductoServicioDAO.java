package dao;

import models.Factura;
import models.ProductoServicio;
import utils.GenericDAO;

public class ProductoServicioDAO extends GenericDAO<ProductoServicio>{

    public ProductoServicioDAO() throws Exception {
        super(ProductoServicio.class, "./src/jsons/productoServicio.json");
    }
}
