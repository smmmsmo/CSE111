## Main Method Execution

```java
Human h1 = new Human();
```
- Creates a `Human` object `h1` with default instance variable values (no constructor defined):
  - `h1.age = 0` (default for `int`)
  - `h1.height = 0.0` (default for `double`)

**State after creation:**
- `h1.age = 0`
- `h1.height = 0.0`

```java
Human h2 = new Human();
```
- Creates a `Human` object `h2` with:
  - `h2.age = 0`
  - `h2.height = 0.0`

**State after creation:**
- `h1.age = 0`
- `h1.height = 0.0`
- `h2.age = 0`
- `h2.height = 0.0`

```java
h1.age = 21;
```
- Assigns `h1.age = 21`

**State:**
- `h1.age = 21`
- `h1.height = 0.0`
- `h2.age = 0`
- `h2.height = 0.0`

```java
h1.height = 5.5;
```
- Assigns `h1.height = 5.5`

**State:**
- `h1.age = 21`
- `h1.height = 5.5`
- `h2.age = 0`
- `h2.height = 0.0`

```java
System.out.println(h1.age);
```
- Prints `21`

**Output so far:**
```
21
```

```java
System.out.println(h1.height);
```
- Prints `5.5`

**Output so far:**
```
21
5.5
```

```java
h2.height = h1.height - 3;
```
- `h2.height = 5.5 - 3 = 2.5`

**State:**
- `h1.age = 21`
- `h1.height = 5.5`
- `h2.age = 0`
- `h2.height = 2.5`

```java
System.out.println(h2.height);
```
- Prints `2.5`

**Output so far:**
```
21
5.5
2.5
```

```java
h2.age = h1.age++;
```
- `h1.age++` assigns `h1.age`’s current value (`21`) to `h2.age`, then increments `h1.age` to `22` (post-increment)
- `h2.age = 21`

**State:**
- `h1.age = 22`
- `h1.height = 5.5`
- `h2.age = 21`
- `h2.height = 2.5`

```java
System.out.println(h1.age);
```
- Prints `22`

**Output so far:**
```
21
5.5
2.5
22
```

```java
h2 = h1;
```
- Assigns `h2` to reference the same object as `h1`. The original `h2` object is no longer referenced (eligible for garbage collection).
- Now `h2` and `h1` point to the same `Human` object.

**State:**
- `h1.age = 22` (same object as `h2`)
- `h1.height = 5.5`
- `h2.age = 22` (references `h1`’s object)
- `h2.height = 5.5`

```java
System.out.println(h2.age);
```
- Prints `22` (since `h2` references `h1`’s object)

**Output so far:**
```
21
5.5
2.5
22
22
```

```java
System.out.println(h2.height);
```
- Prints `5.5`

**Output so far:**
```
21
5.5
2.5
22
22
5.5
```

```java
h2.age++;
```
- Increments `h2.age` (post-increment, but since it’s a standalone statement, it increments `h2.age` to `23`).
- Since `h2` and `h1` reference the same object, `h1.age` is also `23`.

**State:**
- `h1.age = 23`
- `h1.height = 5.5`
- `h2.age = 23`
- `h2.height = 5.5`

```java
h2.height++;
```
- Increments `h2.height` to `5.5 + 1 = 6.5`.
- Affects `h1.height` (same object).

**State:**
- `h1.age = 23`
- `h1.height = 6.5`
- `h2.age = 23`
- `h2.height = 6.5`

```java
System.out.println(h1.age);
```
- Prints `23`

**Output so far:**
```
21
5.5
2.5
22
22
5.5
23
```

```java
System.out.println(h1.height);
```
- Prints `6.5`

**Output so far:**
```
21
5.5
2.5
22
22
5.5
23
6.5
```

```java
h1.age = ++h2.age;
```
- `++h2.age` increments `h2.age` to `23 + 1 = 24` (pre-increment), then assigns this value to `h1.age`.
- Since `h1` and `h2` reference the same object, `h1.age = 24` affects both.

**State:**
- `h1.age = 24`
- `h1.height = 6.5`
- `h2.age = 24`
- `h2.height = 6.5`

```java
System.out.println(h2.age);
```
- Prints `24`

**Output so far:**
```
21
5.5
2.5
22
22
5.5
23
6.5
24
```

```java
System.out.println(h2.height);
```
- Prints `6.5`

**Output:**
```
21
5.5
2.5
22
22
5.5
23
6.5
24
6.5
```

## Final State Summary
- **h1/h2** (same object):
  - `h1.age = 24`
  - `h1.height = 6.5`
  - `h2.age = 24`
  - `h2.height = 6.5`