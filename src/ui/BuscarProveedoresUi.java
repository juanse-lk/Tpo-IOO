package ui;

import controllers.ControllerProovedores;
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

public class BuscarProveedoresUi extends JFrame {
    private JTextField txtCuit;
    private JPanel pnlMain;
    private JButton btnBuscar;
    private JTable tblProveedores;
    private JButton btnLimpiar;

    private ControllerProovedores controllerProveedores;


    public BuscarProveedoresUi(String titulo) throws Exception {
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

        Object[][] data = convertDtoToData(controllerProveedores.getAllProveedores());
        String[] columnas = new String[]{"CUIT", "Nombre", "Razón social"};
        tblProveedores.setModel(new DefaultTableModel(data, columnas));

        this.filtrarProveedores();
        this.limpiarResultados();
        this.closeModule();

    }
    public Object[][] convertDtoToData(List<ProveedorDTO> lista){
        Object[][] data = new Object[lista.size()][4];
        for (int i = 0; i < lista.size(); i++) {
            data[i][0] = lista.get(i).cuit;
            data[i][1] = lista.get(i).nombre;
            data[i][2] = lista.get(i).razonSocial;
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        BuscarProveedoresUi self = new BuscarProveedoresUi("Buscar proveedor por cuit");
    }

    void closeModule() {
        BuscarProveedoresUi self = this;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    MenuProveedoresUi p = null;
                    p = new MenuProveedoresUi("Proveedores");
                    p.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    void filtrarProveedores(){
        BuscarProveedoresUi self = this;
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cuitBuscado = parseInt(txtCuit.getText());
                List<ProveedorDTO> proveedores = controllerProveedores.getAllProveedores();
                List<ProveedorDTO> proveedoresFiltrados = filtrarProveedores(proveedores, cuitBuscado);
                Object[][] dataFiltrada = convertDtoToData(proveedoresFiltrados);

                DefaultTableModel modelo = new DefaultTableModel(dataFiltrada, new String[]{"CUIT", "Nombre", "Razón social"});
                tblProveedores.setModel(modelo);

            }
        });
    }

    public List<ProveedorDTO> filtrarProveedores(List<ProveedorDTO> proveedores, int cuit) {
        List<ProveedorDTO> filtrados = new ArrayList<>();
        for (ProveedorDTO proveedor : proveedores) {
            if (proveedor.cuit == cuit) {
                filtrados.add(proveedor);
            }
        }
        return filtrados;
    }

    void limpiarResultados(){
        BuscarProveedoresUi self = this;
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTablaOriginal();
            }
        });
    }

    public void mostrarTablaOriginal(){
        Object[][] data = convertDtoToData(controllerProveedores.getAllProveedores());
        DefaultTableModel modelo = new DefaultTableModel(data, new String[]{"CUIT", "Nombre", "Razón social"});
        tblProveedores.setModel(modelo);
    }
}
