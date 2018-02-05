package poo;

import java.util.*;


public class Cliente {
    private String nombre;
    private String nif;
    private String direccion;
    private String codigo;
    private double credito;
    private ArrayList <Unidad> listaUnidades;

    
    

    public Cliente(String nombre, String nif, String direccion, double credito) {
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.credito = credito;
        this.codigo = nif.concat(nombre);
        this.listaUnidades = new ArrayList <> ();
        Listar.listaClientes.add(this);
    }

    public Cliente() {
        this.codigo = null;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getNif() {
        return nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getCredito() {
        return credito;
    }

    public ArrayList<Unidad> getListaUnidades() {
        return listaUnidades;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public void setListaUnidades(ArrayList<Unidad> listaUnidades) {
        this.listaUnidades = listaUnidades;
    }

    @Override
    public String toString() {
        return "Nombre del cliente: "+this.nombre+"\tNIF del cliente: "+this.nif+
                "\tDirección del cliente: "+this.direccion+"\tCódigo del cliente: "+
                this.codigo+"\tCrédito del cliente: "+this.credito+"€";
    }
    
    public void devolver(Unidad unidad, Almacen almacen){
        this.listaUnidades.remove(unidad);
        almacen.anadir(unidad);
        /*Se devuelve 3/4 de lo que costó*/
        this.credito = this.credito + unidad.getProducto().getPrecioVenta() * 0.75;
    }
    
    public void aumentarCredito(double credito){
        this.credito = this.credito + credito;
    }
    
    public void comprarUnidad(Unidad unidad){
        this.listaUnidades.add(unidad);
        this.credito = this.credito - unidad.getProducto().getPrecioVenta();
        unidad.setEstado(Estado.vendido);
    }

    
    
}