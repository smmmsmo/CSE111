class P {
    public static int a = 1;
    public int x = 2, sum = 3;

    public P() {
        a = ++a + x;
        sum += a;
        methodP(1);
    }

    public void methodP(int k) {
        x = a + k;
        sum = sum + x;
        System.out.println("P: " + x + " " + sum + " " + a);
    }
}

class C extends P {
    public static int b = 2;
    public int y = 4;

    public C(int z) {
        super();
        b = b + z + a;
        sum = sum + b;
    }

    @Override
    public void methodP(int k) {
        y = b + k + a;
        x = y - k;
        sum = sum + y;
        System.out.println("C: " + x + " " + y + " " + sum + " " + b);
    }
}

public class HardQ1Main {
    public static void main(String[] args) {
        P p1 = new C(2);
        C c1 = new C(3);
        p1.methodP(2);
        c1.methodP(1);
    }
}
