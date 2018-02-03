package poo;


import java.util.*;


public class Producto {
    private String referencia;
    private int stock;
    private Dimensiones dimensiones;
    private double precioCompra;
    private final double precioVenta;
    private ArrayList <Unidad> listaUnidades;
    
    
    
    public Producto(String referencia, Dimensiones dimensiones, double precioCompra) {
        this.referencia = referencia;
        this.dimensiones = dimensiones;
        this.precioCompra = precioCompra;
        this.precioVenta = precioCompra+precioCompra/2;
        this.listaUnidades = new ArrayList <> ();
        Listar.listaProductosTotal.add(this);
    }

    public Producto() {
        this.precioVenta = 0;
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
    //Pendiente de comprobacion
    public void actualizar(){
        this.stock = this.listaUnidades.size();
        for (Unidad unidad : this.listaUnidades)
            unidad.setNumero(this.listaUnidades.indexOf(unidad));
    }
    
    
}