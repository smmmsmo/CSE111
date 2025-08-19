# Code Trace - FinalT5A

## msgClass

```java
class msgClass{ 
  public int content; 
}
```

## FinalT5A Class

```java
class FinalT5A{ 
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
public class Tester10{ 
  public static void main(String args []){ 
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
  - `fT5A.sum = 2`
  - `fT5A.y = 1`
  - `fT5A.x = 1`

## MethodA Call
```java
fT5A.methodA();
```

**Inside methodA():**

**Initial State:**
- `sum = 2` (instance variable)
- `y = 1` (instance variable)
- `x = 1` (instance variable)

**methodA Code:**
```java
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
```

**methodA execution line by line:**

```
Step 1: int x=6, y =0
        x = 6 (local variable, shadows instance x)
        y = 0 (local variable, shadows instance y)

Step 2: msgClass myMsg = new msgClass()
        Creates new msgClass object with content = 0 (default)

Step 3: myMsg.content = this.x
        myMsg.content = 1

Step 4: x = x + myMsg.content
        x = 6 + 1 = 7 (local variable)

Step 5: this.y = this.y + methodB(myMsg, myMsg.content)
        Need to call methodB(myMsg, 1) first
```

## Nested methodB Call
**Inside methodB(msgClass mg2, int mg1):**
- Parameters: `mg2` references `myMsg` object, `mg1 = 1`

**Current State:**
- Instance variables: `sum = 2`, `y = 1`, `x = 1`
- `myMsg.content = 1`
- Local variables in methodA: `x = 7`, `y = 0`

**methodB Code:**
```java
int x = 0; 
y = y + mg2.content; 
mg2.content = y + mg1; 
x = this.x + 3 + mg1; 
sum = sum + x + y; 
System.out.println(this.x + " " + this.y+ " " + sum);    
mg2.content = sum - mg1 ; 
return sum;
```

**methodB execution line by line:**

```
Step 1: int x = 0
        x = 0 (local variable in methodB)

Step 2: y = y + mg2.content
        y = 1 + 1 = 2 (instance variable)

Step 3: mg2.content = y + mg1
        mg2.content = 2 + 1 = 3 (modifies myMsg.content to 3)

Step 4: x = this.x + 3 + mg1
        x = 1 + 3 + 1 = 5 (local variable in methodB)

Step 5: sum = sum + x + y
        sum = 2 + 5 + 2 = 9 (instance variable)

Step 6: Print "1 2 9" (this.x, this.y, sum)

Step 7: mg2.content = sum - mg1
        mg2.content = 9 - 1 = 8 (modifies myMsg.content to 8)

Step 8: Return sum = 9
```

**Back to methodA:**
```
Step 5 (continued): this.y = this.y + methodB(myMsg, 1)
                    this.y = 2 + 9 = 11

Step 6: Print "7 11 9" (local x, this.y, sum)

Step 7: y = this.y/2 + this.x
        y = 11/2 + 1 = 5 + 1 = 6 (local variable)

Step 8: x = y + sum/2
        x = 6 + 9/2 = 6 + 4 = 10 (local variable)

Step 9: sum = x + y + myMsg.content
        sum = 10 + 6 + 8 = 24 (instance variable)

Step 10: Print "10 6 24" (local x, local y, sum)
```

## Final Output
The program produces the following output:
```
1 2 9
7 11 9
10 6 24
```

## Final State Summary
- `fT5A.sum = 24`
- `fT5A.y = 11`
- `fT5A.x = 1`
- `myMsg.content = 8`