package task6.serialization.deserializer;

import task6.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class RawDataStudentDeserializer implements StudentDeserializer{
    @Override
    public Student deserializer(InputStream inputStream) throws IOException, ClassNotFoundException {
        // TODO 4:  Realizati deserializarea pentru un singur student

        ObjectInputStream in = new ObjectInputStream(inputStream);
        return (Student)in.readObject();
    }
}