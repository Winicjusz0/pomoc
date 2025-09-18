import java.util.Random;

public class MonteCarloMethod extends Integral{
    int n;

    public MonteCarloMethod(CalculatedFunction cf, double dolna, double gorna, int n) {
        super(cf, dolna, gorna);
        this.n = n;
    }

    @Override
    public double calculate() {
        double wynik = 0;
        for (int i=0; i<n; i++){
            Random r = new Random();
            double x = dolna + r.nextDouble() * (gorna-dolna);
            wynik = wynik + cf.f(x) * (gorna-dolna);
        }
        wynik = wynik / n;
        return wynik;
    }
}
