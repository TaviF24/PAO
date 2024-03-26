package task6.serialization.serializer;

import task6.Student;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.StringTokenizer;

public class TextStudentSerializer implements StudentSerializer {
    @Override
    public void serialize(OutputStream outputStream, Student student) {
        PrintStream printStream = new PrintStream(outputStream);

        String fullName = student.getFullName();
        Map<String, Double> courseInformation = student.getCourseInformation();

        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer = new StringTokenizer(courseInformation.toString(), "={, }");

        stringBuilder.append(fullName).append("\n").append(courseInformation.size()).append("\n");
        while(stringTokenizer.hasMoreElements()){
            String nextToken = stringTokenizer.nextToken();

            if(Character.isDigit(nextToken.charAt(0))){
                stringBuilder.append("-> ").append(nextToken).append("\n");
            }else{
                stringBuilder.append(nextToken).append(" ");
            }
        }
        printStream.println(stringBuilder);
    }
}
