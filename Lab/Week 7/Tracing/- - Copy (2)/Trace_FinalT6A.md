# Quiz - Code Trace

## FinalT6A Class

```java
public class FinalT6A {
  public static int temp = 3;
  public int sum;
  public int y = 2;

  public FinalT6A(int x, int p){
    temp += 3;
    y = temp - p;
    sum = FinalT6A.temp + x;
    System.out.println(x + " " + y+ " " + sum);
  }

  public void methodA(){ 
    int x=0, y =0;
    y = y + this.y;
    x = this.y + 2 + temp;
    sum = x + y + methodB(temp, y);
    System.out.println(x + " " + y+ " " + sum);
  }

  public int methodB(int temp, int n){
    int x = 0;
    y = y + (++temp);
    x = x + 2 +  n;
    sum = sum + x + y;
    System.out.println(x + " " + y+ " " + sum);
    return sum;
  }
}
```

## Test10 Class

```java
public class Test10 {
  public static void main(String [] args){
    FinalT6A q1 = new FinalT6A(2,1);
    q1.methodA();
    FinalT6A q2 = new FinalT6A(3,1);
    q2.methodB(7,8);
  }
}
```

---

## **Main Method Execution**

```java
FinalT6A q1 = new FinalT6A(2,1);
```

- Creates `q1` object with:
  - `temp = 3` (static initial)
  - `y = 2`
  - `sum = 0` (default)

**Inside constructor FinalT6A(2,1):**
```
Step 1: temp += 3
        temp = 3 + 3 = 6

Step 2: y = temp - p
        y = 6 - 1 = 5

Step 3: sum = FinalT6A.temp + x
        sum = 6 + 2 = 8

Step 4: Print "2 5 8"
```

**State after constructor:**
- `temp = 6` (static)
- `q1.y = 5`
- `q1.sum = 8`

Output: `2 5 8`

---

```java
q1.methodA();
```

**Inside methodA():**
```
Step 1: int x=0, y=0 (local variables)

Step 2: y = y + this.y
        y = 0 + 5 = 5

Step 3: x = this.y + 2 + temp
        x = 5 + 2 + 6 = 13

Step 4: sum = x + y + methodB(temp, y)
        → call methodB(6, 5)
```

---

### **q1.methodB(6,5)**

```
Step 1: int x = 0

Step 2: y = y + (++temp)
        temp = 6 + 1 = 7
        y = 5 + 7 = 12

Step 3: x = x + 2 + n
        x = 0 + 2 + 5 = 7

Step 4: sum = sum + x + y
        sum = 8 + 7 + 12 = 27

Step 5: Print "7 12 27"

Return 27
```

**State after methodB:**
- `q1.y = 12`
- `q1.sum = 27`
- `temp = 7`

Output: `7 12 27`

---

### Back to **q1.methodA()**

```
Step 4 (continued): sum = x + y + methodB(temp,y)
                    sum = 13 + 5 + 27 = 45

Step 5: Print "13 5 45"
```

**Final state after methodA:**
- `q1.y = 12`
- `q1.sum = 45`
- `temp = 7`

Output: `13 5 45`

---

```java
FinalT6A q2 = new FinalT6A(3,1);
```

**Inside constructor FinalT6A(3,1):**
```
Step 1: temp += 3
        temp = 7 + 3 = 10

Step 2: y = temp - p
        y = 10 - 1 = 9

Step 3: sum = FinalT6A.temp + x
        sum = 10 + 3 = 13

Step 4: Print "3 9 13"
```

**State after constructor:**
- `temp = 10` (static)
- `q2.y = 9`
- `q2.sum = 13`

Output: `3 9 13`

---

```java
q2.methodB(7,8);
```

**Inside q2.methodB(7,8):**
```
Step 1: int x = 0

Step 2: y = y + (++temp)
        temp = 10 + 1 = 11
        y = 9 + 11 = 20

Step 3: x = x + 2 + n
        x = 0 + 2 + 8 = 10

Step 4: sum = sum + x + y
        sum = 13 + 10 + 20 = 43

Step 5: Print "10 20 43"

Return 43
```

**Final state after methodB:**
- `q2.y = 20`
- `q2.sum = 43`
- `temp = 11`

Output: `10 20 43`

---

## **Final Output**

```
2 5 8
7 12 27
13 5 45
3 9 13
10 20 43
```

## **Final State Summary**

- `q1.y = 12`
- `q1.sum = 45`

- `q2.y = 20`
- `q2.sum = 43`

- `temp = 11` (static)
