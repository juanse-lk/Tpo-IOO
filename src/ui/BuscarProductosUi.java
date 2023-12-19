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

        this.cargarTabla();
        this.closeModule();

    }
    public Object[][] convertDtoToData(List<ProductoServicioDTO> lista) {
        Object[][] data = new Object[lista.size()][4];
        for (int i = 0; i < lista.size(); i++) {
            data[i][0] = lista.get(i).unidad;
            data[i][1] = lista.get(i).precioUnidad;
            data[i][2] = lista.get(i).tipoIva;
            data[i][3] = lista.get(i).idProductoServicio;
            data[i][4] = lista.get(i).rubro;
        }
        return data;
    }
    void cargarTabla(){
        Object[][] data = convertDtoToData(controllerProveedores.getAllProductoServicio());
        String[] columnas = new String[]{"CUIT", "Nombre", "Razón social"};
        tblProductos.setModel(new DefaultTableModel(data, columnas));
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
}
