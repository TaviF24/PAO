package task1.Sortare;

import task1.Student;

import java.util.List;

public class NotaTotalaSortare extends AbstractSortare {

    public NotaTotalaSortare(List<Student> students) {
        super("Sortare după cea mai mare notă totală", students);
    }

    @Override
    public List<Student> sorteaza() {
        List<Student> students = getStudents();
        students.sort((o2, o1) -> {
            Double total1 = o1.getNotaLaborator() + o1.getNotaPartial() + o1.getNotaExamen();
            Double total2 = o2.getNotaLaborator() + o2.getNotaPartial() + o2.getNotaExamen();
            return total1.compareTo(total2);
        });
        return students;
    }
}
