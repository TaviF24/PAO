package task1;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args){

        /*------M1------*/
        try(FileInputStream fileInputStream = new FileInputStream("src/task1/input.txt")){
            fileInputStream.skip(19);
            while (fileInputStream.available() > 0) {
                char toPrint = (char) fileInputStream.read();
                System.out.print(toPrint);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        /*------M2------*/
        try(FileInputStream fileInputStream = new FileInputStream("src/task1/input.txt")){
            
            char toPrint = ' ';
            if(fileInputStream.available()>0){
                toPrint = (char) fileInputStream.read();
            }

            while (fileInputStream.available() > 0 && toPrint!='\n') {
                toPrint = (char) fileInputStream.read();
            }

            while (fileInputStream.available() > 0) {
                toPrint = (char) fileInputStream.read();
                System.out.print(toPrint);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
