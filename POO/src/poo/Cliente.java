package poo;

import java.util.*;


public class Cliente {
    private String nombre;
    private String nif;
    private String direccion;
    private final String codigo;
    private double credito;
    private ArrayList <Unidad> listaUnidades;
    private IPersistence objDac;

    
    

    public Cliente(String nombre, String nif, String direccion, double credito) {
        this.nombre = nombre;
        this.nif = nif;
        this.direccion = direccion;
        this.credito = credito;
        this.codigo = nif.concat(nombre);
        this.listaUnidades = new ArrayList <> ();
        Listar.listaClientes.add(this);
        this.objDac = new ClienteDAC();
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

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public void setListaUnidades(ArrayList<Unidad> listaUnidades) {
        this.listaUnidades = listaUnidades;
    }

    @Override
    public String toString() {
        return "\nNombre del cliente: "+this.nombre+"\tNIF del cliente: "+this.nif+
                "\tDirección del cliente: "+this.direccion+"\tCódigo del cliente: "+
                this.codigo+"\tCrédito del cliente: "+this.credito+"€";
    }
    
    public void serialize(){
        this.objDac.xmlSerialize(this);
    }
    
    
    
    public void devolver(Unidad unidad, Almacen almacen){
        this.listaUnidades.remove(unidad);
        almacen.anadir(unidad);
        this.credito = this.credito + unidad.getPrecioVenta();
    }
    
    public void aumentarCredito(double credito){
        this.credito = this.credito + credito;
    }
    
    public void comprarUnidad(Unidad unidad){
        this.listaUnidades.add(unidad);
        this.credito = this.credito - unidad.getPrecioVenta();
        unidad.setEstado(Estado.vendido);
    }

    
    
}