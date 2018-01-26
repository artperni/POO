package poo;

import java.util.*;

public class Factura 
        extends Albaran{
    private String observaciones;
    private FormaPago formaPago;
    private boolean estadoFactura=false;
    private Calendar fechaFactura;
    private IPersistence objDac;

    //Tengamos en cuenta que no podemos crear una factura si no hay un albarán previo
    public Factura(String observaciones, FormaPago formaPago, ArrayList<Unidad> listaCompra, Cliente cliente) {
        super(cliente);
        Calendar now = Calendar.getInstance();
        this.fechaFactura = now;
        this.observaciones = observaciones;
        this.formaPago = formaPago;
        Listar.listaFacturas.add(this);
        this.objDac = new FacturaDAC();
    }

    public Factura() {
        super(null);
    }
    
    
    
    
    public String getObservaciones() {
        return observaciones;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public boolean isEstadoFactura() {
        return estadoFactura;
    }

    public Calendar getFechaFactura() {
        return fechaFactura;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public void setEstadoFactura(boolean estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    public void setFechaFactura(Calendar fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    @Override
    public String toString() {
        String estadoFac;
        if (isEstadoFactura())
            estadoFac="Pagada";
        else
            estadoFac="No pagada";
        return super.toString()+"\nObservaciones: "+this.getObservaciones()+
                "\nForma de pago: "+this.getFormaPago().toString()+"Estado de la factura: "+
                estadoFac;
    }
    
    
    
}
