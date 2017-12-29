package poo;

import java.util.*;

/*Vamos a tener en cuenta que no tiene sentido instanciar una Unidad
que no está vinculada a un producto*/
public class Unidad extends Producto{
    private Estado estado;
    private Calendar fechaCaducidad;
    private final int numero;

    public Unidad(Estado estado, Calendar fechaCaducidad, String referencia,
            Dimensiones dimensiones, double precioCompra, double descuento) {
        super(referencia, dimensiones, precioCompra, descuento);
        this.estado = estado;
        this.fechaCaducidad = fechaCaducidad;
        this.numero = super.getListaUnidades().indexOf(this);
        /*Este numero indica la posicion de la unidad en el producto*/
    }

    public Estado getEstado() {
        return estado;
    }

    public Calendar getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setFechaCaducidad(Calendar fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
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
        return "Numero de la Unidad: "+this.numero+"Estado: "+this.estado+"\tFecha de Caducidad: "+this.fechaCaducidad;
    }
    

}
