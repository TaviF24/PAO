package task1;

import java.util.Comparator;

public class Student {
    private String nume;
    private String prenume;
    private Double notaLaborator;
    private Double notaPartial;
    private Double notaExamen;

    @Override
    public String toString() {
        return prenume + " " + nume + " " + notaLaborator + " " + notaPartial + " " + notaExamen;
    }

    private Student(){};

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public Double getNotaLaborator() {
        return notaLaborator;
    }

    public Double getNotaPartial() {
        return notaPartial;
    }

    public Double getNotaExamen() {
        return notaExamen;
    }

    public static class Builder{
        private final String nume;
        private final String prenume;
        private double notaLaborator = 0.0;
        private double notaPartial = 0.0;
        private double notaExamen = 0.0;

        public Builder(String prenume, String nume){
            this.prenume = prenume;
            this.nume = nume;
        }

        public Builder setNotaLaborator(double notaLaborator) {
            this.notaLaborator = notaLaborator;
            return this;
        }

        public Builder setNotaPartial(double notaPartial) {
            this.notaPartial = notaPartial;
            return this;
        }

        public Builder setNotaExamen(double notaExamen) {
            this.notaExamen = notaExamen;
            return this;
        }

        public Student build(){
            Student student = new Student();
            student.nume = this.nume;
            student.prenume = this.prenume;
            student.notaLaborator = this.notaLaborator;
            student.notaPartial = this.notaPartial;
            student.notaExamen = this.notaExamen;
            return student;
        }
    }
}
