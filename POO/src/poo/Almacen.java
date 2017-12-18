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
    
    
    
    
    
}
