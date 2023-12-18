package test;

import controllers.ControllerDocumentos;
import dto.ItemDTO;
import dto.FacturaDTO;
import org.junit.Before;
import org.junit.Test;
import models.Item;
import models.ProductoServicio;
import models.enums.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ControllerDocumentosTest {

    private ControllerDocumentos controllerDocumentos;

    @Before
    public void setUp() throws Exception {
        // Configuración inicial, podría incluir la inicialización del controlador si es necesario
        controllerDocumentos = ControllerDocumentos.getInstances();
    }

    @Test
    public void testAgregarFactura() throws Exception {
        // Datos de prueba
        int cuitProveedor = 123456789;  // Reemplaza con un valor de prueba real

        // Crear algunos items de prueba

        ProductoServicio producto1 = new ProductoServicio(Unidad.UNIDAD, 12, TipoIva.d, 12);
        Item item1 = new Item(3,producto1);
        Item item2 = new Item(10,producto1);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        // Ejecutar el método que estás probando
        controllerDocumentos.agregarFacturaTest(cuitProveedor, items);

        // Verificar el resultado o estado después de ejecutar el método
        List<FacturaDTO> facturas = controllerDocumentos.getAllFacturas();
        assertNotNull("La lista de facturas no debería ser nula", facturas);
        assertEquals("Debería haber una factura en la lista", 1, facturas.size());

        // Puedes realizar más verificaciones según la lógica específica de tu aplicación.
        FacturaDTO facturaDTO = facturas.get(0);
        assertNotNull("La factura DTO no debería ser nula", facturaDTO);
        // Añade más aserciones según la lógica de tu aplicación y los datos que deberían estar presentes en la factura DTO.
    }
}