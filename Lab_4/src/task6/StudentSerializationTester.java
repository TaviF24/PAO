package task6;

import task6.serialization.StudentStorage;
import task6.utils.FileUtils;
import task6.utils.StudentGenerator;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

public class StudentSerializationTester {
    private final StudentStorage storage;

    public StudentSerializationTester(StudentStorage storage) {
        this.storage = storage;
    }

    public void runTests() {
        try {
            testWithSingleStudent();
            testWithMultipleStudents();
        }
        catch (IOException e) {
            System.err.println("Something threw IOException:\n" + Arrays.toString(e.getStackTrace()));
        }
        catch (ClassNotFoundException e){
            System.err.println("Something threw ClassNotFoundException:\n" + Arrays.toString(e.getStackTrace()));
        }
    }


    private void testWithSingleStudent() throws IOException, ClassNotFoundException {
        String filePath = "./singleStudent.out";
        String formatedFilePath = "./singleStudentFormated.out";
        List<Student> studentList = (new StudentGenerator()).generateStudents(1);
        String testName = "single student serialization/deserialization";

        runSerializationDeserializationTest(filePath, formatedFilePath, studentList, testName);
    }

    private void testWithMultipleStudents() throws IOException, ClassNotFoundException {
        String filePath = "./multipleStudents.out";
        String formatedFilePath = "./multipleStudentFormated.out";
        List<Student> studentList = (new StudentGenerator()).generateStudents(5);
        String testName = "multiple students serialization/deserialization";

        runSerializationDeserializationTest(filePath, formatedFilePath, studentList, testName);
    }

    private void runSerializationDeserializationTest(String filePath, String formatedFilePath, List<Student> studentList, String testName) throws IOException, ClassNotFoundException {
        writeStudentList(filePath, studentList);
        writeStudentListFormated(formatedFilePath,studentList);

        List<Student> studentsFromFile = readStudentList(filePath);
        List<Student> studentsFromFormatedFile = readStudentListFormated(formatedFilePath);


        if (studentList.equals(studentsFromFile)) {
            System.out.println("Passed test: " + testName + "!");
        } else {
            System.err.println("Failed test: " + testName + "!");
        }

        if(studentList.equals(studentsFromFormatedFile)) {
            System.out.println("Passed test: " + testName + " txt formatted!\n");
        }else {
            System.err.println("Failed test: " + testName + " txt formatted!\n");
        }
    }

    private List<Student> readStudentList(String filePath) throws IOException, ClassNotFoundException {
        List<Student> studentsFromFile;
        try (InputStream fileIn = FileUtils.openFileForReading(filePath)) {
            studentsFromFile = storage.readAllStudents(fileIn);
        }
        return studentsFromFile;
    }

    private List<Student> readStudentListFormated(String formatedFilePath) throws IOException, ClassNotFoundException{
        List<Student> studentsFromFile;
        try (InputStream fileIn = FileUtils.openFileForReading(formatedFilePath)) {
            studentsFromFile = storage.readAllStudentsFormated(fileIn);
        }
        return studentsFromFile;
    }

    private void writeStudentList(String filePath, List<Student> studentList) throws IOException {
        try (OutputStream fileOut = FileUtils.openFileForWriting(filePath,false)) {
            storage.writeAllStudents(fileOut, studentList);
        }
    }

    private void writeStudentListFormated(String filePath, List<Student> studentList) throws IOException {
        try (OutputStream fileOut = FileUtils.openFileForWriting(filePath,false)) {
            storage.writeAllStudentsFormated(fileOut, studentList);
        }
    }

}
