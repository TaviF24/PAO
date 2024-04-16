package task4;

public class RootSquare {
    private final int root;
    private final int square;

    public RootSquare(int root) {
        this.root = root;
        this.square = root*root;
    }

    @Override
    public String toString() {
        return "RootSquare{" +
                "root=" + root +
                ", square=" + square +
                '}';
    }
}
