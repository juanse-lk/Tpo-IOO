package ui;

import controllers.ControllerProovedores;
import dto.ProveedorDTO;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class DetalleProveedoresUi extends JFrame {

    private JPanel pnlProveedores;
    private JPanel pnlMain;
    private JTable tblProveedores;
    private ControllerProovedores controllerProveedores;

    public DetalleProveedoresUi(String titulo) throws Exception{
        super(titulo);

        this.setResizable(true);
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(pnlMain.getPreferredSize());
        this.setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        controllerProveedores = ControllerProovedores.getInstances();

        Object[][] data = convertDtoToData(controllerProveedores.getAllProveedores());
        String[] columnas = new String[]{"CUIT", "Nombre", "Razón social"};
        tblProveedores.setModel(new DefaultTableModel(data, columnas));

        this.closeModule();

    }

        public Object[][] convertDtoToData(List<ProveedorDTO> lista){
            Object[][] data = new Object[lista.size()][4];
            for (int i = 0; i < lista.size(); i++) {
                data[i][0] = lista.get(i).getCuit();
                data[i][1] = lista.get(i).getNombre();
                data[i][2] = lista.get(i).getRazonSocial();
            }
            return data;
        }

    void closeModule() {
        DetalleProveedoresUi self = this;
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

    }
