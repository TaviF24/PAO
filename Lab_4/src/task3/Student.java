package task3;

import java.util.HashMap;
import java.util.Map;

public class Student implements Cloneable{
    private String fullName;
    private Map<String, Double> courseInformation;

    public Student(String fullName, Map<String, Double> courseInformation) {
        this.fullName = fullName;
        this.courseInformation = courseInformation;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void AddCourse(String name, Double grade) {
        courseInformation.put(name,grade);
    }

    @Override
    public Student clone() throws CloneNotSupportedException{
        Student clone = (Student) super.clone();
        clone.courseInformation = new HashMap<>(courseInformation);
//        clone.courseInformation.putAll(courseInformation);
        return clone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", courseInformation=" + courseInformation +
                '}';
    }
}
