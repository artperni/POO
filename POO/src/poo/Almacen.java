package poo;


import java.util.*;


public class Almacen {
    public ArrayList <Producto> listaProductos;
    private String codigo;
    private Localizacion localizacion;

    public Almacen() {
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
            if(producto.isCaducado(dias)){
                contadorDias++;
            }
        }    
        return contadorDias;
    }
    
    public void estadoProductos(String estado){
        int contLibre=0,contVendido=0,contReservado=0;
        for (Producto producto : this.listaProductos){
            if (producto.isLibre())
                contLibre++;
            else if (producto.isReservado())
                contReservado++;
            else if (producto.isVendido())
                contVendido++;
            else
                System.out.println("Error en el producto con referencia "+
                        producto.getReferencia());
        }
        System.out.println("\nProductos libres: "+contLibre+"\nProductos vendidos: "+
                contVendido+"\nProductos reservados: "+contReservado);
    }
    
    public int libreCaducadoProductos(){
        int contLibCad=0;
        for (Producto producto : this.listaProductos){
            if(producto.isCaducado() && producto.isLibre()){
                contLibCad++;
            }
        }
        return contLibCad;
    }
    
    
    public void eliminarCaducados(){
        for (Producto producto : this.listaProductos){
            if(producto.isCaducado()){
                this.listaProductos.remove(producto);
                /*Empiezo a dudar acerca del stock de los productos.
                Cada producto debería tener una lista de "elementos"
                iguales entre sí en cuanto a dimensiones pero distintos en
                estado y fecha de caducidad? Y así cuando eliminemos un producto 
                caducado estaríamos eliminando un elemento de ese tipo y el 
                stock de ese producto entonces sí tendría sentido que bajara en 1.*/
            }
        }
    }
    
    public void anadir(Producto producto){
        this.listaProductos.add(producto);
        //Aquí se me plantea la misma duda
        
        
        
        
        
        
    }
    
    public void ventaProducto(int numeroCorrelativo){
        Albaran albaran = new Albaran();
        
        
        
        
        
    }
    
    
}
