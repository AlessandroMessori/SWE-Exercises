package IntegerSet;

public class Coll {

    private int defaultMaxSize = 1000;
    private int maxSize;
    private int size;
    private int[] data;

    public Coll() {
        this.maxSize = this.defaultMaxSize;
        this.size = 0;
    }

    public Coll(int dim) {
        this.maxSize = dim;
        this.size = 0;
        this.size = 0;
        this.data = new int[this.maxSize];
    }

    int getMaxSize() {
        return this.maxSize;
    }

    private boolean contains(int n) {

        for (int i = 0; i < this.size; i++) {
            if (n == this.data[i]) {
                return true;
            }
        }

        return false;
    }

    public boolean add(int n) {

        if (this.contains(n) || this.size == this.maxSize) {
            return false;
        }

        this.data[this.size] = n;
        this.size++;

        return true;

    }

    public void print() {
        System.out.println("Size: " + this.size);
        System.out.print("[ ");
        for (int i = 0; i < this.size; i++) {
            System.out.print(+this.data[i] + " ");
        }
        System.out.println("]");
    }

    public void throwError() {
        try {
            int x = 6 / 0;
        } catch (ArithmeticException e) {
            System.out.println("You can't divide by zero!");
        }
    }
}
