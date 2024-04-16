package task3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args){

        for(int i=0;i<10;i++){
            String fileName = "src/task3/fisier_"+i+".txt";

            try(FileWriter fileWriter = new FileWriter(fileName)){
                fileWriter.write(i+"\n");
                fileWriter.write(LocalDateTime.now().toString());
            }
            catch (IOException e){
                System.err.println(e.getMessage());
            }
        }

    }
}
