import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.pow;

public class Polynomial implements CalculatedFunction {
    private List<Double> wsp;

    public Polynomial(double... wsp) {
        this.wsp = new ArrayList<>();
        for (double x : wsp) {
            this.wsp.add(x);
        }
    }

    @Override
    public double f(double x) {
        int potega = wsp.size() - 1;
        double wynik = 0;
        while (potega > -1) {
            wynik = wynik + wsp.get(wsp.size() - potega - 1) * pow(x, potega);
            potega = potega - 1;
        }
        return wynik;
    }

    public static void main(String[] args) {
        Polynomial a = new Polynomial(1., 2., -8., -1.);
        TrapezoidMethod t = new TrapezoidMethod(a,0,4,16);
        MonteCarloMethod m = new MonteCarloMethod(a,0,4,16);
        MonteCarloMethod m2 = new MonteCarloMethod(a,0,4,1000000);
        System.out.println(t.calculate());
        System.out.println(m2.calculate());
    }
}