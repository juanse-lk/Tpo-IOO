package ui;

import controllers.ControllerDocumentos;
import dto.FacturaDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class DetalleDocumentosUi extends JFrame{
    private JPanel pnlMain;
    private JTable tblFacturas;

    private ControllerDocumentos controllerDocumentos;

    public DetalleDocumentosUi(String titulo) throws Exception{
        super(titulo);

        this.setResizable(true);
        this.setContentPane(this.pnlMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
        this.setSize(pnlMain.getPreferredSize());
        this.setBackground(Color.WHITE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        controllerDocumentos = ControllerDocumentos.getInstances();

        this.mostrarTabla();
        this.closeModule();
    }

    void closeModule() {
        DetalleDocumentosUi self = this;
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    MenuDocumentosUi p = null;
                    p = new MenuDocumentosUi("Documentos");
                    p.setVisible(true);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
    public Object[][] convertDtoToData(List<FacturaDTO> lista){
        Object[][] data = new Object[lista.size()][5];
        for (int i = 0; i < lista.size(); i++) {
            data[i][0] = lista.get(i).idDocuemento;
            data[i][1] = lista.get(i).fecha;
            data[i][2] = lista.get(i).monto;
        }
        return data;
    }

    void mostrarTabla(){
        Object[][] data = convertDtoToData(controllerDocumentos.getAllFacturas());
        String[] columnas = new String[]{"Id Factura", "Fecha", "Monto"};
        tblFacturas.setModel(new DefaultTableModel(data, columnas));
    }

}
