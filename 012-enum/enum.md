# __Enum in Java__

## Enumerations

- An enumeration is a list of named constants that define a new data type and its legal values.

- It can hold only a value that was declared in the list. 

- In Java, an enumeration defines a class type,
    - So they can have constructors, methods, and instance variables. 

---

## Enumeration Fundamentals

- Create enum using the `enum` keyword.

```java
enum Season { 
    WINTER, 
    SPRING, 
    SUMMER, 
    FALL
}  
```
- Every enum constant is always implicitly public static final. 
- Do not instantiate an enum using new. 

- Use an enumeration variable like one of the primitive types.

```java
Season season;
season = Season.WINTER;
```

---

## Compare Enumeration constants
- Two enumeration constants can be compared for equality by using the `==` relational operator.

```java
if(season == Season.WINTER)
System.out.println(season);
```

---

## Displaying Enumeration 
- When an enumeration constant is displayed, such as in a println( ) statement, its name is output.


```java
System.out.println(Season.WINTER);
```
- the name Winter is displayed.

---


## Enum and Inheritance :  
- All enums implicitly extend java.lang.Enum class. As a class can only extend one parent in Java, so an enum cannot extend anything else.
- toString() method is overridden in java.lang.Enum class, which returns enum constant name.
- enum can implement many interfaces.

## values(), ordinal() and valueOf() methods :  

- These methods are present inside java.lang.Enum.
- All enumerations automatically contain two predefined methods: values( ) and valueOf( ). 
## The values( ) Method


```java
public static enum-type [ ] values( )

for (Season s : Season.values()) {
     System.out.println(s);
}
```
- The values( ) method returns an array that contains a list of the enumeration constants.

## The valueOf( ) Method
```java
public static enum-type valueOf(String str )

Season.valueOf("FALL");
```
- The valueOf( ) method returns the enumeration constant whose value corresponds to the string passed in str.

--- 

## Java Enumerations Are Class Types
- They can have constructors, 
- add instance variables and 
- methods, and even implement interfaces.

### The enum and instance variable
-  The instance variable degree, which is used to hold the degree of each variety of Season. 
```java
enum Season{
    private int degree;
}
```
## The enum and Constructor
- The constructor, which is passed the degree of an season.
```java
enum Season{
    WINTER(60),
    SPRING(40),
    SUMMER(35),
    FALL(45);
}
```
## The eum and methods
- The method getDegree( ), which returns the value of degree.
```java
  enum Season{
       public int getDegree() {return degree;}
  }
```

### Overloaded forms
- an enum can offer two or more overloaded forms of contructors, just as can any other class.

```java
enum Season{
    private int degree;
    Season(){
        this.degree=-1;
    }

     Season(int degree){
        this.degree = degree;
    }

```
### _complete codes_
```java
enum Season{
    WINTER(60),
    SPRING(40),
    SUMMER(35),
    FALL(45);

    private int degree;
     Season(int degree){
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }
}
```
---
