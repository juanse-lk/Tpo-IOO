package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuPrincipal extends JFrame{
    private JPanel pnlMain;
    private JPanel pnlHeader;
    private JButton btnProveedores;
    private JButton btnProductos;
    private JButton documentosButton;
    private JButton proveedoresButton2;

    public MenuPrincipal(String titulo) throws Exception{
        super(titulo);

        this.setResizable(true);
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(pnlMain.getPreferredSize());
        this.setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.showProveedoresModule();
        this.showProductosModule();

        this.closeModule();
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        MenuPrincipal self = new MenuPrincipal("Factura 2000");
    }

    void showProveedoresModule() {
        MenuPrincipal self = this;
        btnProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);
                try {
                    MenuProveedoresUi p = new MenuProveedoresUi("Proveedores");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    void showProductosModule() {
        MenuPrincipal self = this;
        btnProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);
                try {
                    MenuProductosUi p = new MenuProductosUi("Productos");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }


    void closeModule() {
        MenuPrincipal self = this;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                self.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
    }

}
