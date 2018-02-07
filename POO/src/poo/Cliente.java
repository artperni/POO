package poo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    
    public void listaUdToString(){
        for (Unidad unidad : this.listaUnidades)
            System.out.println(unidad.getProducto().toStringRef()+"\t"+unidad.toString());
    }
    
    public boolean devolver(Unidad unidad){
        this.listaUnidades.remove(unidad);
        unidad.setEstado(Estado.libre);
        /*Se devuelve 3/4 de lo que costaba sin descuento*/
        Double devolucion = unidad.getProducto().getPrecioVenta() * 0.75;
        this.credito = this.credito + devolucion;
        Listar.totalVendido -= devolucion;
        return true;
    }
    
    public boolean aumentarCredito(double credito){
        this.credito = this.credito + credito;
        return true;
    }
    
    public void comprarUnidad(Unidad unidad){
        this.listaUnidades.add(unidad);
        unidad.setEstado(Estado.vendido);
    }
    
    public void comprarUnidad(ArrayList <Unidad> listaUnidades){
        for(Unidad unidad : listaUnidades)
            this.comprarUnidad(unidad);
    }
    
    public boolean facturar(Albaran albaran) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Forma de Pago: ");
        FormaPago fmpg = FormaPago.valueOf(br.readLine());
        System.out.print("Observaciones de la Factura: ");
        Factura factura = new Factura(br.readLine(), fmpg, albaran);
        if ( factura.importeTotal > this.credito )
            return false;
        else{
            this.comprarUnidad(factura.listaCompra);
            System.out.println(factura.toString(this));
            return true;
        }
    }
    
    public boolean pagarFactura(Factura factura){
        this.credito -= factura.importeTotal;
        Listar.totalVendido += factura.importeTotal;
        factura.setEstadoFactura(true);
        return true;
    }
    
    public Albaran getAlbaran(int numero){
        Listar lista = Listar.getIntancia();
        return lista.getAlbaranes(this).get(numero);
    }
    
    public Factura getFactura(int numero){
        Listar lista = Listar.getIntancia();
        return lista.getFacturas(this).get(numero);
    }
    
    public Unidad getUnidad(String ref, int numero){
        for (Unidad unidad : this.listaUnidades)
            if ( unidad.getProducto().getReferencia().equalsIgnoreCase(ref) )
                return unidad.getProducto().getUnidad(numero);
        return null;
    }

    
    
}