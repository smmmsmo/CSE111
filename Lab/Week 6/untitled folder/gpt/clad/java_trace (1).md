# Quiz 5 - Code Trace

## Foo Class

```java
class Foo{
  public int bar, buz;
  public Foo(int bar, int buz){
    this.bar = bar;
    this.buz = buz;
  }
}
```

## Quiz5 Class

```java
class Quiz5{
  public int sum = 12, x = 2, y = 6;
  public Foo foo;
  public Quiz5(Foo f){
    foo = f;
    int x = this.foo.buz + y;
    sum = sum + (f.bar--) + y;
    System.out.println(foo.bar + " " + sum + " " + x);
    sum -= 10;
  }
  public void methodA(int bar, int buz){
    bar = 3 + bar - this.foo.bar;
    x = bar + 12 + y;
    y = foo.buz + buz + bar;
    sum = y + methodB(foo.buz, foo) + foo.buz;
    System.out.println(bar + " " + y + " " + sum);
  }
  public int methodB(int bar, Foo buz){
    int sum = bar + buz.bar + x;
    buz.buz = sum + this.sum;
    System.out.println(bar + " " + buz.buz + " " + sum);
    return sum;
  }
}
```

## LabTester Class

```java
public class LabTester{
  public static void main(String []args){
    Foo p = new Foo(3, 4);
    Quiz5 q = new Quiz5(p);
    q.methodA(4, 8);
  }
}
```

## Expected Output

```
2 21 10
4 40 29
5 17 86
```

---

### Method Execution Flow

#### 1. Main creates **Foo object p**

**Foo p = new Foo(3, 4)**

```
Initial Foo object: bar=3, buz=4
```

#### 2. Constructor **Quiz5(p)** is called

**Initial State:** sum=12, x=2, y=6, foo=null

**Quiz5(Foo f)** with parameter f pointing to Foo object:

```
Step 1: foo = f (foo now references the Foo object)

Step 2: int x = this.foo.buz + y
        x = 4 + 6 = 10 (local variable, shadows instance x)

Step 3: sum = sum + (f.bar--) + y
        sum = 12 + 3 + 6 = 21 (f.bar becomes 2 after post-decrement)

Step 4: Print "2 21 10" (foo.bar, sum, local x)

Step 5: sum -= 10
        sum = 21 - 10 = 11
```

**After constructor:** sum=11, x=2, y=6, foo.bar=2, foo.buz=4

#### 3. Main calls **q.methodA(4, 8)**

**Initial State:** sum=11, x=2, y=6, foo.bar=2, foo.buz=4

**methodA(int bar, int buz)** with parameters (4, 8):

```
Step 1: bar = 3 + bar - this.foo.bar
        bar = 3 + 4 - 2 = 5 (local parameter)

Step 2: x = bar + 12 + y
        x = 5 + 12 + 6 = 23 (instance variable)

Step 3: y = foo.buz + buz + bar
        y = 4 + 8 + 5 = 17 (instance variable)

Step 4: sum = y + methodB(foo.buz, foo) + foo.buz
        Need to call methodB(4, foo) first
```

#### 4. Nested call **methodB(4, foo)**

**Current State:** sum=11, x=23, y=17, foo.bar=2, foo.buz=4

**methodB(int bar, Foo buz)** with parameters (4, foo reference):

```
Step 1: int sum = bar + buz.bar + x
        sum = 4 + 2 + 23 = 29 (local variable)

Step 2: buz.buz = sum + this.sum
        buz.buz = 29 + 11 = 40 (modifies foo.buz to 40)

Step 3: Print "4 40 29" (bar parameter, buz.buz, local sum)

Step 4: Return sum = 29
```

**Back to methodA:**
```
Step 4 (continued): sum = y + methodB(4, foo) + foo.buz
                   sum = 17 + 29 + 40 = 86

Step 5: Print "5 17 86" (local bar, instance y, instance sum)
```

**Final State:** sum=86, x=23, y=17, foo.bar=2, foo.buz=40

### Variable State Tracking

| Step | sum | x  | y  | foo.bar | foo.buz | Action |
|------|-----|----|----|---------|---------| -------|
| 1    | 12  | 2  | 6  | 3       | 4       | Initial state |
| 2    | 11  | 2  | 6  | 2       | 4       | After constructor |
| 3    | 11  | 23 | 17 | 2       | 4       | After methodA steps 1-3 |
| 4    | 11  | 23 | 17 | 2       | 40      | During methodB execution |
| 5    | 86  | 23 | 17 | 2       | 40      | Final state |

### Key Observations

1. **Variable Shadowing:** Local variable `x` in constructor shadows instance variable `x`
2. **Post-decrement Operation:** `f.bar--` uses current value (3) then decrements to 2
3. **Object Reference Sharing:** All references point to the same Foo object
4. **State Mutation:** methodB modifies the shared object's `buz` field from 4 to 40
5. **Parameter vs Instance Variables:** Local parameters can have same names as instance variables

---