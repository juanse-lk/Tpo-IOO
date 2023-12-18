package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuProveedoresUi extends JFrame {
    private JPanel pnlMain;
    private JButton btnConsulta;
    private JButton btnBuscar;
    private JButton btnAlta;
    private JButton btnEliminar;

    public MenuProveedoresUi(String titulo) throws Exception{
        super(titulo);

        this.setResizable(true);
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(pnlMain.getPreferredSize());
        this.setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.showDetalleProveedoresModule();
        this.showAltaProveedor();
        this.showBusquedaProveedor();
        this.showEliminarProveedor();

        this.closeModule();

    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        MenuProveedoresUi self = new MenuProveedoresUi("Gestion de proveedores");
    }


    void closeModule() {
        MenuProveedoresUi self = this;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    MenuPrincipal m = null;
                    m = new MenuPrincipal("Main");
                    m.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    void showDetalleProveedoresModule(){
        MenuProveedoresUi self = this;

        btnConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);
                try{
                    DetalleProveedoresUi d = new DetalleProveedoresUi("Detalle Proveedores");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    void showAltaProveedor(){
        MenuProveedoresUi self = this;

        btnAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);
                try{
                    AltaProveedorUi d = new AltaProveedorUi("Alta de proveedor");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    void showBusquedaProveedor(){
        MenuProveedoresUi self = this;

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);
                try{
                    BusquedaProveedoresUi d = new BusquedaProveedoresUi("Busqueda de proveedor");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    void showEliminarProveedor(){
        MenuProveedoresUi self = this;

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);
                try{
                    EliminarProveedorUi d = new EliminarProveedorUi("Eliminar proveedor");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

}
