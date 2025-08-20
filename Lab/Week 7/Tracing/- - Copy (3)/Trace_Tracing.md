# Quiz - Code Trace

## Tracing Class

```java
class Tracing {
    public static int x= 0, y = 0;
    public int a, b;

    public Tracing(int a, int b){
        this.a = a;
        this.b = b;
        x += 1;
        y += 2;
    }

    public void methodA(int a){
        this.a = x + a;
        this.b = this.b + this.a + this.methodB();
        System.out.println(this.a + " " + this.b + " " + x);
    }

    public int methodB(){
        this.b = y - this.b + this.a;
        System.out.println(this.a + " " + this.b + " " + x);
        x += this.b;
        return this.b;
    }

    public void methodB(Tracing t1){
        t1.b = this.y - t1.b + this.b;
        System.out.println(t1.a + " " + t1.b + " " + x);
    }
}
```

## Test9 Class

```java
public class Test9 {
    public static void main(String [] args){
        Tracing t1= new Tracing(2, 3);
        t1.methodA(1);
        Tracing t2= new Tracing(3, 4);
        t2.methodA(2);
        t1.methodB(t2);
        t2.methodB(t2);
    }
}
```

---

## **Main Method Execution**

```java
Tracing t1 = new Tracing(2, 3);
```

**Inside constructor:**
```
this.a = 2
this.b = 3
x = 0 + 1 = 1
y = 0 + 2 = 2
```

**State after t1 created:**
- `t1.a = 2`
- `t1.b = 3`
- `x = 1`
- `y = 2`

---

```java
t1.methodA(1);
```

**Inside methodA(1):**
```
Step 1: this.a = x + a = 1 + 1 = 2

Step 2: this.b = this.b + this.a + this.methodB()
        → need methodB() first
```

### **t1.methodB()**

```
Step 1: this.b = y - this.b + this.a
        b = 2 - 3 + 2 = 1

Step 2: Print "2 1 1"

Step 3: x += this.b
        x = 1 + 1 = 2

Return 1
```

**State after methodB:**
- `t1.a = 2`
- `t1.b = 1`
- `x = 2`
- `y = 2`

Output: `2 1 1`

---

Back to **t1.methodA(1):**
```
Step 2 continued:
this.b = 3 (old) + 2 + 1 = 6

Step 3: Print "2 6 2"
```

**State after methodA:**
- `t1.a = 2`
- `t1.b = 6`
- `x = 2`
- `y = 2`

Output: `2 6 2`

---

```java
Tracing t2 = new Tracing(3, 4);
```

**Inside constructor:**
```
this.a = 3
this.b = 4
x = 2 + 1 = 3
y = 2 + 2 = 4
```

**State after t2 created:**
- `t2.a = 3`
- `t2.b = 4`
- `x = 3`
- `y = 4`

---

```java
t2.methodA(2);
```

**Inside methodA(2):**
```
Step 1: this.a = x + a = 3 + 2 = 5

Step 2: this.b = this.b + this.a + this.methodB()
        → call methodB()
```

### **t2.methodB()**

```
Step 1: this.b = y - this.b + this.a
        b = 4 - 4 + 5 = 5

Step 2: Print "5 5 3"

Step 3: x += this.b
        x = 3 + 5 = 8

Return 5
```

**State after methodB:**
- `t2.a = 5`
- `t2.b = 5`
- `x = 8`
- `y = 4`

Output: `5 5 3`

---

Back to **t2.methodA(2):**
```
Step 2 continued:
this.b = 4 (old) + 5 + 5 = 14

Step 3: Print "5 14 8"
```

**State after methodA:**
- `t2.a = 5`
- `t2.b = 14`
- `x = 8`
- `y = 4`

Output: `5 14 8`

---

```java
t1.methodB(t2);
```

**Inside methodB(Tracing t1):**
```
t2.b = this.y - t2.b + this.b
     = 4 - 14 + 6 = -4

Print "5 -4 8" (t2.a, t2.b, x)
```

**State after call:**
- `t2.a = 5`
- `t2.b = -4`
- `x = 8`
- `y = 4`

Output: `5 -4 8`

---

```java
t2.methodB(t2);
```

**Inside methodB(t2):**
```
t2.b = this.y - t2.b + this.b
     = 4 - (-4) + (-4) = 4

Print "5 4 8"
```

**State after call:**
- `t2.a = 5`
- `t2.b = 4`
- `x = 8`
- `y = 4`

Output: `5 4 8`

---

## **Final Output**

```
2 1 1
2 6 2
5 5 3
5 14 8
5 -4 8
5 4 8
```

## **Final State Summary**

- `t1.a = 2`
- `t1.b = 6`

- `t2.a = 5`
- `t2.b = 4`

- `x = 8` (static)
- `y = 4` (static)
