package poo;


import java.util.*;

public class Albaran {
    private Date fecha;
    private int numero;
    private ArrayList <Producto> listaCompra;
    private double importeTotal;
    private Cliente cliente;

    
    
    public Albaran() {
        Calendar now = Calendar.getInstance();
        this.fecha = now.getTime();
    }

    public Albaran(int numero, ArrayList<Producto> listaCompra,  Cliente cliente){
        Calendar now = Calendar.getInstance();
        this.fecha = now.getTime();
        this.numero = numero;
        this.listaCompra = listaCompra;
        this.cliente = cliente;
        for(Producto producto : listaCompra){
            this.importeTotal+=producto.getPrecioVenta();
        }
    }
    
    
    public Date getFechaCompra() {
        return fecha;
    }

    public int getNumero() {
        return numero;
    }

    public ArrayList <Producto> getListaCompra() {
        return listaCompra;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setListaCompra(ArrayList <Producto> listaCompra) {
        this.listaCompra = listaCompra;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Fecha de creación del albarám: "+this.fecha+"\nNúmero de albarán: "+this.numero+
                "\nLista de productos: "+this.listaCompra.toString()+"\nImporte total: "+this.importeTotal+
                "\nCliente asociado: "+this.cliente.toString();
    }
    
    
    
    
    
}