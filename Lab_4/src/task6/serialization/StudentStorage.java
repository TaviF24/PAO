package task6.serialization;

import task6.serialization.deserializer.RawDataStudentDeserializer;
import task6.serialization.deserializer.StudentDeserializer;
import task6.serialization.deserializer.TextStudentDeserializer;
import task6.serialization.serializer.RawDataStudentSerializer;
import task6.serialization.serializer.StudentSerializer;
import task6.Student;
import task6.serialization.serializer.TextStudentSerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentStorage {
    private final StudentSerializer serializer;
    private final StudentDeserializer deserializer;

    public StudentStorage(StudentSerializer serializer, StudentDeserializer deserializer) {
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    public List<Student> readAllStudents(InputStream inputStream) throws IOException, ClassNotFoundException {
        // TODO 6: Cu ajutorul deserializatorului, cititi din sursa studentii

        List<Student>list = new ArrayList<>();
        RawDataStudentDeserializer rawDataStudentDeserializer = new RawDataStudentDeserializer();
        boolean endOfStream = false;

        while(!endOfStream){
            try{
                list.add(rawDataStudentDeserializer.deserializer(inputStream));
            }
            catch (IOException e){
                endOfStream = true;
            }
        }
        return list;
    }

    public List<Student> readAllStudentsFormated(InputStream inputStream) throws IOException {
        List<Student>list = new ArrayList<>();
        TextStudentDeserializer textStudentDeserializer = new TextStudentDeserializer();

        boolean endOfStream = false;

        while(!endOfStream){
            try{
                list.add(textStudentDeserializer.deserializer(inputStream));
            }
            catch (IOException e){
                endOfStream = true;
            }
        }

        System.out.println("\n----------------------------------Start printing the list of serialized objects----------------------------------");
        for(Student student : list){
            System.out.println(student.getFullName());
            System.out.println(student.getCourseInformation());
            System.out.println();
        }
        System.out.println("----------------------------------Done printing the list of deserialized objects----------------------------------\n\n");

        return list;
    }

    public void writeAllStudents(OutputStream outputStream, List<Student> students) throws IOException {
        // TODO 5: Cu ajutorul serializatorului, scrieti in sursa studentii

        RawDataStudentSerializer rawDataStudentSerializer = new RawDataStudentSerializer();

        for(Student student : students)
            rawDataStudentSerializer.serialize(outputStream,student);
    }

    public void writeAllStudentsFormated(OutputStream outputStream, List<Student> students) throws IOException {

        TextStudentSerializer textStudentSerializer = new TextStudentSerializer();

        for(Student student : students)
            textStudentSerializer.serialize(outputStream,student);
    }

}
