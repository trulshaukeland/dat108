package no.hvl.dat108.sirkelrektangel;

public class Kvadrat implements Flate {

    double side;

    public Kvadrat(double side) {
        this.side = side;
    }
    @Override
    public double areal() {
        return side * 4;
    }
    
}
