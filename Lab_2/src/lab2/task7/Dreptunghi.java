package lab2.task7;

public class Dreptunghi extends Paralelogram{

    public Dreptunghi(){
        super();
    }
    public Dreptunghi(int lungime, int latime) {
        super(lungime, latime,90);
    }

    @Override
    final public Integer arie() {
        return latura1*latura2;
    }
}
