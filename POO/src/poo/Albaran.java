package poo;

//alex comentario de prueba
import java.util.*;

public class Albaran {
    private Date fechaCompra;
    private int numero;
    private ArrayList <Producto> listaCompra;
    private double importeTotal;
    private Cliente cliente;


    public Albaran(Date fechaCompra, int numero, ArrayList<Producto> listaCompra,  Cliente cliente) {
        this.fechaCompra = fechaCompra;
        this.numero = numero;
        this.listaCompra = listaCompra;
        this.cliente = cliente;
        for(Producto producto : listaCompra){
            this.importeTotal+=producto.getPrecioVenta();
        }
    }
    
    
    public Date getFechaCompra() {
        return fechaCompra;
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

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
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
        return "Fecha de compra del producto: "+this.fechaCompra+"\nNúmero de albarán: "+this.numero+
                "\nLista de productos: "+this.listaCompra.toString()+"\nImporte total: "+this.importeTotal+
                "\nCliente asociado: "+this.cliente.toString();
    }
    
    
            
    
    
    
    
    
}