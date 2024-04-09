package task1.Sortare;

import task1.Student;

import java.util.List;

public abstract class AbstractSortare implements Sortare {

    private final String tipSortare;
    private final List<Student> students;


    public AbstractSortare(final String tipSortare, List<Student> students) {
        this.tipSortare = tipSortare;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    void printSorted(){
        System.out.println(tipSortare);

        int index = 1;
        for(Student student : students){
            System.out.println(index++ + ". " + student);
        }
        System.out.println();
    }
}
