package models;
import models.enums.TipoCheque;
import java.util.Date;

public class Cheque extends FormaPago{

    // Atributos propios de Cheque

    private TipoCheque tipoCheque;
    private Date fechaEmision;
    private Date fechaVencimiento;


    // Constructor
    // Metodo que tiene una clase que instancia al objeto
    // Incluye los atributos de FormaPago(usando super) y Cheque (usando this.)
    public Cheque(float importe, TipoCheque tipoCheque, Date fechaEmision, Date fechaVencimiento) {
        super(importe);
        this.tipoCheque = tipoCheque;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
    }
}
