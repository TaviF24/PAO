package task1;

public class Main {
    public static void main(String[] args){

//        throw new JustMyFirstException();

        try{
            throw new JustMyFirstException();
        }
        catch (JustMyFirstException e){
            System.out.println(e.getMessage());
        }
    }
}
