# Task 6

## Design Class

```java
public class Design {

        public int sum;
        public int y;

        public void methodA() {
            int x = 2, y = 3;
            int[] msg = { 3, 7 };
            y = this.y + msg[0];
            methodB(msg[1]++, msg[0]);
            x = x + this.y + msg[1];
            sum = x + y + msg[0];
            System.out.println(x + " " + y + " " + sum);
        }

        public void methodB(int mg2, int mg1) {
            int x = 0;
            y = this.y + mg2;
            x = x + 19 + mg1;
            sum = this.sum + x + y;
            mg2 = y + mg1;
            mg1 = mg2 + x + 2;
            System.out.println(x + " " + y + " " + sum);
        }
    }
```

## DesignTester Class

```java
public class DesignTester {
      public static void main (String args[]){
    Design t1 = new Design();
    t1.methodB(5,-8);
    Design t2 = new Design();
    t2.methodA();
  }
}
```

## Output

| x | y | sum |
|---|---|-----|
| 11 | 5 | 16 |
| 10 | 7 | 20 |
