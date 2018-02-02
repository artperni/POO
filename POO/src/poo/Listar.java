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

    private Listar() {
        dacAlb = new AlbaranDAC();
        dacAlm = new AlmacenDAC();
        dacCli = new ClienteDAC();
        dacFac = new FacturaDAC();
        listaFacturas = this.dacAlb.xmlDeserialize();
    }
    
    public static Listar getIntancia(){
        if (unicaInstancia == null)
            unicaInstancia = new Listar();
        return unicaInstancia;
    }
    
    
    
     public static void listarProductosTotal(){
        for (Producto producto : listaProductosTotal)
            System.out.println(producto.toString());
    }
    
    public static void listarAlbaranes(){
        for (Albaran albaran : listaAlbaranes)
            System.out.println(albaran.toString());
    }
    
    public static void listarProductosTotal(double precioMin){
        for (Producto producto : listaProductosTotal){
            if (producto.getPrecioVenta() > precioMin)
                System.out.println(producto.toString());
        }
    }
    
    public static void listarAlbaranes(Calendar fecha){
        for (Albaran albaran : listaAlbaranes)
            if (albaran.getFecha().compareTo(fecha)==0)
                System.out.println(albaran.toString());
    }
    
    public static void listarAlbaranes(int numeroAlb){
        for (Albaran albaran : listaAlbaranes)
            if (albaran.getNumeroAlbaran() == numeroAlb)
                System.out.println(albaran.toString());
    }
    
    public static void listarTotalVendido(){
        Calendar now = Calendar.getInstance();
        System.out.println("Total vendido a día de "+now+": "+totalVendido);
    }
    
    public static void listarFacturasImpagadas(){
        for (Factura factura : listaFacturas){
            if ( ! factura.isEstadoFactura())
                System.out.println(factura.toString());
        }
    }
    
    public static void listarFacturas(String nifCli){
        for (Factura factura : listaFacturas){
            if ( factura.getCliente().getNif().equals(nifCli))
                System.out.println(factura.toString());
        }
    }
    
    public static void listarStock(Producto producto){
        System.out.println("Stock del producto "+producto.getReferencia()+": "+
                producto.getStock());
    }
    
    public static void listarAlmacenes(){
        for (Almacen almacen : listaAlmacenes)
            System.out.println(almacen.toString());
    }
    
    public static void listarClientes(){
        for (Cliente cliente : listaClientes)
            System.out.println(cliente.toString());
    }
    
    public void deserialize(){
       
    }
    
    
}
