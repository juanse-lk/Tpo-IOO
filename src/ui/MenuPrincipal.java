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
    private JButton proveedoresButton;
    private JButton proveedoresButton1;
    private JButton proveedoresButton2;

    public MenuPrincipal(String titulo) throws Exception{
        super(titulo);

        //region Settings
        this.setResizable(true);
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(pnlMain.getPreferredSize());
        this.setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        //endregion

        //region Register Modules
        this.showProveedoresModule();
        //endregion

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
                    ProveedoresUi p = new ProveedoresUi("Proveedores");
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
