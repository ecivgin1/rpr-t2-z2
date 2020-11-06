package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double Pocetna, Krajnja;
    private boolean PripadaP, PripadaK;

    public Interval(double Pocetna, double Krajnja, boolean PripadaP, boolean PripadaK) throws IllegalArgumentException {
        if (Pocetna > Krajnja) {
            throw new IllegalArgumentException("Pocetna tacka je veca od krajnje");
        }
        this.Pocetna = Pocetna;
        this.Krajnja = Krajnja;
        this.PripadaP = PripadaP;
        this.PripadaK = PripadaK;
    }

    public Interval() {
        this.Pocetna = 0;
        this.Krajnja = 0;
        this.PripadaP = false;
        this.PripadaK = false;
    }

    boolean isNull() {
        return Pocetna == 0 && Krajnja == 0 && !PripadaP && !PripadaK;
    }

    boolean isIn(double Parametar) {
        if (PripadaP)
            if (PripadaK)
                return Parametar >= Pocetna && Parametar <= Krajnja;
            else
                return Parametar >= Pocetna && Parametar < Krajnja;
        else
        if (PripadaK)
            return Parametar > Pocetna && Parametar <= Krajnja;
        else
            return Parametar > Pocetna && Parametar < Krajnja;
    }
}