package poo;


import java.util.*;


public class Producto {
    private String referencia;
    private int stock;
    private Dimensiones dimensiones;
    private Estado estado;
    private double precioCompra;
    private double descuento;
    private Calendar fechaCaducidad;
    private final double precioVenta;
    
    
    
    public Producto(String referencia, int stock, Dimensiones dimensiones, Estado estado, double precioCompra, double descuento, Calendar fechaCaducidad) {
        this.referencia = referencia;
        this.stock = stock;
        this.dimensiones = dimensiones;
        this.estado = estado;
        this.precioCompra = precioCompra;
        this.descuento = descuento;
        this.fechaCaducidad = fechaCaducidad;
        this.precioVenta = precioCompra+precioCompra/2-descuento;
        Listar.listaProductosTotal.add(this);
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

    public Calendar getFechaCaducidad() {
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

    public void setFechaCaducidad(Calendar fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public String toString() {
        return "Referencia: "+this.referencia+"\tNumero de producto: "+this.stock+
                "\tDimensiones: "+this.dimensiones.toString()+"\tEstado producto: "+
                this.estado.toString()+"\tFecha de caducidad: "+this.fechaCaducidad+
                "\tPrecio: "+this.precioVenta+"€";
    }

    
    
    
    
    public boolean isCaducado(Calendar ahora){
        return ahora.after(this.fechaCaducidad);
    }
    
    public boolean isCaducado(){
        Calendar fechaActual = Calendar.getInstance();
        return isCaducado(fechaActual);
    }
    
    public boolean isCaducado(int dias){
        Calendar fechaActual = Calendar.getInstance();
        fechaActual.set(Calendar.DAY_OF_MONTH, dias);//Damos unos días de margen a elección
        return isCaducado(fechaActual);
    }
    
    public boolean isLibre(){
        return this.estado.name().equals("libre");
    }
    
    public boolean isVendido(){
           return this.estado.name().equals("vendido");
    }
    
    public boolean isReservado(){
           return this.estado.name().equals("reservado");
    }

    
    
    
    
    
    
}