package poo;

import java.text.SimpleDateFormat;
import java.util.*;

public class Listar {
    public static ArrayList <Producto> listaProductosTotal = new ArrayList<>();      
    public static ArrayList <Albaran> listaAlbaranes = new ArrayList<>();     
    public static double totalVendido;
    public static ArrayList <Factura> listaFacturas = new ArrayList<>();
    public static ArrayList <Almacen> listaAlmacenes = new ArrayList<>();
    public static ArrayList <Cliente> listaClientes = new ArrayList<>();
    public static ArrayList <Usuario> listaUsuarios = new ArrayList<>();
    private static Listar unicaInstancia = null;
    private final IPersistence dac;

    private Listar() {
        dac = new ProyectDAC();
    }
    
    public static Listar getInstancia(){
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
        for (Albaran albaran : listaAlbaranes){
            if ( albaran.getFecha().get(Calendar.DATE) == fecha.get(Calendar.DATE) &&
                    albaran.getFecha().get(Calendar.MONTH) == fecha.get(Calendar.MONTH) && 
                    albaran.getFecha().get(Calendar.YEAR) == fecha.get(Calendar.YEAR) )
                System.out.println(albaran.toString());
        }
    }
    
    public void listarAlbaranes(int numeroAlb){
        for (Albaran albaran : listaAlbaranes)
            if (albaran.getNumeroAlbaran() == numeroAlb)
                System.out.println(albaran.toString());
    }
    
    public void listarTotalVendido(){
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Total vendido a día de "+dateFormat.format(now.getTime())+": "+totalVendido+"€");
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
    
    //La referencia de una objeto tendremos en cuenta que debe ser única
    public Producto getProducto(String referencia){
        for (Producto producto : listaProductosTotal){
            if ( producto.getReferencia().equalsIgnoreCase(referencia) )
                return producto;
        }
        return null;
    }
    
    public Almacen getAlmacen(String codigo){
        for (Almacen almacen : listaAlmacenes){
            if ( almacen.getCodigo().equalsIgnoreCase(codigo) )
                return almacen;
        }
        return null;
    }
    
    public Cliente getCliente(String dato){
        for (Cliente cliente : listaClientes){
            if ( cliente.getNif().equalsIgnoreCase(dato) ||  
                    cliente.getNombre().equalsIgnoreCase(dato) )
                return cliente;
        }
        return null;
    }
    
    public Albaran getAlbaran(Cliente cliente){
        for (Albaran albaran : listaAlbaranes){
            /*Si un cliente tiene asociados varios albaranes, solo cogemos la primera
            coincidencia*/
            if ( albaran.cliente.equals(cliente) )
                return albaran;
        }
        return null;
    }
    
    public ArrayList <Albaran> getAlbaranes(Cliente cliente){
        ArrayList <Albaran> albsCli = new ArrayList<>();
        for (Albaran albaran : listaAlbaranes){
            if ( albaran.cliente.getNif().equalsIgnoreCase(cliente.getNif()) )
                albsCli.add(albaran);
        }
        return albsCli;
    }
    
    public ArrayList <Factura> getFacturas(Cliente cliente){
        ArrayList <Factura> facsCli = new ArrayList<>();
        for (Factura factura : listaFacturas){
            if ( factura.cliente.getNif().equalsIgnoreCase(cliente.getNif()) )
                facsCli.add(factura);
        }
        return facsCli;
    }
    
    public void almCodToString(){
        for ( Almacen alm : Listar.listaAlmacenes )
            System.out.println(alm.getCodigo());
    }
    
    public void almCodToString(Almacen almacen){
        for ( Almacen alm : Listar.listaAlmacenes )
            if ( ! alm.equals(almacen) )
                System.out.println(alm.getCodigo());
    }
    
    public void cliToString(){
        for ( Cliente cli : Listar.listaClientes )
                System.out.println(cli.getNombre()+"\t"+cli.getNif());
    }
    
    public void albCliToString(Cliente cliente){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for (Albaran albaran : this.getAlbaranes(cliente))
                System.out.println("Numero: "+albaran.numeroAlbaran+"\tImporte Total Sin Descuentos: "+albaran.importeTotal+"€"+"\tFecha de Creación: "+dateFormat.format(albaran.fecha.getTime()));
    }
    
    public void facCliToString(Cliente cliente){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        for (Factura factura : this.getFacturas(cliente))
                System.out.println("Numero: "+factura.numeroAlbaran+"\tImporte Total Con Descuentos: "+factura.importeTotal+"€"+"\tFecha de Creación: "+dateFormat.format(factura.fecha.getTime()));
    }
    
    public boolean isUsuario(String nombre, String passwd){
        for (Usuario usuario : listaUsuarios)
            if ( usuario.getNombre().equals(nombre) && usuario.getPasswd().equals(passwd) ){
                System.out.println("Bienvenido "+nombre);
                return true;
            }
        System.out.println("Usuario o Contraseña Incorrectos");        
        return false;
    }
    
    public boolean isUsuario(String nombre){
        for (Usuario usuario : listaUsuarios)
            if ( usuario.getNombre().equals(nombre) ){
                return true;
            }  
        return false;
    }
    
    public boolean isPoo(String nombre){
        if ( nombre.equals("poo") )
            return true;
        return false;
    }
    
    public Usuario getUsuario(String nombre, String passwd){
        for (Usuario usuario : listaUsuarios)
            if ( usuario.getNombre().equals(nombre) && usuario.getPasswd().equals(passwd) )
                return usuario;
        return null;
    }
    
    public Usuario getUsuario(String nombre){
        for (Usuario usuario : listaUsuarios)
            if ( usuario.getNombre().equals(nombre) )
                return usuario;
        return null;
    }
    
    
    
    public void deserialize(){
        listaAlbaranes = (ArrayList <Albaran>)dac.xmlDeserialize(IPersistence.ALB_SERIALIZE);
        listaAlmacenes = (ArrayList <Almacen>)dac.xmlDeserialize(IPersistence.ALM_SERIALIZE);
        listaClientes = (ArrayList <Cliente>)dac.xmlDeserialize(IPersistence.CLI_SERIALIZE);
        listaFacturas = (ArrayList <Factura>)dac.xmlDeserialize(IPersistence.FAC_SERIALIZE);
        listaProductosTotal = (ArrayList <Producto>)dac.xmlDeserialize(IPersistence.PRO_SERIALIZE);
        listaUsuarios = (ArrayList <Usuario>)dac.xmlDeserialize(IPersistence.USR_SERIALIZE);
        totalVendido = (Double)dac.xmlDeserialize(IPersistence.VEN_SERIALIZE);
    }
    
    public void serialize(){
        if( ! this.dac.xmlSerialize(listaAlbaranes, IPersistence.ALB_SERIALIZE) )
            System.out.println("Error serializando los albaranes");
        if( ! this.dac.xmlSerialize(listaAlmacenes, IPersistence.ALM_SERIALIZE) )
            System.out.println("Error serializando los almacenes");
        if( ! this.dac.xmlSerialize(listaClientes,IPersistence.CLI_SERIALIZE) )
            System.out.println("Error serializando los clientes");
        if( ! this.dac.xmlSerialize(listaFacturas,IPersistence.FAC_SERIALIZE) )
            System.out.println("Error serializando las facturas");
        if( ! this.dac.xmlSerialize(listaProductosTotal,IPersistence.PRO_SERIALIZE) )
            System.out.println("Error serializando los productos");
        if( ! this.dac.xmlSerialize(listaUsuarios,IPersistence.USR_SERIALIZE) )
            System.out.println("Error serializando los usuarios");
        if( ! this.dac.xmlSerialize(totalVendido,IPersistence.VEN_SERIALIZE) )
            System.out.println("Error serializando el total vendido");
    }
    
    
}
