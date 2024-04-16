package task2;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args){

        /*------M1------*/
        try(FileReader input = new FileReader("src/task2/input.txt")){
            input.skip(19);
            while (input.ready()){
                System.out.print((char)input.read());
            }
        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }

        /*------M2------*/
        try(FileReader input = new FileReader("src/task2/input.txt")){

            char toPrint = ' ';
            if(input.ready()){
                toPrint = (char) input.read();
            }

            while (input.ready() && toPrint!='\n') {
                toPrint = (char) input.read();
            }

            char[] buf = new char[15];
            if (input.ready()) {
                input.read(buf);
            }
            for(char c : buf){
                if(c==0)
                    break;
                System.out.print(c);
            }

        }
        catch (IOException e){
            System.err.println(e.getMessage());
        }

    }
}
