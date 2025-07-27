public class Quiz2 {
  public int a = 3, b = 4, temp = 1;
  public int[] r = { 2, 6 };

  public Quiz2() {
    int temp = b * (++b);
    a = temp - a;
    this.a += this.method(temp, a);
  }

  public void method(int[] r, Quiz2 p) {
    p.b = this.a + temp - p.b;
    temp = p.temp + r[0];
    a = this.r[0] + r[1];
    System.out.println(r[0] + " " + this.r[1] + " " + p.temp);
    p.a = b + p.method(this.r[0], r[1]) + p.b;
  }

  public int method(int a, int b) {
    a += temp - b;
    temp = this.temp - r[0] + this.b;
    r[0] = r[1]++ + b + temp;
    System.out.println(r[0] + " " + r[1] + " " + a);
    return temp;
  }
}
