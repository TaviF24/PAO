package lab1.task2;

public class StudentAllocator {
    static public Student[] createStudents(){
        Student[] stud = {new Student("Mihai",4.7),
                        new Student("Cristi",8.9),
                        new Student("Andrei",5.85),
                        new Student("Andreea",7.46)};
        return stud;
    };
}
