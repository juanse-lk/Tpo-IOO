package ui;

import controllers.ControllerProovedores;
import dto.ProveedorDTO;
import dto.RubroDTO;
import models.ProductoServicio;

import javax.naming.ldap.Control;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class DetalleRubrosUi extends JFrame{
    private JPanel pnlMain;
    private JButton btnAgregar;
    private JTextField txtIdRubro;
    private JTextField txtNombreRubro;
    private JTable tblRubro;

    private ControllerProovedores controllerProveedores;

    public DetalleRubrosUi(String titulo) throws Exception{
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


        this.mostrarTabla();
        this.agregarRubro();
        this.closeModule();



    }

    void closeModule() {
        DetalleRubrosUi self = this;
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
    public Object[][] convertDtoToData(List<RubroDTO> lista){
        Object[][] data = new Object[lista.size()][4];
        for (int i = 0; i < lista.size(); i++) {
            data[i][0] = lista.get(i).idRubro;
            data[i][1] = lista.get(i).nombreRubro;
        }
        return data;
    }

    void mostrarTabla() {
        Object[][] data = convertDtoToData(controllerProveedores.getAllRubros());
        String[] columnas = new String[]{"idRubro", "Nombre"};
        tblRubro.setModel(new DefaultTableModel(data, columnas));
    }

    void agregarRubro(){
        DetalleRubrosUi self = this;
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<ProductoServicio> listaProductoServicio = new ArrayList<>();

                RubroDTO nuevoRubro = null;
                try{
                    nuevoRubro = new RubroDTO(
                            Integer.parseInt(txtIdRubro.getText()),
                            txtNombreRubro.getText(),
                            listaProductoServicio
                    );
                }catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                try{
                    ControllerProovedores.crearRubro(nuevoRubro);
                }catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                mostrarTabla();
                txtIdRubro.setText("");
                txtNombreRubro.setText("");
            }
        });
    }

}
