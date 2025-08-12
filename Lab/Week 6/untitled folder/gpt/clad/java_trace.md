# Java Code Execution Trace

## Initial Setup
**main() method starts:**
```java
Foo p = new Foo(3, 4);
```
- Creates Foo object `p` with:
  - `p.bar = 3`
  - `p.buz = 4`

## Quiz5 Constructor Call
```java
Quiz5 q = new Quiz5(p);
```

**Inside Quiz5 constructor:**
- Initial instance variables:
  - `sum = 12`
  - `x = 2` 
  - `y = 6`
- Parameter: `f` references the same Foo object as `p`
- `foo = f;` (so `foo` now references the Foo object)

**Constructor execution line by line:**

1. `int x = this.foo.buz + y;`
   - Local variable `x = 4 + 6 = 10`
   - Instance variable `this.x` remains `2`

2. `sum = sum + (f.bar--) + y;`
   - `f.bar--` uses current value (3) then decrements
   - `sum = 12 + 3 + 6 = 21`
   - After decrement: `f.bar = 2` (and `foo.bar = 2` since same object)

3. `System.out.println(foo.bar + " " + sum + " " + x);`
   - Prints: `2 21 10`

4. `sum -= 10;`
   - `sum = 21 - 10 = 11`

**State after constructor:**
- `q.sum = 11`
- `q.x = 2`
- `q.y = 6`
- `q.foo.bar = 2`
- `q.foo.buz = 4`

## methodA Call
```java
q.methodA(4, 8);
```

**Inside methodA(int bar, int buz):**
- Parameters: `bar = 4`, `buz = 8`

**methodA execution line by line:**

1. `bar = 3 + bar - this.foo.bar;`
   - `bar = 3 + 4 - 2 = 5` (local parameter variable)

2. `x = bar + 12 + y;`
   - `x = 5 + 12 + 6 = 23` (instance variable)

3. `y = foo.buz + buz + bar;`
   - `y = 4 + 8 + 5 = 17` (instance variable)

4. `sum = y + methodB(foo.buz, foo) + foo.buz;`
   - Calls `methodB(4, foo)`

## methodB Call
**Inside methodB(int bar, Foo buz):**
- Parameters: `bar = 4`, `buz` references the Foo object

**methodB execution line by line:**

1. `int sum = bar + buz.bar + x;`
   - Local `sum = 4 + 2 + 23 = 29`

2. `buz.buz = sum + this.sum;`
   - `buz.buz = 29 + 11 = 40`
   - This modifies `foo.buz` to `40`

3. `System.out.println(bar + " " + buz.buz + " " + sum);`
   - Prints: `4 40 29`

4. `return sum;`
   - Returns `29`

## Back to methodA
**Continuing methodA after methodB returns:**

4. `sum = y + methodB(foo.buz, foo) + foo.buz;`
   - `sum = 17 + 29 + 40 = 86`

5. `System.out.println(bar + " " + y + " " + sum);`
   - Prints: `5 17 86`

## Final Output
The program produces the following output:
```
2 21 10
4 40 29
5 17 86
```

## Final State Summary
- `q.sum = 86`
- `q.x = 23`
- `q.y = 17`
- `q.foo.bar = 2`
- `q.foo.buz = 40`