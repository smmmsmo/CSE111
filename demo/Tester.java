//Design Class: 
class TracingProblem {
    public int temp = 4, x, sum = 2;

    public TracingProblem() {
        this.x = 3;
        sum += x;
        temp--;
    }

    public void methodA(TracingProblem t5) {
        int x = 1;
        methodB(this);
        this.temp = t5.temp + x;
        this.x = x + (++sum);
        sum = sum + this.x;
        System.out.println(this.x + " " + temp + " " + sum);
    }

    public void methodB(TracingProblem t1) {
        this.temp = t1.temp + t1.x;
        this.x = t1.sum + sum;
        t1.x += this.x;
        System.out.println(this.x + " " + this.temp + " " + t1.x);
    }
}

// Tester Class:

public class Tester {
    public static void main(String[] args) {
        TracingProblem t1 = new TracingProblem();
        TracingProblem t3 = new TracingProblem();
        t3.methodA(t1);
    }
}
