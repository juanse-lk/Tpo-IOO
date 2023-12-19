package ui;

import controllers.ControllerProovedores;
import dto.ProductoServicioDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static java.lang.Integer.parseInt;

public class EliminarProductoUi extends JFrame{
    private JPanel pnlMain;
    private JTextField txtId;
    private JButton btnEliminar;
    private JTable tblProductos;

    private ControllerProovedores controllerProveedores;

    public EliminarProductoUi(String titulo) throws Exception{
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
        this.eliminarProducto();
    }

    public Object[][] convertDtoToData(List<ProductoServicioDTO> lista){
        Object[][] data = new Object[lista.size()][5];
        for (int i = 0; i < lista.size(); i++) {
            data[i][0] = lista.get(i).idProductoServicio;
            data[i][1] = lista.get(i).unidad;
            data[i][2] = lista.get(i).precioUnidad;
            data[i][3] = lista.get(i).proveedor.getCuit();
        }
        return data;
    }
    void mostrarTabla(){
        Object[][] data = convertDtoToData(controllerProveedores.getAllProductoServicio());
        String[] columnas = new String[]{"Id", "Unidad", "Precio por unidad", "CUIT proveedor"};
        tblProductos.setModel(new DefaultTableModel(data, columnas));
    }


    void eliminarProducto(){
        EliminarProductoUi self = this;
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idAEliminar = parseInt(txtId.getText());
                try {
                    controllerProveedores.eliminarProducto(idAEliminar);
                    JOptionPane.showMessageDialog(self, "Se eliminó el producto", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    mostrarTabla();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
}
