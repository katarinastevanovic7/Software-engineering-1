package exercise07;

public class Pair<L, R> {
    private final L left;
    private final R right;

    public Pair(L left, R right) {
        if (left == null || right == null) {
            throw new IllegalArgumentException("left and right cannot be null");
        }
        this.left = left;
        this.right = right;
    }

    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    //gibt den Inhalt des paares aus
    public String toString() {
        return "(" + left + ", " + right + ")";
    }

    public static <A extends Number, B extends Number> double average(Pair<A, B> pair) {
        return (pair.getLeft().doubleValue() + pair.getRight().doubleValue()) / 2.0;
    }
}
