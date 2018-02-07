package poo;

import java.text.SimpleDateFormat;
import java.util.*;

public class Factura 
        extends Albaran{
    private String observaciones;
    private FormaPago formaPago;
    private boolean estadoFactura;
    private double descuento;/*Se trata de un porcentaje de descuento respecto
    del importe total, dependiendo de la forma de pago o del coste total para el cliente*/

    //Tengamos en cuenta que no podemos crear una factura si no hay un albarán previo
    public Factura(String observaciones, FormaPago formaPago, Albaran alb) {
        super(alb.fecha, alb.numeroAlbaran, alb.listaCompra, alb.importeTotal, alb.cliente);
        this.estadoFactura = false;
        Calendar now = Calendar.getInstance();
        this.fecha = now;
        this.observaciones = observaciones;
        this.formaPago = formaPago;
        if ( this.formaPago.equals(FormaPago.contado) )
            this.descuento = 0.1;
        if ( this.importeTotal > 50 )
            this.descuento = this.descuento + 0.1;
        if ( this.importeTotal > 100 )
            this.descuento = this.descuento + 0.1;
        if ( this.importeTotal > 300 )
            this.descuento = this.descuento + 0.15;
        this.importeTotal -= this.importeTotal * this.descuento;
        Listar.listaFacturas.add(this);
    }

    public Factura() {
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

    public double getDescuento() {
        return descuento;
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

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        String estadoFac;
        if (isEstadoFactura())
            estadoFac="Pagada";
        else
            estadoFac="No pagada";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setCalendar(this.fecha);
        return "Fecha creacion de la factura: "+dateFormat.format(this.fecha.getTime())+
                "\tObservaciones: "+this.getObservaciones()+
                "\tForma de pago: "+this.getFormaPago().toString()+"\tEstado de la factura: "+
                estadoFac+"\tImporte total: "+this.importeTotal+"€"+
                "\tDescuento: "+this.descuento*100+"%"+"\tCliente: "+super.cliente+
                "\tLista de la Compra: "+super.listaCompra;
    }
    
    public String toString(Cliente cliente){
        String estadoFac;
        if (isEstadoFactura())
            estadoFac="Pagada";
        else
            estadoFac="No pagada";
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setCalendar(this.fecha);
        return "Fecha creacion de la factura: "+dateFormat.format(this.fecha.getTime())+
                "\tObservaciones: "+this.getObservaciones()+
                "\tForma de pago: "+this.getFormaPago().toString()+"\tEstado de la factura: "+
                estadoFac+"\tImporte total: "+this.importeTotal+"€"+
                "\tDescuento: "+this.descuento*100+"%"+
                "\tCrédito Restante del Cliente: "+cliente.getCredito()+"€";
    }
    
    
}
