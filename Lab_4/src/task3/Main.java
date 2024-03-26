package task3;

import java.util.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Map<String,Double> hm = new HashMap<>();
        hm.put("Mathematics",5.6);
        hm.put("Physics",9.6);
        hm.put("CS",10.0);

        Student stud1 = new Student("Matei",hm);
        Student stud2 = stud1.clone();

        hm.put("CS",8.0);
        stud2.AddCourse("English",7.9);
        stud2.setFullName("Petre");

        System.out.println(stud1);
        System.out.println(stud2);
    }
}
