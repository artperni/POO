package poo;


import java.util.*;


public class Almacen {
    public ArrayList <Producto> listaProductos;
    private String codigo;
    private Localizacion localizacion;

    public Almacen(String codigo, Localizacion localizacion) {
        this.codigo = codigo;
        this.localizacion = localizacion;
        listaProductos = new ArrayList<>();
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
    

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
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
    
    public void estadoProductos(String estado){
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
        System.out.println("\nProductos libres: "+contLibre+"\nProductos vendidos: "+
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
    
    
    public void eliminarCaducados(){
        for (Producto producto : this.listaProductos){
            for (Unidad unidad : producto.getListaUnidades()){
                if(unidad.isCaducado()){
                    producto.eliminarUnidad(unidad);
                }               
            }
            if (producto.isVacio())
                eliminar(producto);
        }
    }
    
    public void eliminar(Producto producto){
        this.listaProductos.remove(producto);
    }
    
    public void anadir(Producto producto){
        this.listaProductos.add(producto);
    }
    
    /*this es el almacen que contiene el producto a trasladar y
    "almacen" es el almacen que contendrá en el futuro a "producto".
    Trasladamos un producto entero con todas sus unidades, de tener alguna*/
    public void trasladar(Producto producto, Almacen almacen){
        this.eliminar(producto);
        almacen.anadir(producto);
    }
    
    
    public void vender(ArrayList <Unidad> listaCompra, Cliente cliente){
        Albaran albaran = new Albaran(listaCompra, cliente);
        //if (albaran.getImporteTotal() > cliente.getCredito())
          
        
        /*for (Producto producto : albaran){
            
            Listar.totalVendido = Listar.totalVendido + producto.getPrecioVenta();
        }*/
    }
    
}
