package poo;

public class Usuario {
    private String nombre;
    private String passwd;

    public Usuario(String nombre, String passwd) {
        this.nombre = nombre;
        this.passwd = passwd;
        Listar.listaUsuarios.add(this);
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    
    
}
