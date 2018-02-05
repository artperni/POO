package poo;



public class Dimensiones {
    private double ancho;
    private double altura;

    public Dimensiones(double ancho, double altura) {
        this.ancho = ancho;
        this.altura = altura;
    }

    public Dimensiones() {
        this.ancho = 0;
        this.altura = 0;
    }
    
    
    public double getAncho() {
        return ancho;
    }

    public double getAltura() {
        return altura;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    

    @Override
    public String toString() {
        return this.getAncho()+"x"+this.getAltura();
    }

    
    
}
