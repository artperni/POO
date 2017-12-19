package poo;



import java.util.*;

public class Factura extends Albaran {
    private String observaciones;
    private FormaPago formaPago;
    private boolean estadoFactura=false;

    //Tengamos en cuenta que no podemos crear una factura si no hay un albarán previo
    public Factura(String observaciones, FormaPago formaPago) {
        Calendar now = Calendar.getInstance();
        super.setFecha(now.getTime());
        this.observaciones = observaciones;
        this.formaPago = formaPago;
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

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public void setEstadoFactura(boolean estadoFactura) {
        this.estadoFactura = estadoFactura;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
