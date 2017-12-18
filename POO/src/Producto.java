
import java.util.*;


public class Producto {
    private String referencia;
    private int stock;
    private Dimensiones dimensiones;
    private Estado estado;
    private double precioCompra;
    private double descuento;
    private Date fechaCaducidad;
    private final double precioVenta;
    
    
    
    public Producto(String referencia, int stock, Dimensiones dimensiones, Estado estado, double precioCompra, double descuento, Date fechaCaducidad) {
        this.referencia = referencia;
        this.stock = stock;
        this.dimensiones = dimensiones;
        this.estado = estado;
        this.precioCompra = precioCompra;
        this.descuento = descuento;
        this.fechaCaducidad = fechaCaducidad;
        this.precioVenta = precioCompra+precioCompra/2-descuento;
    }
    

    public String getReferencia() {
        return referencia;
    }

    public int getStock() {
        return stock;
    }

    public Dimensiones getDimensiones() {
        return dimensiones;
    }

    public Estado getEstado() {
        return estado;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public double getDescuento() {
        return descuento;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDimensiones(Dimensiones dimensiones) {
        this.dimensiones = dimensiones;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "Referencia: "+this.referencia+"\tNumero de producto: "+this.stock+
                "\tDimensiones: "+this.dimensiones.toString()+"\tEstado producto: "+
                this.estado.toString()+"\tFecha de caducidad: "+this.fechaCaducidad+
                "\tPrecio: "+this.precioVenta+"€";
    }


    
    
    
    
    
    
}