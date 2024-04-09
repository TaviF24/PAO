package task3.Magazin;

public class Produs {
    private final Double pret;
    private final String denumire;

    public Produs(Double pret, String denumire) {
        this.pret = pret;
        this.denumire = denumire;
    }

    public Double getPret() {
        return pret;
    }
}
