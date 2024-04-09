package task1.Sortare;

import task1.Student;

import java.util.List;

public class NotaPartialSortare extends AbstractSortare {
    public NotaPartialSortare(List<Student> students) {
        super("Sortare după cea mai mare notă la partial", students);
    }

    @Override
    public List<Student> sorteaza() {
        List<Student> students = getStudents();
        students.sort((o2, o1) -> {
            return o1.getNotaPartial().compareTo(o2.getNotaPartial());
        });
        return students;
    }
}
