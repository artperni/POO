package poo;



public class Dimensiones {
    private final double ancho;
    private final double altura;

    public Dimensiones(double ancho, double altura) {
        this.ancho = ancho;
        this.altura = altura;
    }

    public Dimensiones() {
        this.ancho = 0;
        this.altura = 0;
    }

    @Override
    public String toString() {
        return this.ancho+"x"+this.altura;
    }
    
    
    
}
