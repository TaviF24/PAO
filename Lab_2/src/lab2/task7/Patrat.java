package lab2.task7;

public class Patrat extends Dreptunghi{

    public Patrat(){
        super();
    }

    public Patrat(int latura){
        super(latura,latura);
    }



    // putem sa nu mai scriem aria pt ca ramane la fel => final metodei din dreptunghi
    // e mai jos implementarea
    /*
    @Override
    final public Integer arie() {
        return super.arie();
    }
    */
}
