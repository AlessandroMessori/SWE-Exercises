package IntegerSet;

public class Main {

    public static void main(String[] args) {

        Coll c1 = new Coll(100);

        c1.throwError();

        c1.add(5);
        c1.add(10);
        c1.add(2);
        c1.add(15);
        c1.add(7);
        c1.add(1);
        c1.add(5);
        c1.add(105);
        c1.print();
    }
}
