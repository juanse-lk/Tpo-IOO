package ui;

import controllers.ControllerProovedores;
import dto.ProductoServicioDTO;
import dto.ProveedorDTO;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class BuscarProductosUi extends JFrame{
    private JPanel pnlMain;
    private JTextField txtId;
    private JButton btnLimpiar;
    private JButton btnBuscar;
    private JTable tblProductos;

    private ControllerProovedores controllerProveedores;

    public BuscarProductosUi(String titulo) throws Exception{
        super(titulo);

        this.setResizable(true);
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(pnlMain.getPreferredSize());
        this.setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        controllerProveedores = ControllerProovedores.getInstances();

        this.mostrarTabla();
        this.filtrarProductos();
        this.limpiarResultados();
        this.closeModule();

    }
    public Object[][] convertDtoToData(List<ProductoServicioDTO> lista){
        Object[][] data = new Object[lista.size()][6];
        for (int i = 0; i < lista.size(); i++) {
            data[i][0] = lista.get(i).idProductoServicio;
            data[i][1] = lista.get(i).unidad;
            data[i][2] = lista.get(i).precioUnidad;
            data[i][3] = lista.get(i).proveedor.getCuit();
            data[i][4] = lista.get(i).rubro.getIdRubro();
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        BuscarProductosUi self = new BuscarProductosUi("Buscar producto por id");
    }
    void closeModule() {
        BuscarProductosUi self = this;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    MenuProductosUi p = null;
                    p = new MenuProductosUi("Productos");
                    p.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    void filtrarProductos(){
        BuscarProductosUi self = this;
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idBuscado = parseInt(txtId.getText());
                List<ProductoServicioDTO> productos = controllerProveedores.getAllProductoServicio();
                List<ProductoServicioDTO> productosFiltrados = filtrarProductos(productos, idBuscado);
                Object[][] dataFiltrada = convertDtoToData(productosFiltrados);

                DefaultTableModel modelo = new DefaultTableModel(dataFiltrada, new String[]{"Id", "Unidad", "Precio por unidad", "CUIT proveedor", "Rubro"});
                tblProductos.setModel(modelo);

            }
        });
    }
    public List<ProductoServicioDTO> filtrarProductos(List<ProductoServicioDTO> productos, int id) {
        List<ProductoServicioDTO> filtrados = new ArrayList<>();
        for (ProductoServicioDTO producto : productos) {
            if (producto.idProductoServicio == id) {
                filtrados.add(producto);
            }
        }
        return filtrados;
    }
    void mostrarTabla(){
        Object[][] data = convertDtoToData(controllerProveedores.getAllProductoServicio());
        String[] columnas = new String[]{"Id", "Unidad", "Precio por unidad", "CUIT proveedor", "Rubro"};
        tblProductos.setModel(new DefaultTableModel(data, columnas));
    }

    void limpiarResultados(){
        BuscarProductosUi self = this;
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTabla();
            }
        });
    }




}