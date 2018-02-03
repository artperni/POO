package poo;

import java.util.*;

public class Listar {
    public static ArrayList <Producto> listaProductosTotal = new ArrayList<>();      
    public static ArrayList <Albaran> listaAlbaranes = new ArrayList<>();     
    public static double totalVendido;
    public static ArrayList <Factura> listaFacturas = new ArrayList<>();
    public static ArrayList <Almacen> listaAlmacenes = new ArrayList<>();
    public static ArrayList <Cliente> listaClientes = new ArrayList<>();
    private static Listar unicaInstancia = null;
    private final IPersistence dacAlb;
    private final IPersistence dacAlm;
    private final IPersistence dacCli;
    private final IPersistence dacFac;
    private final IPersistence dacPro;

    private Listar() {
        dacAlb = new AlbaranDAC();
        dacAlm = new AlmacenDAC();
        dacCli = new ClienteDAC();
        dacFac = new FacturaDAC();
        dacPro = new ProductoDAC();
    }
    
    public static Listar getIntancia(){
        if (unicaInstancia == null)
            unicaInstancia = new Listar();
        return unicaInstancia;
    }
    
    
    
     public void listarProductosTotal(){
        for (Producto producto : listaProductosTotal)
            System.out.println(producto.toString());
    }
    
    public void listarAlbaranes(){
        for (Albaran albaran : listaAlbaranes)
            System.out.println(albaran.toString());
    }
    
    public void listarProductosTotal(double precioMin){
        for (Producto producto : listaProductosTotal){
            if (producto.getPrecioVenta() > precioMin)
                System.out.println(producto.toString());
        }
    }
    
    public void listarAlbaranes(Calendar fecha){
        for (Albaran albaran : listaAlbaranes)
            if (albaran.getFecha().compareTo(fecha)==0)
                System.out.println(albaran.toString());
    }
    
    public void listarAlbaranes(int numeroAlb){
        for (Albaran albaran : listaAlbaranes)
            if (albaran.getNumeroAlbaran() == numeroAlb)
                System.out.println(albaran.toString());
    }
    
    public void listarTotalVendido(){
        Calendar now = Calendar.getInstance();
        System.out.println("Total vendido a día de "+now+": "+totalVendido);
    }
    
    public void listarFacturasImpagadas(){
        for (Factura factura : listaFacturas){
            if ( ! factura.isEstadoFactura())
                System.out.println(factura.toString());
        }
    }
    
    public void listarFacturas(String nifCli){
        for (Factura factura : listaFacturas){
            if ( factura.getCliente().getNif().equals(nifCli))
                System.out.println(factura.toString());
        }
    }
    
    public void listarStock(Producto producto){
        System.out.println("Stock del producto "+producto.getReferencia()+": "+
                producto.getStock());
    }
    
    public void listarAlmacenes(){
        for (Almacen almacen : listaAlmacenes)
            System.out.println(almacen.toString());
    }
    
    public void listarClientes(){
        for (Cliente cliente : listaClientes)
            System.out.println(cliente.toString());
    }
    
    public void deserialize(){
        listaAlbaranes = dacAlb.xmlDeserialize();
        listaAlmacenes = dacAlm.xmlDeserialize();
        listaClientes = dacCli.xmlDeserialize();
        listaFacturas = dacFac.xmlDeserialize();
        listaProductosTotal = dacPro.xmlDeserialize();
    }
    
    public void serialize(){
        if( ! this.dacAlb.xmlSerialize(listaAlbaranes) )
            System.out.println("Error serializando los albaranes");
        if( ! this.dacAlm.xmlSerialize(listaAlmacenes) )
            System.out.println("Error serializando los almacenes");
        if( ! this.dacCli.xmlSerialize(listaClientes) )
            System.out.println("Error serializando los clientes");
        if( ! this.dacFac.xmlSerialize(listaFacturas) )
            System.out.println("Error serializando las facturas");
        if( ! this.dacPro.xmlSerialize(listaProductosTotal) )
            System.out.println("Error serializando los productos");
    }
    
    
}
