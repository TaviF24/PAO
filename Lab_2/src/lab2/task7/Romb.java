package lab2.task7;

public class Romb extends Paralelogram{

    private int diag1;
    private int diag2;

    public Romb(){
        super();
        this.diag1 = 0;
        this.diag2 = 0;
    }
    public Romb(int l1, int diag1, int diag2){
        super(l1,l1);
        this.diag1 = diag1;
        this.diag2 = diag2;
    }

    @Override
    final public Double arie() {
        return (diag1*diag2)/2.0;
    }
}
