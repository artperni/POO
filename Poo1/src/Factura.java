

import java.util.ArrayList;
import java.util.Date;

public class Factura extends Albaran {
    private String observaciones;
    private FormaPago formaPago;
    private boolean estadoFactura=false;

    public Factura(String observaciones, FormaPago formaPago, Date fechaCompra, int numero, ArrayList<Producto> listaCompra, double importeTotal, Cliente cliente) {
        super(fechaCompra, numero, listaCompra, cliente);
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
    
    
    
    
    
    
    
}
