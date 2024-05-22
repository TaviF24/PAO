package task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FilePrinter {
    public static void printFromHash(String fileName, HashMap<String, Long> hashMap){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            for (Map.Entry<String, Long> entry : hashMap.entrySet()) {
                writer.append(entry.getKey())
                        .append(" -> ")
                        .append(String.valueOf(entry.getValue()*1.0/1_000_000_000))
                        .append(" seconds\n");
            }
            writer.append("\n\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
