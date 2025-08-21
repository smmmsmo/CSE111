# Code Trace - Tracing Class

## Tracing Class

```java
class Tracing {
    public static int x= 0, y = 0;
    public int a, b;
    public Tracing(int a, int b){
        this.a = a;
        this.b = b;
        x+=1;
        y+=2;
    }
    public void methodA(int a){
        this.a = x+a;
        this.b = this.b+ this.a +this.methodB();
        System.out.println(this.a+" "+this.b+" "+x);
    }
    public int methodB(){
        this.b = y - this.b + this.a;
        System.out.println(this.a+" "+this.b+" "+x);
        x += this.b;
        return this.b;
    }
    public void methodB(Tracing t1){
        t1.b = this.y - t1.b + this.b;
        System.out.println(t1.a+" "+t1.b+" "+x);
    }
}
```

## Test9 Class

```java
public class Test9{
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

**Initial static state:**
- `Tracing.x = 0`
- `Tracing.y = 0`

```java
Tracing t1= new Tracing(2, 3);
```

## First Constructor Call
**Inside Tracing(int a, int b):**
- Parameters: `a = 2`, `b = 3`

**Initial instance state for t1:**
- `t1.a = 0` (default value)
- `t1.b = 0` (default value)

**Constructor Code:**
```java
this.a = a;
this.b = b;
x+=1;
y+=2;
```

**Constructor execution line by line:**

```
Step 1: this.a = a
        t1.a = 2

Step 2: this.b = b
        t1.b = 3

Step 3: x += 1
        x = 0 + 1 = 1 (static variable Tracing.x = 1)

Step 4: y += 2
        y = 0 + 2 = 2 (static variable Tracing.y = 2)
```

**State after t1 constructor:**
- `Tracing.x = 1`
- `Tracing.y = 2`
- `t1.a = 2`
- `t1.b = 3`

## **First methodA Call**
```java
t1.methodA(1);
```

**Inside t1.methodA(int a):**
- Parameter: `a = 1`

**Current State:**
- `Tracing.x = 1`
- `Tracing.y = 2`
- `t1.a = 2`
- `t1.b = 3`

**methodA Code:**
```java
this.a = x+a;
this.b = this.b+ this.a +this.methodB();
System.out.println(this.a+" "+this.b+" "+x);
```

**methodA execution line by line:**

```
Step 1: this.a = x + a
        t1.a = 1 + 1 = 2

Step 2: this.b = this.b + this.a + this.methodB()
        Need to call methodB() first: this.b + this.a + methodB()
        = 3 + 2 + methodB()
```

## Nested methodB Call on t1
**Inside t1.methodB():**

**Current State:**
- `Tracing.x = 1`
- `Tracing.y = 2`
- `t1.a = 2`
- `t1.b = 3`

**methodB Code:**
```java
this.b = y - this.b + this.a;
System.out.println(this.a+" "+this.b+" "+x);
x += this.b;
return this.b;
```

**methodB execution line by line:**

```
Step 1: this.b = y - this.b + this.a
        t1.b = 2 - 3 + 2 = 1

Step 2: Print "2 1 1" (t1.a, t1.b, static x)

Step 3: x += this.b
        x = 1 + 1 = 2 (static variable Tracing.x = 2)

Step 4: Return this.b = 1
```

**Back to t1.methodA:**
```
Step 2 (continued): this.b = this.b + this.a + this.methodB()
                    t1.b = 3 + 2 + 1 = 6

Step 3: Print "2 6 2" (t1.a, t1.b, static x)
```

**State after t1.methodA:**
- `Tracing.x = 2`
- `Tracing.y = 2`
- `t1.a = 2`
- `t1.b = 6`

## **Second Constructor Call**
```java
Tracing t2= new Tracing(3, 4);
```

**Inside Tracing(int a, int b):**
- Parameters: `a = 3`, `b = 4`

**Initial instance state for t2:**
- `t2.a = 0` (default value)
- `t2.b = 0` (default value)

**Constructor execution line by line:**

```
Step 1: this.a = a
        t2.a = 3

Step 2: this.b = b
        t2.b = 4

Step 3: x += 1
        x = 2 + 1 = 3 (static variable Tracing.x = 3)

Step 4: y += 2
        y = 2 + 2 = 4 (static variable Tracing.y = 4)
```

**State after t2 constructor:**
- `Tracing.x = 3`
- `Tracing.y = 4`
- `t2.a = 3`
- `t2.b = 4`

## **Second methodA Call**
```java
t2.methodA(2);
```

**Inside t2.methodA(int a):**
- Parameter: `a = 2`

**Current State:**
- `Tracing.x = 3`
- `Tracing.y = 4`
- `t2.a = 3`
- `t2.b = 4`

**methodA execution line by line:**

```
Step 1: this.a = x + a
        t2.a = 3 + 2 = 5

Step 2: this.b = this.b + this.a + this.methodB()
        Need to call methodB() first: this.b + this.a + methodB()
        = 4 + 5 + methodB()
```

## Nested methodB Call on t2
**Inside t2.methodB():**

**Current State:**
- `Tracing.x = 3`
- `Tracing.y = 4`
- `t2.a = 5`
- `t2.b = 4`

**methodB execution line by line:**

```
Step 1: this.b = y - this.b + this.a
        t2.b = 4 - 4 + 5 = 5

Step 2: Print "5 5 3" (t2.a, t2.b, static x)

Step 3: x += this.b
        x = 3 + 5 = 8 (static variable Tracing.x = 8)

Step 4: Return this.b = 5
```

**Back to t2.methodA:**
```
Step 2 (continued): this.b = this.b + this.a + this.methodB()
                    t2.b = 4 + 5 + 5 = 14

Step 3: Print "5 14 8" (t2.a, t2.b, static x)
```

**State after t2.methodA:**
- `Tracing.x = 8`
- `Tracing.y = 4`
- `t2.a = 5`
- `t2.b = 14`

## **First methodB(Tracing) Call**
```java
t1.methodB(t2);
```

**Inside t1.methodB(Tracing t1):**
- Parameter: `t1` references the t2 object

**Current State:**
- `Tracing.x = 8`
- `Tracing.y = 4`
- `t1.a = 2`
- `t1.b = 6`
- `t2.a = 5`
- `t2.b = 14`

**methodB(Tracing) Code:**
```java
t1.b = this.y - t1.b + this.b;
System.out.println(t1.a+" "+t1.b+" "+x);
```

**methodB execution line by line:**

```
Step 1: t1.b = this.y - t1.b + this.b
        t2.b = 4 - 14 + 6 = -4 (modifying t2.b through parameter t1)

Step 2: Print "5 -4 8" (t2.a through parameter t1, t2.b through parameter t1, static x)
```

**State after t1.methodB(t2):**
- `Tracing.x = 8`
- `Tracing.y = 4`
- `t1.a = 2`
- `t1.b = 6`
- `t2.a = 5`
- `t2.b = -4`

## **Final methodB(Tracing) Call**
```java
t2.methodB(t2);
```

**Inside t2.methodB(Tracing t1):**
- Parameter: `t1` references the t2 object itself

**Current State:**
- `Tracing.x = 8`
- `Tracing.y = 4`
- `t2.a = 5`
- `t2.b = -4`

**methodB execution line by line:**

```
Step 1: t1.b = this.y - t1.b + this.b
        t2.b = 4 - (-4) + (-4) = 4 (modifying t2.b through parameter t1, which is t2 itself)

Step 2: Print "5 4 8" (t2.a through parameter t1, t2.b through parameter t1, static x)
```

## Final Output
The program produces the following output:
```
2 1 1
2 6 2
5 5 3
5 14 8
5 -4 8
5 4 8
```

## Final State Summary
- `Tracing.x = 8` (static variable)
- `Tracing.y = 4` (static variable)
- `t1.a = 2`
- `t1.b = 6`
- `t2.a = 5`
- `t2.b = 4`