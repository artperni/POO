package poo;

import java.text.SimpleDateFormat;
import java.util.*;


public class Unidad {
    private Estado estado;
    private Calendar fechaCaducidad;
    private Producto producto;

    public Unidad(Calendar fechaCaducidad, Producto producto) {
        this.estado = Estado.libre;
        this.fechaCaducidad = (Calendar)fechaCaducidad.clone();
        this.producto = producto;
    }

    public Unidad() {
    }
    
    
    

    public Estado getEstado() {
        return estado;
    }

    public Calendar getFechaCaducidad() {
        return fechaCaducidad;
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
        if ( isCaducado() )
            return false;
        Calendar fechaActual = Calendar.getInstance();
        fechaActual.add(Calendar.DATE, dias);//Damos unos días de margen a elección
        return isCaducado(fechaActual);
    }
    
    public boolean isLibre(){
        return this.estado.equals(Estado.libre);
    }
    
    public boolean isVendido(){
           return this.estado.equals(Estado.vendido);
    }
    
    public boolean isReservado(){
           return this.estado.equals(Estado.reservado);
    }
    
    public void eliminarUnidad(){
        this.producto.getListaUnidades().remove(this);
        this.producto.actStock();
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return "Posicion: "+this.producto.getListaUnidades().indexOf(this)+"\tEstado: "+this.estado+"\tFecha de Caducidad: "+
                dateFormat.format(this.fechaCaducidad.getTime());
    }

}
