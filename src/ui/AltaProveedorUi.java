package ui;

import controllers.ControllerProovedores;
import dto.ProveedorDTO;
import models.*;
import models.enums.ResponsabilidadIva;

import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Integer.valueOf;


public class AltaProveedorUi extends JFrame{
    private JPanel pnlMain;
    private JTextField txtCuit;
    private JComboBox cmbRespIva;
    private JTextField txtRazSocial;
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtTel;
    private JTextField txtCorreo;
    private JButton btnAgregar;
    private JComboBox cmbRetenciones;

    private ControllerProovedores controllerProovedores = ControllerProovedores.getInstances();

    public AltaProveedorUi(String titulo) throws Exception{
        super(titulo);

        this.setResizable(true);
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(pnlMain.getPreferredSize());
        this.setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        cmbRespIva.setModel(new DefaultComboBoxModel<ResponsabilidadIva>(ResponsabilidadIva.values()));

        this.agregarProveedor();
        this.closeModule();
    }

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        AltaProveedorUi self = new AltaProveedorUi("Alta de proveedor");
    }
    void closeModule() {
        AltaProveedorUi self = this;
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

    void agregarProveedor(){
        AltaProveedorUi self = this;
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);

                boolean certificadosRetencion = false;
                String certificado = Objects.requireNonNull(cmbRetenciones.getSelectedItem()).toString();
                if (certificado == "Si")
                    certificadosRetencion = true;

                ResponsabilidadIva respIva;
                String responsabilidad = cmbRespIva.getSelectedItem().toString();
                if (responsabilidad == "Responsable Inscripto")
                    respIva = ResponsabilidadIva.RESPONSABLEINSCRIPTO;
                else
                    respIva = ResponsabilidadIva.MONOTRIBUTO;

                String numIngresosBrutos;
                Date inicioActividades = new Date();
                float montoAdeudadoMaximo;

                List<Rubro> rubros = new ArrayList<>();
                List<Factura> listaFacturas = new ArrayList<>();
                List<NotaDebito> listaNotasDebito = new ArrayList<>();
                List<NotaCredito> listaNotasCredito = new ArrayList<>();
                List<ProductoServicio> listaProductoServicio = new ArrayList<>();

                ProveedorDTO nuevoProveedor = null;
                try {
                    nuevoProveedor = new ProveedorDTO(
                            Integer.parseInt(txtCuit.getText()),
                            respIva,
                            txtRazSocial.getText(),
                            txtNombre.getText(),
                            txtDireccion.getText(),
                            txtTel.getText(),
                            txtCorreo.getText(),
                            numIngresosBrutos = txtCuit.getText() + "123",
                            inicioActividades,
                            montoAdeudadoMaximo = 10000,
                            certificadosRetencion,
                            rubros,
                            listaFacturas,
                            listaNotasDebito,
                            listaNotasCredito,
                            listaProductoServicio);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    ControllerProovedores.crearProveedor(nuevoProveedor);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }

        });
        }

}
