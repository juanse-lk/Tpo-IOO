package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuProductosUi extends JFrame{
    private JPanel pnlMain;
    private JButton btnConsulta;
    private JButton btnBuscar;
    private JButton btnCrear;
    private JButton btnEliminar;
    private JButton btnRubros;

    public MenuProductosUi(String titulo) throws Exception{
        super(titulo);

        this.setResizable(true);
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(pnlMain.getPreferredSize());
        this.setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.showDetalleProductosModule();
        this.showBuscarProducto();
        this.ShowAltaProducto();
        this.ShowDetalleRubros();
        this.closeModule();
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        MenuProductosUi self = new MenuProductosUi("Gestion de productos");
    }

    void closeModule() {
        MenuProductosUi self = this;
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

    void showDetalleProductosModule(){
        MenuProductosUi self = this;

        btnConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);
                try{
                    DetalleProductosUi d = new DetalleProductosUi("Detalle Productos");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    void showBuscarProducto(){
        MenuProductosUi self = this;

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);
                try{
                    BuscarProductosUi d = new BuscarProductosUi("Buscar producto por id");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    void ShowAltaProducto(){
        MenuProductosUi self = this;

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);
                try{
                    AltaProductoUi a = new AltaProductoUi("Crear producto");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    void ShowDetalleRubros(){
        MenuProductosUi self = this;

        btnRubros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);
                try{
                    DetalleRubrosUi a = new DetalleRubrosUi("Detalle Rubros");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }


}
