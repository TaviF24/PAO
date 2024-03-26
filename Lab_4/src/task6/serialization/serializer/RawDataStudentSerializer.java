package task6.serialization.serializer;

import task6.Student;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class RawDataStudentSerializer implements StudentSerializer {
    @Override
    public void serialize(OutputStream outputStream, Student student) throws IOException {
        // TODO 3:  Realizati serializarea pentru un singur student

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(student);
        objectOutputStream.flush();
    }
}
