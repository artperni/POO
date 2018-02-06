package poo;


import java.util.*;


public class Producto {
    private String referencia;
    private int stock;
    private Dimensiones dimensiones;
    private double precioCompra;
    private double precioVenta;
    private ArrayList <Unidad> listaUnidades;
    
    
    
    public Producto(String referencia, Dimensiones dimensiones, double precioCompra) {
        this.referencia = referencia;
        this.dimensiones = dimensiones;
        this.precioCompra = precioCompra;
        this.precioVenta = precioCompra+precioCompra/2;
        this.listaUnidades = new ArrayList <> ();
        Listar.listaProductosTotal.add(this);
    }
    public Producto(String referencia) {
        this.referencia = referencia;
        this.listaUnidades = new ArrayList <> ();
        Listar.listaProductosTotal.add(this);
    }

    public Producto() {
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

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void actStock() {
        this.stock = this.getUnidadesLibres();
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

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    
    
    
    

    @Override
    public String toString() {
        return "Referencia: "+this.referencia+"\tStock: "+this.stock+
                "\tDimensiones: "+this.dimensiones.toString()+
                "\tPrecio: "+this.precioVenta+"€\t"+this.listaUnidades.toString();
    }
    
    public String toStringRef() {
        return "Referencia: "+this.referencia;
    }
    
    public String toStringUnid() {
        return this.listaUnidades.toString();
    }
    
    
    
    
    public boolean anadirUnidad(Unidad unidad){
        this.listaUnidades.add(unidad);
        this.actStock();
        return true;
    }
    
    public void anadirUnidades(ArrayList <Unidad> listaunidades){
        for (Unidad unidad : listaunidades)
            anadirUnidad(unidad);
    }
    
    public void eliminarUnidad(Unidad unidad){
        this.listaUnidades.remove(unidad);
        this.actStock();
    }
    
    public boolean eliminarUnidad(int num){
        this.listaUnidades.remove(num);
        this.actStock();
        return true;
    }
    
    public void eliminarUnidades(ArrayList <Unidad> listaunidades){
        for (Unidad unidad : listaunidades)
            eliminarUnidad(unidad);
    }
    
    public boolean isVacio(){
        return this.listaUnidades.isEmpty();
    }
    
    public Unidad getUnidad(int pos) {
        if (this.listaUnidades.size() >= pos-1)
            return this.listaUnidades.get(pos);
        return null;
    }
    
    /*El método coge la primera Unidad libre encontrada en el Producto*/
    public Unidad getUnidadLibre() {
        for (Unidad unidad : this.listaUnidades)
            if( unidad.isLibre() )
                return unidad;
        return null;
    }
    
    public int getUnidadesLibres() {
        int cont=0;
        for (Unidad unidad : this.listaUnidades)
            if( unidad.isLibre() )
                cont++;
        return cont;
    }
    
    /*Método para comprobar que un producto tiene al menos una Unidad libre*/
    public boolean isLibre(){
        for (Unidad unidad : this.listaUnidades)
            return unidad.isLibre();
        return false;
    }
    
}