package task1;

import task1.Sortare.Context;
import task1.Sortare.MedieSortare;
import task1.Sortare.NotaPartialSortare;
import task1.Sortare.NotaTotalaSortare;

import java.util.ArrayList;
import java.util.List;


/*
Design patterns used:
    - Builder
    - Strategy
*/


public class Main {
    public static void main(String[] args){
        Student student1 = new Student.Builder("Aurel", "Vlaicu")
                        .setNotaLaborator(5.2)
                        .setNotaPartial(7.8)
                        .setNotaExamen(9.0)
                        .build();
        Student student2 = new Student.Builder("Liviu", "Teodorescu")
                .setNotaLaborator(7.8)
                .setNotaPartial(5.3)
                .setNotaExamen(9.0)
                .build();

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        Context context = new Context();

        context.setSortare(new NotaTotalaSortare(students));
        context.executaSortare();
        context.print();

        context.setSortare(new MedieSortare(students));
        context.executaSortare();
        context.print();

        context.setSortare(new NotaPartialSortare(students));
        context.executaSortare();
        context.print();
    }
}
