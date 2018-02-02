package poo;

import java.util.*;

/*Vamos a tener en cuenta que no tiene sentido instanciar una Unidad
que no está vinculada a un producto*/
public class Unidad extends Producto{
    private Estado estado;
    private Calendar fechaCaducidad;
    private int numero;

    public Unidad(Estado estado, Calendar fechaCaducidad, Producto p1) {
        super(p1.getReferencia(), p1.getDimensiones(), p1.getPrecioCompra(), p1.getDescuento());
        this.estado = estado;
        this.fechaCaducidad = fechaCaducidad;
        this.numero = p1.getListaUnidades().indexOf(this);
        /*Este numero indica la posicion de la unidad en el producto*/
        p1.anadirUnidad(this);
        p1.actualizar();
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

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setFechaCaducidad(Calendar fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
