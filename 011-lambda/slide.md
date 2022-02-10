## `Lambda Expressions`

### What is Lambda Expression

- A lambda expression is a block of code with parameters.

- Use a lambda expression whenever you want a block of code executed at a later point in time.

- Lambda expressions can be converted to functional interfaces.

- Lambda expressions can access effectively final variables from the enclosing scope.

- Method and constructor references refer to methods or constructors without invoking them.

- You can now add default and static methods to interfaces that provide concrete implementations.

- You must resolve any conflicts between default methods from multiple interfaces.

---

## The Syntax of Lambda Expressions

The form of lambda expressions in Java:
` parameters, the-> arrow, and an expression. `

```java
(params)->{}
```

```java
(String first, String second) -> {
    if (first.length() < second.length()) return -1;
    else if (first.length() > second.length()) return 1; 
    else return 0;
}
```
If a lambda expression has no parameters, you still supply empty parentheses, just as with a parameterless method:
```java
() -> { for (int i = 0; i < 1000; i++) doWork(); }
```

If the parameter types of a lambda expression can be inferred,  you can omit them.
```java
Comparator<String> comp
= (first, second) // Same as (String first, String second)
-> Integer.compare(first.length(), second.length());

```

You can add annotations or the final modifier to lambda parameters in the same way as for method parameters:
```java
(final String name) -> ... (@NonNull String name) -> ...
```

The result type of a lambda expression is always inferred from context.

```java
(String first, String second) -> 
    Integer.compare(first.length(), second.length())
```

---
 ## Functional Interface

 - A Single Abstract Method

- When a object or interface expect a single abstract method you can supply `@functionalInterface.`

- You can tag any functional interface with the `@FunctionalInterface` annotation.
```java
@FunctionalInterface
interface Sum{
    int calculate(int a ,int b);
}
```


### Example
- `Arrays.sort` 
- Its second parameter requires an instance of Comparator, an interface with a single method. 

 ```java
Arrays.sort(words,
(first, second) -> Integer.compare(first.length(), second.length()));

```
---
## Method Reference
