package lab1.task1;

import lab1.task2.Course;
import lab1.task2.Student;
import lab1.task2.StudentAllocator;
import lab1.task4.DummyCalculator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //--------------------TASKs 1 2 3--------------------//
        Course course = new Course("Matematica",5.00, StudentAllocator.createStudents());

        Student studTest = course.chooseStudentRandomly();

        System.out.println(studTest);
        System.out.println(Arrays.toString(course.showAllPassingStudents()));
        System.out.println(course.isStudentPassing(1));

        System.out.println(course.isStudentPassing(studTest)+"\n");

        //--------------------TASK 4--------------------//
        DummyCalculator calculator = new DummyCalculator();
        Scanner input = new Scanner(System.in);

        String[] ecuation = input.nextLine().split("\\s+"); // eliminates all spaces between words
        while(!ecuation[0].equals("quit")){
            calculator.calculate(ecuation);
            ecuation = input.nextLine().split("\\s+");
        }

    }
}
