package Final.Q4;

class A {
    public static int temp = 3;
    public int x = 5, sum = 2, y = 3;

    public A() {
        temp = (--temp) + temp * 2;
    }

    public A(int x) {
        y = temp - x;
        methodA(temp, y);
    }

    public void methodA(int temp, int y) {
        y = (this.temp++) + y + temp;
        x = B.x + sum + this.y;
        sum = ++sum + this.x + y;
        System.out.println(x + " " + y + " " + sum);
    }
}

class B extends A {
    public static int x = 5;

    public B() {
        x = temp + 4;
        super.temp -= 1;
    }

    public B(B b) {
        super(1);
        sum = b.sum;
        y = b.x;
    }

    public void methodA(int m, int n) {
        y = x + this.y - m;
        x = x + super.x + temp;
        sum = x + m + super.sum + n;
        System.out.println(x + " " + y + " " + sum);
    }

    public void methodB(int a, int b) {
        int y = 2;
        y = a + this.y + y;
        x = y + this.x + super.temp;
        methodA(temp, b);
        sum = x + y + this.sum;
        System.out.println(x + " " + y + " " + sum);
    }
}

public class FinalQues4 {
    public static void main(String[] args) {
        B b1 = new B();
        new B();
        B b2 = new B(b1);
        b1.methodB(3, 2);

    }
}
