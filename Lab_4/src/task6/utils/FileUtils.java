package task6.utils;

import java.io.*;

public class FileUtils {
    public static OutputStream openFileForWriting(String path, Boolean append) throws IOException {
        // TODO 1: Deschideti fisierul pentru scriere

        return new FileOutputStream(path,append);
    }

    public static InputStream openFileForReading(String path) throws FileNotFoundException {
        // TODO 2: Deschideti fisierul pentru citire

        return new FileInputStream(path);
    }
}
