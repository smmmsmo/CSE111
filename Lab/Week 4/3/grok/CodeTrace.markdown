# Code Trace - FinalT5A

## msgClass
```java
class msgClass {
  public int content;
}
```

## FinalT5A Class
```java
class FinalT5A {
  public int sum = 2, y = 1, x = 1;
  public void methodA() {
    int x = 6, y = 0;
    msgClass myMsg = new msgClass();
    myMsg.content = this.x;
    x = x + myMsg.content;
    this.y = this.y + methodB(myMsg, myMsg.content);
    System.out.println(x + " " + this.y + " " + sum);
    y = this.y / 2 + this.x;
    x = y + sum / 2;
    sum = x + y + myMsg.content;
    System.out.println(x + " " + y + " " + sum);
  }
  public int methodB(msgClass mg2, int mg1) {
    int x = 0;
    y = y + mg2.content;
    mg2.content = y + mg1;
    x = this.x + 3 + mg1;
    sum = sum + x + y;
    System.out.println(this.x + " " + this.y + " " + sum);
    mg2.content = sum - mg1;
    return sum;
  }
}
```

## Tester10 Class
```java
public class Tester10 {
  public static void main(String args[]) {
    FinalT5A fT5A = new FinalT5A();
    fT5A.methodA();
  }
}
```

---

## **Main Method Execution**
```java
FinalT5A fT5A = new FinalT5A();
```
- Creates `FinalT5A` object `fT5A` with:
  - `sum = 2`
  - `y = 1`
  - `x = 1`

## **MethodA Call**
```java
fT5A.methodA();
```

**Inside methodA():**
- No parameters.
- Initial state:
  - `fT5A.sum = 2`
  - `fT5A.x = 1`
  - `fT5A.y = 1`

**methodA Code:**
```java
int x = 6, y = 0;
msgClass myMsg = new msgClass();
myMsg.content = this.x;
x = x + myMsg.content;
this.y = this.y + methodB(myMsg, myMsg.content);
System.out.println(x + " " + this.y + " " + sum);
y = this.y / 2 + this.x;
x = y + sum / 2;
sum = x + y + myMsg.content;
System.out.println(x + " " + y + " " + sum);
```

**methodA execution line by line:**

```
Step 1: int x = 6, y = 0
        Local x = 6, local y = 0 (shadow instance variables)

Step 2: msgClass myMsg = new msgClass()
        Creates myMsg with myMsg.content = 0

Step 3: myMsg.content = this.x
        this.x = 1, so myMsg.content = 1

Step 4: x = x + myMsg.content
        Local x = 6 + 1 = 7

Step 5: this.y = this.y + methodB(myMsg, myMsg.content)
        Calls methodB(myMsg, 1), need to trace methodB
```

## **Nested methodB Call**
**Inside methodB(msgClass mg2, int mg1):**
- Parameters: `mg2` references `myMsg` (`mg2.content = 1`), `mg1 = 1`
- Current state:
  - `fT5A.sum = 2`
  - `fT5A.x = 1`
  - `fT5A.y = 1`
  - `myMsg.content = 1`
  - Local `x = 7`, `y = 0` in `methodA`

**methodB Code:**
```java
int x = 0;
y = y + mg2.content;
mg2.content = y + mg1;
x = this.x + 3 + mg1;
sum = sum + x + y;
System.out.println(this.x + " " + this.y + " " + sum);
mg2.content = sum - mg1;
return sum;
```

**methodB execution line by line:**

```
Step 1: int x = 0
        Local x = 0 (shadows this.x)

Step 2: y = y + mg2.content
        y is this.y = 1, mg2.content = 1, so this.y = 1 + 1 = 2

Step 3: mg2.content = y + mg1
        this.y = 2, mg1 = 1, so mg2.content = 2 + 1 = 3 (myMsg.content = 3)

Step 4: x = this.x + 3 + mg1
        this.x = 1, mg1 = 1, so local x = 1 + 3 + 1 = 5

Step 5: sum = sum + x + y
        sum = 2, local x = 5, this.y = 2, so sum = 2 + 5 + 2 = 9

Step 6: Print "1 2 9" (this.x, this.y, sum)

Step 7: mg2.content = sum - mg1
        sum = 9, mg1 = 1, so mg2.content = 9 - 1 = 8 (myMsg.content = 8)

Step 8: Return sum = 9
```

**Output from methodB: `1 2 9`**

**Back to methodA:**
```
Step 5 (continued): this.y = this.y + methodB(myMsg, myMsg.content)
                    this.y = 2 + 9 = 11

Step 6: Print "7 11 9" (local x, this.y, sum)

Step 7: y = this.y / 2 + this.x
        this.y = 11, this.x = 1, so local y = 11 / 2 + 1 = 5 + 1 = 6

Step 8: x = y + sum / 2
        local y = 6, sum = 9, so local x = 6 + 9 / 2 = 6 + 4 = 10

Step 9: sum = x + y + myMsg.content
        local x = 10, local y = 6, myMsg.content = 8, so sum = 10 + 6 + 8 = 24

Step 10: Print "10 6 24" (local x, local y, sum)
```

## **Final Output**
The program produces the following output:
```
1 2 9
7 11 9
10 6 24
```

## **Final State Summary**
- `fT5A.sum = 24`
- `fT5A.x = 1`
- `fT5A.y = 11`
- `myMsg.content = 8`