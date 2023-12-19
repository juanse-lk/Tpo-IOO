package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuDocumentosUi extends  JFrame{
    private JPanel pnlMain;
    private JButton btnConsulta;
    private JButton btnBuscar;
    private JButton btnCrear;
    private JButton btnEliminar;
    private JButton libroIVACoprasButton;


    public MenuDocumentosUi(String titulo) throws Exception{
        super(titulo);

        this.setResizable(true);
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(pnlMain.getPreferredSize());
        this.setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.showAltaDocumentos();
        this.closeModule();

    }
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        MenuDocumentosUi self = new MenuDocumentosUi("Gestion de documentos");
    }

    void closeModule() {
        MenuDocumentosUi self = this;
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

    void showAltaDocumentos(){
        MenuDocumentosUi self = this;

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);
                try{
                    MenuAltaDocumentosUi d = new MenuAltaDocumentosUi("Menu alta de documentos");
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

    }

}
