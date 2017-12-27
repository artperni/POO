package poo;


import java.util.*;

public class Albaran {
    private Calendar fecha;
    private static int numero;
    private ArrayList <Producto> listaCompra;
    private double importeTotal;
    private Cliente cliente;



    public Albaran(ArrayList<Producto> listaCompra,  Cliente cliente){
        Calendar now = Calendar.getInstance();
        this.fecha = now;
        numero++;
        this.listaCompra = listaCompra;
        this.cliente = cliente;
        for(Producto producto : listaCompra){
            this.importeTotal+=producto.getPrecioVenta();
        }
        Listar.listaAlbaranes.add(this);
    }
    
    public Calendar getFecha() {
        return fecha;
    }

    public static int getNumero() {
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

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public static void setNumero(int aNumero) {
        numero = aNumero;
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
        return "Fecha de creación del albarám: "+this.getFecha()+"\nNúmero de albarán: "+this.getNumero()+
                "\nLista de productos: "+this.getListaCompra().toString()+"\nImporte total: "+this.getImporteTotal()+
                "\nCliente asociado: "+this.getCliente().toString();
    }

    
}