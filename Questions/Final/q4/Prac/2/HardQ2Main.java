class A {
    public static int s = 5;
    public int x = 1, sum = 0;

    public A() {
        s = s + 2;
        sum = x + s;
    }

    public A(int n) {
        this();
        sum = sum + n;
        s = s - n;
    }

    public void show(int m) {
        x = x + m + s;
        sum = sum + x;
        System.out.println("A: " + x + " " + sum + " " + s);
    }
}

class B extends A {
    public static int t = 3;
    public int y = 2;

    public B() {
        super(2);
        t = t + s;
        sum = sum + t;
    }

    public B(int k) {
        this();
        y = y + k + t;
        sum = sum + y;
    }

    @Override
    public void show(int m) {
        super.show(m + 1);
        y = y + s + m;
        x = y - m;
        sum = sum + y;
        System.out.println("B: " + x + " " + y + " " + sum + " " + t);
    }
}

public class HardQ2Main {
    public static void main(String[] args) {
        B b1 = new B();
        B b2 = new B(3);
        b1.show(2);
        b2.show(1);
    }
}
