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

    public Interval intersect(Interval temp) {
        return presijecanje(this, temp);
    }

    public static Interval intersect(Interval prvi, Interval drugi) {
        return presijecanje(prvi, drugi);
    }

    public static Interval presijecanje(Interval prvi, Interval drugi) {
        if (prvi.Pocetna < drugi.Pocetna) {
            if (prvi.Krajnja < drugi.Krajnja)
                return new Interval(drugi.Pocetna, prvi.Krajnja, drugi.PripadaP, prvi.PripadaK);
            else
                return new Interval(drugi.Pocetna, drugi.Krajnja, drugi.PripadaP, drugi.PripadaK);
        }
        else {
            if (prvi.Krajnja > drugi.Krajnja)
                return new Interval(prvi.Pocetna, drugi.Krajnja, prvi.PripadaP, drugi.PripadaK);
            else
                return new Interval(prvi.Pocetna, prvi.Krajnja, prvi.PripadaP, prvi.PripadaK);
        }
    }
}