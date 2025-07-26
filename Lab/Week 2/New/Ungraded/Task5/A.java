public class A {
    public int temp = 4;
    public int sum, y, x;

    public void methodA(int m) {
        int[] n = { 2, 5 };
        int x = 0;
        y = m + this.methodB(x++, m) + (temp++);
        x = this.x + 2 + n[0];
        sum = sum + x + y;
        n[0] = sum + 2;
        System.out.println(n[0] + " " + x + " " + sum);
    }

    public int methodB(int m, int n) {
        int y = 4 + this.y + m;
        x = this.y + y + (++temp) - n;
        sum = x + y + this.sum;
        System.out.println(y + " " + this.x + " " + sum);
        return x;
    }
}
