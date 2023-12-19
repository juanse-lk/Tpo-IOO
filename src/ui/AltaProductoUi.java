package ui;

import controllers.ControllerProovedores;
import dto.ProductoServicioDTO;
import dto.ProveedorDTO;
import models.Proveedor;
import models.Rubro;
import models.enums.Unidad;
import models.enums.TipoIva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;


public class AltaProductoUi extends JFrame{
    private JPanel pnlMain;
    private JButton btnAgregar;
    private JTextField txtId;
    private JComboBox cmbProveedores;
    private JComboBox cmbUnidad;
    private JComboBox cmbIva;
    private JComboBox cmbRubro;
    private JTextField txtPrecio;

    private ControllerProovedores controllerProovedores = ControllerProovedores.getInstances();

    public AltaProductoUi(String titulo) throws Exception{
        super(titulo);

        this.setResizable(true);
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(pnlMain.getPreferredSize());
        this.setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        cmbIva.setModel(new DefaultComboBoxModel<TipoIva>(TipoIva.values()));
        cmbIva.setModel(new DefaultComboBoxModel<Unidad>(Unidad.values()));


        ArrayList<Integer> proveedoresCuit = controllerProovedores.getAllProveedoresCuit();
        Integer[] arrayCuit = proveedoresCuit.toArray(new Integer[0]);
        cmbProveedores.setModel(new DefaultComboBoxModel<>(arrayCuit));

        ArrayList<Integer> rubros = controllerProovedores.getAllRubrosId();
        Integer[] arrayRubros = rubros.toArray(new Integer[0]);
        cmbRubro.setModel(new DefaultComboBoxModel<>(arrayRubros));

        List<Float> listaIva = new ArrayList<>(List.of(0.025f,0.05f,0.105f,0.21f,0.27f));
        Float[] arrayIva = listaIva.toArray(new Float[0]);
        cmbIva.setModel(new DefaultComboBoxModel<>(arrayIva));



        this.agregarProducto();
        this.closeModule();
    }

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        AltaProveedorUi self = new AltaProveedorUi("Alta de producto");
    }
    void closeModule() {
        AltaProductoUi self = this;
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

    void agregarProducto(){
        AltaProductoUi self = this;

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Unidad unidad;
                String uni = cmbUnidad.getSelectedItem().toString();
                if(uni == "Unidad")
                    unidad = Unidad.UNIDAD;
                else if(uni == "Peso")
                    unidad = Unidad.PESO;
                else
                    unidad = Unidad.HORA;

                TipoIva tipoIva;
                String tipo = cmbIva.getSelectedItem().toString();
                if(tipo == "0.025")
                    tipoIva = TipoIva.a;
                else if(tipo == "0.05")
                    tipoIva = TipoIva.b;
                else if(tipo == "0.105")
                    tipoIva = TipoIva.c;
                else if(tipo == "0.21")
                    tipoIva = TipoIva.d;
                else
                    tipoIva = TipoIva.e;


                int cuitSeleccionado = parseInt(cmbProveedores.getSelectedItem().toString());
                Proveedor proveedor = controllerProovedores.obtenerProveedorPorCuit(cuitSeleccionado);

                int idRubroSeleccionado = parseInt(cmbRubro.getSelectedItem().toString());
                Rubro rubro = controllerProovedores.obtenerRubroPorId(idRubroSeleccionado);


                ProductoServicioDTO nuevoProductoServicio = null;
                try{
                    nuevoProductoServicio = new ProductoServicioDTO(
                            unidad,
                            Float.parseFloat(txtPrecio.getText()),
                            tipoIva,
                            parseInt(txtId.getText()),
                            proveedor,
                            rubro);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                try{
                    if(!ControllerProovedores.existeProducto(nuevoProductoServicio.idProductoServicio, nuevoProductoServicio.proveedor.getCuit() )){
                        ControllerProovedores.crearProducto(nuevoProductoServicio);
                        JOptionPane.showMessageDialog(self, "Se agregó el producto", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(self, "El proveedor ya existe", "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                txtId.setText("");
                cmbProveedores.setSelectedIndex(-1);
                cmbProveedores.setSelectedIndex(-1);
                cmbUnidad.setSelectedIndex(-1);
                txtPrecio.setText("");
                cmbIva.setSelectedIndex(-1);
                cmbRubro.setSelectedIndex(-1);

            }
        });
    }



}
