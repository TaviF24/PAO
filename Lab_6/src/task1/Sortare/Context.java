package task1.Sortare;

import task1.Student;

import java.util.List;

public class Context {

    private AbstractSortare sortare;

    public void setSortare(AbstractSortare sortare) {
        this.sortare = sortare;
    }

    public List<Student> executaSortare(){
        return sortare.sorteaza();
    }

    public void print(){
        sortare.printSorted();
    }

}
