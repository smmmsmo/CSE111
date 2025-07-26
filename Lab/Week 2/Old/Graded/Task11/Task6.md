# Task 6

## TraceDesign Class

```java
public class TraceDesign {
    public int p = 3, y = 2, sum;

    public void methodA() {
        int x = 0, y = 0;
        y = y + this.y;
        x = sum + 2 + p;
        sum = x + y + methodB(p, y);
        System.out.println(x + " " + y + " " + sum);
    }

    public int methodB(int p, int n) {
        int x = 0;
        y = y + (++p);
        x = x + 2 + n;
        sum = sum + x + y;
        System.out.println(x + " " + y + " " + sum);
        return sum;
    }
}
```

## TraceDesignTester Class

```java
public class TraceDesignTester {
    public static void main(String[] args) {
        TraceDesign t1 = new TraceDesign();
        t1.methodA();
        t1.methodA();
    }
}
```

## Output

| x | y | sum |
|---|---|-----|
| 4 | 6 | 15  |
| 5 | 2 | 15  |
| 6 | 8 | 27  |
| 7 | 2 | 27  |