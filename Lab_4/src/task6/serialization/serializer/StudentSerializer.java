package task6.serialization.serializer;

import task6.Student;

import java.io.IOException;
import java.io.OutputStream;

public interface StudentSerializer {
    void serialize(OutputStream outputStream, Student student) throws IOException;
}
