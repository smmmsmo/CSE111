# Quiz 2 - ADU

## Quiz2 Class

```java
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
```

## Quiz2Tester Class

```java
public class Quiz2Tester {
    public static void main(String[] args) {
        Quiz2 p = new Quiz2();
        int[] r = { 4, 5, 0 };
        p.method(r, p);
    }
}
```

## Expected Output

```
27 7 4
4 7 8
13 8 30
```

---

### Method Execution Flow

#### 1. Constructor calls **method(20, 17)**

**Initial State:** a=17, b=5, temp=1, r={2,6}

**method(int a, int b)** with parameters (20, 17):

```
Step 1: a += temp - b
        a = 20 + 1 - 17 = 4 (local variable)

Step 2: temp = this.temp - r[0] + this.b
        temp = 1 - 2 + 5 = 4 (instance variable)

Step 3: r[0] = r[1]++ + b + temp
        r[0] = 6 + 17 + 4 = 27, r[1] becomes 7

Step 4: Print "27 7 4" (r[0], r[1], local a)

Step 5: Return temp = 4
```

**After method(20,17):** a=17, b=5, temp=4, r={27,7}

**Constructor completion:** this.a += 4 → a = 17 + 4 = 21

#### 2. Tester calls **method(r, p)** with r={4,5,0}

**Initial State:** a=21, b=5, temp=4, r={27,7}

**method(int[] r, Quiz2 p)** with parameters ({4,5,0}, p):

```
Step 1: p.b = this.a + temp - p.b
        p.b = 21 + 4 - 5 = 20

Step 2: temp = p.temp + r[0]
        temp = 4 + 4 = 8 (instance variable)

Step 3: a = this.r[0] + r[1]
        a = 27 + 5 = 32 (instance variable)

Step 4: Print "4 7 8" (r[0], this.r[1], p.temp)

Step 5: Call p.method(this.r[0], r[1]) → method(27, 5)
```

#### 3. Nested call **method(27, 5)**

**Current State:** a=32, b=20, temp=8, r={27,7}

**method(int a, int b)** with parameters (27, 5):

```
Step 1: a += temp - b
        a = 27 + 8 - 5 = 30 (local variable)

Step 2: temp = this.temp - r[0] + this.b
        temp = 8 - 27 + 20 = 1 (instance variable)

Step 3: r[0] = r[1]++ + b + temp
        r[0] = 7 + 5 + 1 = 13, r[1] becomes 8

Step 4: Print "13 8 30" (r[0], r[1], local a)

Step 5: Return temp = 1
```

**Back to method(r,p):**
```
Step 6: p.a = b + p.method(27,5) + p.b
        p.a = 20 + 1 + 20 = 41
```

**Final State:** a=41, b=20, temp=1, r={13,8}

### Variable State Tracking

| Step | a  | b  | temp | r[]     | Action |
|------|----|----|------|---------|--------|
| 1    | 3  | 4  | 1    | {2,6}   | Initial |
| 2    | 17 | 5  | 4    | {27,7}  | After constructor step 1 |
| 3    | 21 | 20 | 8    | {13,8}  | After constructor method call |
| 4    | 30 | -  | 1    | -       | After method(r,p) execution |
| 5    | 41 | -  | -    | -       | Final state |

---
                             
                                                                   
                                                                   