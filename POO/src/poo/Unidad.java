package poo;

import java.util.*;


public class Unidad {
    private Estado estado;
    private Calendar fechaCaducidad;
    private int numero;
    private Producto producto;

    public Unidad(Estado estado, Calendar fechaCaducidad, Producto producto) {
        this.estado = estado;
        this.fechaCaducidad = fechaCaducidad;
        this.producto = producto;
        this.numero = this.producto.getListaUnidades().indexOf(this);
        /*Este numero indica la posicion de la unidad en el producto*/
        this.producto.anadirUnidad(this);
        this.producto.actualizar();
    }

    public Unidad() {
    }
    
    
    

    public Estado getEstado() {
        return estado;
    }

    public Calendar getFechaCaducidad() {
        return fechaCaducidad;
    }

    public int getNumero() {
        return numero;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setFechaCaducidad(Calendar fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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

    @Override
    public String toString() {
        return "Numero de la Unidad: "+this.numero+"Estado: "+this.estado+"\tFecha de Caducidad: "+this.fechaCaducidad.getTime().toString();
    }
    

}
