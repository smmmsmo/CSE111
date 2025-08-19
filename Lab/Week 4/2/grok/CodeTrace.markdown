# Code Trace - TracingX

## TracingX Class
```java
class TracingX {
  public int x, y = 1;
  public int metA(int y) {
    y += x + 3;
    int temp = y + this.y;
    if (temp % 2 == 0) {
      return temp;
    }
    TracingX t = new TracingX();
    t.y = this.x - (++x) + t.x;
    this.y = y + t.metA(t.x);
    System.out.println(x + " " + y + " " + temp);
    return temp + this.y;
  }
}
```

## TesterX Class
```java
public class TesterX {
  public static void main(String[] args) {
    TracingX t1 = new TracingX();
    t1.y = t1.x = 5;
    TracingX t2 = new TracingX();
    t2.x = t1.metA(2);
    t2.y = t2.metA(4);
    System.out.println(t1.y + t1.x + " " + t2.x + " " + t2.y);
  }
}
```

---

## **Main Method Execution**
```java
TracingX t1 = new TracingX();
t1.y = t1.x = 5;
TracingX t2 = new TracingX();
t2.x = t1.metA(2);
t2.y = t2.metA(4);
System.out.println(t1.y + t1.x + " " + t2.x + " " + t2.y);
```

**Execution line by line:**

```
Step 1: TracingX t1 = new TracingX()
        Creates t1 with x = 0, y = 1

Step 2: t1.y = t1.x = 5
        Sets t1.x = 5, t1.y = 5

Step 3: TracingX t2 = new TracingX()
        Creates t2 with x = 0, y = 1

Step 4: t2.x = t1.metA(2)
        Calls t1.metA(2), need to trace
```

## **First metA Call: t1.metA(2)**
**Inside metA(int y):**
- Parameter: `y = 2`
- Object: `t1` with `x = 5`, `y = 5`
- Other object: `t2` with `x = 0`, `y = 1`

**metA Code:**
```java
y += x + 3;
int temp = y + this.y;
if (temp % 2 == 0) {
  return temp;
}
TracingX t = new TracingX();
t.y = this.x - (++x) + t.x;
this.y = y + t.metA(t.x);
System.out.println(x + " " + y + " " + temp);
return