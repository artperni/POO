package poo;


import java.util.*;

public class Albaran{
    private Calendar fecha;
    private int numeroAlbaran;
    private ArrayList <Unidad> listaCompra;
    private double importeTotal;
    private Cliente cliente;
    private IPersistence objDac;



    public Albaran(Cliente cliente){
        Calendar now = Calendar.getInstance();
        this.fecha = now;
        this.listaCompra = new ArrayList <> ();
        this.cliente = cliente;
        Listar.listaAlbaranes.add(this);
        this.numeroAlbaran = Listar.listaAlbaranes.indexOf(this);
        this.objDac = new AlbaranDAC();
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
        return "Fecha de creación del albarán: "+this.fecha.getTime().toString()+"\nNúmero de albarán: "+this.numeroAlbaran+
                "\nLista de productos: "+this.listaCompra.toString()+"\nImporte total: "+this.importeTotal+
                "\nCliente asociado: "+this.cliente.toString();
    }

    
    public void anadirCesta(Unidad unidad){
        this.listaCompra.add(unidad);
        this.importeTotal+=unidad.getPrecioVenta();
    }
    
    
    public void serialize(){
        this.objDac.xmlSerialize(this);
    }
    
}