public abstract class Integral {
    public CalculatedFunction cf;
    public double dolna;
    public double gorna;

    public Integral(CalculatedFunction cf, double dolna, double gorna) {
        this.cf = cf;
        this.dolna = dolna;
        this.gorna = gorna;
    }

    public abstract double calculate();
}
