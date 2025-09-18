public class TrapezoidMethod extends Integral{
    private int n;

    public TrapezoidMethod(CalculatedFunction cf, double dolna, double gorna, int n) {
        super(cf, dolna, gorna);
        this.n = n;
    }

    @Override
    public double calculate() {
        double wynik = 0;
        double odstep = (gorna - dolna) / n;
        for (int i=0; i<n; i++){
            wynik = wynik + odstep * ((cf.f((dolna+i*odstep)) + cf.f((dolna+(i+1)*odstep)))/2);
        }
        return wynik;
    }
}
