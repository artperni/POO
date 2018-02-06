package poo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Almacen {
    public ArrayList <Producto> listaProductos;
    private String codigo;
    private Localizacion localizacion;

    public Almacen(String codigo, Localizacion localizacion) {
        this.codigo = codigo;
        this.localizacion = localizacion;
        listaProductos = new ArrayList<>();
        Listar.listaAlmacenes.add(this);
    }

    public Almacen() {
    }
    
    
        

    public ArrayList <Producto> getListaProductos() {
        return listaProductos;
    }

    public String getCodigo() {
        return codigo;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    
    
    
    public int totalProductos(){
       return this.listaProductos.size();
    }
    
    public int caducidadProductos(int dias){
        int contadorDias=0;
        for (Producto producto : this.listaProductos){//Recorremos la lista de productos
            for (Unidad unidad : producto.getListaUnidades()){//Recorremos la lista de unidades
                if(unidad.isCaducado(dias)){
                    contadorDias++;
                }
            }
        }    
        return contadorDias;
    }
    
    public void estadoProductos(){
        int contLibre=0,contVendido=0,contReservado=0;
        for (Producto producto : this.listaProductos){
            for (Unidad unidad : producto.getListaUnidades()){
                if (unidad.isLibre())
                    contLibre++;
                else if (unidad.isReservado())
                    contReservado++;
                else if (unidad.isVendido())
                    contVendido++;
                else
                    System.out.println("Error en el producto con referencia "+
                    producto.getReferencia());
            }
        }
        System.out.println("Productos libres: "+contLibre+"\nProductos vendidos: "+
                contVendido+"\nProductos reservados: "+contReservado);
    }
    
    public int libreCaducadoProductos(){
        int contLibCad=0;
        for (Producto producto : this.listaProductos){
            for (Unidad unidad : producto.getListaUnidades()){
                if(unidad.isCaducado() && unidad.isLibre()){
                    contLibCad++;
                }   
            }
        }
        return contLibCad;
    }
    
    
    public boolean eliminarCaducados(){
        ArrayList <Unidad> listaUnidades = new ArrayList();
        for (Producto producto : this.listaProductos){
            for (Unidad unidad : producto.getListaUnidades()){
                if(unidad.isCaducado() && unidad.isLibre())
                    listaUnidades.add(unidad);
            }
            if (producto.isVacio())
                eliminar(producto);
            if(listaUnidades.size()==this.libreCaducadoProductos()){
                for (Unidad unidad : listaUnidades)
                    unidad.eliminarUnidad();
                return true;
            }
                
        }
        return false;
    }
    
    public boolean eliminar(Producto producto){
        this.listaProductos.remove(producto);
        return Listar.listaProductosTotal.remove(producto);
    }
    
    public boolean eliminar(Unidad unidad){
        for (Producto producto : this.listaProductos){
            producto.eliminarUnidad(unidad);
            if (producto.isVacio()){
                eliminar(producto);
                return true;
            }
        }
        return false;
    }
    
    /*Elimina una unidad concreta del producto con esa referencia*/
    public boolean eliminar(String referencia, int numero){
        for (Producto producto : this.listaProductos){
            if (producto.getReferencia().equalsIgnoreCase(referencia)){
                producto.eliminarUnidad(numero);
                if (producto.isVacio()){
                    eliminar(producto);
                    return true;
                }
                else
                    return true;
            }
        }
        return false;
    }
    
    public boolean anadir(Producto producto){
        return this.listaProductos.add(producto);
    }
    
    public boolean anadir(Unidad unidad){
        for (Producto producto : this.listaProductos){
            if (unidad.getProducto().getReferencia().equalsIgnoreCase(producto.getReferencia())){
                return producto.anadirUnidad(unidad);
            }
        }
        this.anadir(unidad.getProducto());
        return unidad.getProducto().anadirUnidad(unidad);
    }
    
    /*this.almacen es el almacen que contiene el producto a trasladar y
    "almacen" es el almacen que contendrá en el futuro a "producto".
    Trasladamos un Producto entero con sus unidades correspondientes*/
    public boolean trasladar(Producto producto, Almacen almacen){
        this.eliminar(producto);
        return almacen.anadir(producto);
    }
    
    /*devuelve false si no se puede completar la venta y true cuando se realice
    con exito*/
    public boolean vender(Cliente cliente) throws IOException{
        Albaran albaran = new Albaran(cliente);
        String opcion;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do{
            this.prodLibresToString();
            System.out.print("Referencia del Producto: ");
            Unidad u1 = this.getProducto(br.readLine()).getUnidadLibre();
            if ( u1 != null )
                albaran.anadirCesta(u1);
            else
                return false;
            do{
                System.out.print("Continuar? [s,n]: ");
                opcion = br.readLine();
            } while ( ! opcion.equalsIgnoreCase("s") && ! opcion.equalsIgnoreCase("n") );
        } while (opcion.equalsIgnoreCase("s"));
        if ( albaran.isVacio() ){
            Listar.listaAlbaranes.remove(albaran);
        }
        return true;
    }
    
    public Producto getProducto(String referencia){
        for (Producto producto : this.listaProductos){
            if ( producto.getReferencia().equalsIgnoreCase(referencia) )
                return producto;
        }
        return null;
    }
    
    public void prodLibresToString(){
        for (Producto producto : this.listaProductos)
            if ( producto.isLibre() )
                System.out.println(producto.toStringRef()+"\tx"+producto.getStock());
    }
    
}
