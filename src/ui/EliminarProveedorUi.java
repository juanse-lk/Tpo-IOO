package ui;

import controllers.ControllerProovedores;
import dto.ProveedorDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import static java.lang.Integer.parseInt;

public class EliminarProveedorUi extends JFrame {
    private JPanel pnlMain;
    private JTextField txtCuit;
    private JButton btnEliminar;
    private JTable tblProveedores;
    private ControllerProovedores controllerProveedores;


    public EliminarProveedorUi(String titulo) throws Exception {
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
        this.eliminarProveedor();
        this.closeModule();


    }

    public Object[][] convertDtoToData(List<ProveedorDTO> lista) {
        Object[][] data = new Object[lista.size()][4];
        for (int i = 0; i < lista.size(); i++) {
            data[i][0] = lista.get(i).cuit;
            data[i][1] = lista.get(i).nombre;
            data[i][2] = lista.get(i).razonSocial;
        }
        return data;
    }

    void closeModule() {
        EliminarProveedorUi self = this;
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

    void eliminarProveedor(){
        EliminarProveedorUi self = this;
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cuitAEliminar = parseInt(txtCuit.getText());
                try {
                    controllerProveedores.eliminarProveedor(cuitAEliminar);
                    JOptionPane.showMessageDialog(self, "Se eliminó el proveedor", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarTabla();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    void cargarTabla(){
        Object[][] data = convertDtoToData(controllerProveedores.getAllProveedores());
        String[] columnas = new String[]{"CUIT", "Nombre", "Razón social"};
        tblProveedores.setModel(new DefaultTableModel(data, columnas));
    }

}
