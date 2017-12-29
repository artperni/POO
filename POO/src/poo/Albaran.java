package poo;


import java.util.*;

public class Albaran {
    private Calendar fecha;
    private static int numeroAlbaran;
    private ArrayList <Unidad> listaCompra;
    private double importeTotal;
    private Cliente cliente;



    public Albaran(ArrayList<Unidad> listaCompra,  Cliente cliente){
        Calendar now = Calendar.getInstance();
        this.fecha = now;
        numeroAlbaran++;
        this.listaCompra = listaCompra;
        this.cliente = cliente;
        for(Unidad producto : listaCompra){
            this.importeTotal+=producto.getPrecioVenta();
        }
        Listar.listaAlbaranes.add(this);
    }
    
    public Calendar getFecha() {
        return fecha;
    }

    public static int getNumero() {
        return numeroAlbaran;
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

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public static void setNumero(int aNumero) {
        numeroAlbaran = aNumero;
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
    

    @Override
    public String toString() {
        return "Fecha de creación del albarám: "+this.getFecha()+"\nNúmero de albarán: "+numeroAlbaran+
                "\nLista de productos: "+this.getListaCompra().toString()+"\nImporte total: "+this.getImporteTotal()+
                "\nCliente asociado: "+this.getCliente().toString();
    }

    
}