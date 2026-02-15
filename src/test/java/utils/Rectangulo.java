package utils;

public class Rectangulo {
    int ancho;
    int alto;

    public Rectangulo(int ancho, int alto){
        this.ancho = ancho;
        this.alto = alto;
    }

    public int area(){
        return ancho * alto;
    }
}
