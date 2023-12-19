package ui;

import controllers.ControllerDocumentos;
import dto.FilaLibroIvaDTO;
import dto.ProductoServicioDTO;
import models.enums.TipoDocumento;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.List;

public class DetalleLibroUi extends JFrame{
    private JPanel pnlMain;
    private JTable tblProductos;

    private ControllerDocumentos controllerDocumentos;

    public DetalleLibroUi(String titulo) throws Exception{
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
        DetalleLibroUi self = this;
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

    public Object[][] convertDtoToData(List<FilaLibroIvaDTO> lista){
        Object[][] data = new Object[lista.size()][10];
        for (int i = 0; i < lista.size(); i++) {
            data[i][0] = lista.get(i).cuit;
            data[i][1] = lista.get(i).nombre;
            data[i][2] = lista.get(i).fecha;
            data[i][3] = lista.get(i).tipoDoc;
            data[i][4] = lista.get(i).IVA_2_5;
            data[i][5] = lista.get(i).IVA_5;
            data[i][6] = lista.get(i).IVA_10_5;
            data[i][7] = lista.get(i).IVA_21;
            data[i][8] = lista.get(i).IVA_27;
            data[i][9] = lista.get(i).total;

        }
        return data;
    }
    void mostrarTabla(){
        Object[][] data = convertDtoToData(controllerDocumentos.obtenerLibroIva());
        String[] columnas = new String[]{"Cuit", "Nombre", "Fecha", "Tipo Documento", "Iva 2,5", "Iva 5", "Iva 10,5", "Iva 21", "Iva 27", "Total"};
        tblProductos.setModel(new DefaultTableModel(data, columnas));
    }
}
