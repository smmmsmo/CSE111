# Quiz - Code Trace

## msgClass

```java
class msgClass{ 
  public int content;
}
```

## FinalT5A Class

```java
class FinalT5A {
  public int sum = 2, y = 1, x = 1;
  public void methodA(){ 
    int x=6, y =0;
    msgClass myMsg = new msgClass();
    myMsg.content = this.x;
    x = x + myMsg.content;
    this.y = this.y + methodB(myMsg, myMsg.content);  
    System.out.println(x + " " + this.y+ " " + sum); 
    y =  this.y/2 + this.x;
    x = y + sum/2; 
    sum = x + y + myMsg.content;
    System.out.println(x + " " + y+ " " + sum);
  }
  public int methodB(msgClass mg2, int mg1){
    int x = 0;
    y = y + mg2.content;
    mg2.content = y + mg1;
    x = this.x + 3 + mg1;
    sum = sum + x + y;
    System.out.println(this.x + " " + this.y+ " " + sum);   
    mg2.content = sum - mg1 ;
    return sum;
  } 
}
```

## Tester10 Class

```java
public class Tester10 {
  public static void main(String args[]){
    FinalT5A fT5A = new FinalT5A();
    fT5A.methodA();
  }
}
```

---

## **Main Method Execution**
```java
FinalT5A fT5A = new FinalT5A();
fT5A.methodA();
```

- Creates an object `fT5A` with initial instance variables:
  - `sum = 2`
  - `y = 1`
  - `x = 1`

---

## **MethodA Execution**

```java
int x = 6, y = 0;
msgClass myMsg = new msgClass();
```

- Local variables: `x = 6`, `y = 0` (these shadow the instance variables).
- Creates `myMsg` with default `content = 0`.

```java
myMsg.content = this.x;
```
- `this.x = 1`
- So `myMsg.content = 1`.

```java
x = x + myMsg.content;
```
- `x = 6 + 1 = 7` (local x).

```java
this.y = this.y + methodB(myMsg, myMsg.content);
```
- Calls `methodB(myMsg, 1)` with current state:
  - `sum = 2`
  - `y = 1`
  - `x = 1`
  - `myMsg.content = 1`

---

## **Nested MethodB Execution**

```java
int x = 0;
y = y + mg2.content;
```
- `y = 1 + 1 = 2` (instance y).

```java
mg2.content = y + mg1;
```
- `mg2.content = 2 + 1 = 3`.

```java
x = this.x + 3 + mg1;
```
- `x = 1 + 3 + 1 = 5` (local x in methodB).

```java
sum = sum + x + y;
```
- `sum = 2 + 5 + 2 = 9`.

```java
System.out.println(this.x + " " + this.y + " " + sum);
```
- Prints: `1 2 9`.

```java
mg2.content = sum - mg1;
```
- `mg2.content = 9 - 1 = 8`.

```java
return sum;
```
- Returns `9`.

---

## **Back to methodA**

```java
this.y = this.y + 9;
```
- `this.y = 2 + 9 = 11`.

```java
System.out.println(x + " " + this.y + " " + sum);
```
- Local `x = 7`, `this.y = 11`, `sum = 9`
- Prints: `7 11 9`.

```java
y = this.y/2 + this.x;
```
- `y = 11/2 + 1 = 5 + 1 = 6` (integer division).

```java
x = y + sum/2;
```
- `x = 6 + 9/2 = 6 + 4 = 10`.

```java
sum = x + y + myMsg.content;
```
- `sum = 10 + 6 + 8 = 24`.

```java
System.out.println(x + " " + y + " " + sum);
```
- Prints: `10 6 24`.

---

## **Final Output**
The program produces the following output:
```
1 2 9
7 11 9
10 6 24
```

## **Final State Summary**
- `fT5A.sum = 24`
- `fT5A.x = 1` (unchanged instance variable)
- `fT5A.y = 11`
- `myMsg.content = 8`
