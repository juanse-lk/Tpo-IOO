package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuAltaDocumentosUi extends JFrame{
    private JPanel pnlMain;
    private JButton btnCargaFactura;
    private JButton btnCargaNc;
    private JButton btnCargaNd;
    private JButton btnCargaOrdenCompra;
    private JButton btnCargaOrdenPago;

    public MenuAltaDocumentosUi(String titulo) throws Exception {
        super(titulo);

        this.setResizable(true);
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(pnlMain.getPreferredSize());
        this.setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        this.closeModule();
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        MenuAltaDocumentosUi self = new MenuAltaDocumentosUi("Alta de documentos");
    }


    void closeModule() {
        MenuAltaDocumentosUi self = this;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    MenuDocumentosUi m = null;
                    m = new MenuDocumentosUi("Menu documentos");
                    m.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
