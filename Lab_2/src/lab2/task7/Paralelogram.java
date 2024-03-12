package lab2.task7;

public class Paralelogram extends Patrulater{

    public Paralelogram(){
        super();
    }

    public Paralelogram(int lat1, int lat2){
        super(lat1,lat2,lat1,lat2,0,0,0,0);
    }
    public Paralelogram(int lat1, int lat2, double unghi1){
        super(lat1,lat2,lat1,lat2,unghi1, 180-unghi1, unghi1, 180-unghi1);
    }

    public Number arie() {
        return latura1*latura2*Math.sin(Math.toRadians(unghi1));
    }
}
