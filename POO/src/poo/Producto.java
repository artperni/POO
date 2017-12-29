package poo;


import java.util.*;


public class Producto {
    private String referencia;
    private final int stock;
    private Dimensiones dimensiones;
    private double precioCompra;
    private double descuento;
    private final double precioVenta;
    private ArrayList <Unidad> listaUnidades;
    
    
    
    public Producto(String referencia, Dimensiones dimensiones, double precioCompra, double descuento) {
        this.referencia = referencia;
        this.stock = listaUnidades.size();
        this.dimensiones = dimensiones;
        this.precioCompra = precioCompra;
        this.descuento = descuento;
        this.precioVenta = precioCompra+precioCompra/2-descuento;
        this.listaUnidades = new ArrayList <> ();
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

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public double getDescuento() {
        return descuento;
    }

    public ArrayList<Unidad> getListaUnidades() {
        return listaUnidades;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    public void setDimensiones(Dimensiones dimensiones) {
        this.dimensiones = dimensiones;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setListaUnidades(ArrayList<Unidad> listaUnidades) {
        this.listaUnidades = listaUnidades;
    }
    
    

    @Override
    public String toString() {
        return "Referencia: "+this.referencia+"\tNumero de producto: "+this.stock+
                "\tDimensiones: "+this.dimensiones.toString()+
                "\tPrecio: "+this.precioVenta+"€"+listaUnidades.toString();
    }

    
    
    
    
    public void anadirUnidad(Unidad unidad){
        this.listaUnidades.add(unidad);
    }
    
    public void anadirUnidades(ArrayList <Unidad> listaunidades){
        for (Unidad unidad : listaunidades)
            anadirUnidad(unidad);
    }
    
    public void eliminarUnidad(Unidad unidad){
        this.listaUnidades.remove(unidad);
    }
    
    public void eliminarUnidades(ArrayList <Unidad> listaunidades){
        for (Unidad unidad : listaunidades)
            eliminarUnidad(unidad);
    }
    
    public boolean isVacio(){
        return this.listaUnidades.isEmpty();
    }
    
    
}