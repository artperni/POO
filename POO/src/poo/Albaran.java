package poo;


import java.text.SimpleDateFormat;
import java.util.*;

public class Albaran {
    protected Calendar fecha;
    protected int numeroAlbaran;
    protected ArrayList <Unidad> listaCompra;
    protected double importeTotal;
    protected Cliente cliente;



    public Albaran(Cliente cliente){
        Calendar now = Calendar.getInstance();
        this.fecha = now;
        this.listaCompra = new ArrayList <> ();
        this.cliente = cliente;
        Listar.listaAlbaranes.add(this);
        this.numeroAlbaran = Listar.listaAlbaranes.indexOf(this);
    }

    public Albaran(Calendar fecha, int numeroAlbaran, ArrayList<Unidad> listaCompra, double importeTotal, Cliente cliente) {
        this.fecha = fecha;
        this.numeroAlbaran = numeroAlbaran;
        this.listaCompra = listaCompra;
        this.importeTotal = importeTotal;
        this.cliente = cliente;
    }

    public Albaran() {
    }
    
    public Calendar getFecha() {
        return fecha;
    }

    public ArrayList <Unidad> getListaCompra() {
        return listaCompra;
    }

    public double getImporteTotal() {
        return importeTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumeroAlbaran() {
        return numeroAlbaran;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public void setListaCompra(ArrayList <Unidad> listaCompra) {
        this.listaCompra = listaCompra;
    }

    public void setImporteTotal(double importeTotal) {
        this.importeTotal = importeTotal;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setNumeroAlbaran(int numeroAlbaran) {
        this.numeroAlbaran = numeroAlbaran;
    }
    

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setCalendar(this.fecha);
        return "Número de Albarán: "+this.numeroAlbaran+"\tFecha de creación del Albarán: "+dateFormat.format(this.fecha.getTime())+
                "\tLista de Productos: "+this.listaCompra.toString()+"\tImporte Total: "+this.importeTotal+"€"+
                "\tCliente Asociado: "+this.cliente.toString();
    }

    
    public void anadirCesta(Unidad unidad){
        this.listaCompra.add(unidad);
        this.importeTotal+=unidad.getProducto().getPrecioVenta();
    }
    
}