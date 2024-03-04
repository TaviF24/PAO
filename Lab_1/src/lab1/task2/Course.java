package lab1.task2;
import java.util.Random;

public class Course {
    private String name;
    private Double minimumGrade;
    private Student[] students;


    public Course(String name, Double minimumGrade, Student[] students) {
        this.name = name;
        this.minimumGrade = minimumGrade;
        this.students = students;
    }

    public Student chooseStudentRandomly(){
        Random rand = new Random();
        int n = rand.nextInt(students.length);
        return students[n];
    }

    public Student[] showAllPassingStudents(){
        Student[] rValue = new Student[4];
        int index=0;

        for (int i=0;i<students.length;i++)
            if (students[i].getGrade() >= minimumGrade)
                rValue[index++]=students[i];

        return rValue;
    }

    public Boolean isStudentPassing(int index){
        if(index>students.length || index < 0)
            return false;
        else{
            if(students[index].getGrade()>minimumGrade)
                return true;
            else
                return false;
        }
    }

    public Boolean isStudentPassing(Student student){
        for (int i=0;i<students.length;i++)
            if (student.equals(students[i])){
                return student.getGrade()<=minimumGrade;
            }
        return false;
    }

}
