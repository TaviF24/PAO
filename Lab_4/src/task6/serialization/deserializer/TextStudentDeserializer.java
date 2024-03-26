package task6.serialization.deserializer;

import task6.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TextStudentDeserializer implements StudentDeserializer{
    @Override
    public Student deserializer(InputStream inputStream) throws IOException {

        int data = inputStream.read();
        if(data==-1)
            throw new IOException("Here");
        char c = (char)data;
        int size;
        StringBuilder fullname = new StringBuilder();
        StringBuilder keyValue = new StringBuilder();
        while(c!='\n'){
            fullname.append(c);
            c=(char)inputStream.read();
        }

        Student student = new Student(fullname.toString());
        size = Integer.parseInt(String.valueOf((char)inputStream.read()));
        inputStream.read();

        for(int i=0;i<size;i++){
            c = (char)inputStream.read();
            int lineSize = 0;
            while(c!='\n'){
                keyValue.append(c);
                c=(char)inputStream.read();
                lineSize++;
            }

            String[] line = keyValue.toString().split(" -> ");
            student.addCourseInformation(line[0],Double.parseDouble(line[1]));
            keyValue.delete(0,lineSize);
        }

        inputStream.read();
        return student;
    }
}
