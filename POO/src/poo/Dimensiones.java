package poo;



public class Dimensiones {
    private final double ancho;
    private final double altura;

    public Dimensiones(double ancho, double altura) {
        this.ancho = ancho;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return this.ancho+"x"+this.altura;
    }
    
    
    
}
