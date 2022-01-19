#  **What Are Interfaces in Java?**

- In Java, an interface is an abstract type that contains a collection of methods and constant variables.
-  Using interface, you can specify what a class must do, but not how it does it.
- It is one of the core concepts in Java and
- It is used to achieve `abstraction`, `polymorphism` and `multiple inheritances`.

---
## Defining an Interface

- A simplified general form of an interface:

```java
interface interface_name {  
// fields
// abstract/private/default methods
}
```

---

## **Implementing Interfaces**

- include the implements clause in a class definition,

- and then create the methods required by the interface. 

```java
interface Flyable{
	void fly();
}

class  Duck implements Flyable{
	@Override
	public void fly() {
		System.out.println("I am flying bae");
	}
}

```
---

## **Variables in Interfaces**
- You can use interfaces to import shared constants into multiple classes by simply declaring an interface that contains variables that are initialized to the desired values. 
```java
public interface Electronic {
    // Constant variable
    String LED = "LED";
}
```
---
## **Interfaces Can Be Extended**

- One interface can inherit another by use of the keyword extends.
```java
interface A{
	void method1();
	void method2();
}
interface B extends A{
	void method3();
}
```
- When a class implements an interface that inherits another interface, it must provide implementations for all methods required by the interface inheritance chain.
```java
class Client implements B{
	@Override
	public void method1() {
		System.out.println("Method 1");
	}
	@Override
	public void method2() {
		System.out.println("Method 2");		
	}
	@Override
	public void method3() {
		System.out.println("Method 3");		
	}
}
```
---
## **Default Interface Methods**
-  The release of JDK 8 changed this by adding a new capability to interface called the default method. 
-  Define a default implementation for an interface method. 

- by providing a default, the interface makes the implementation of a method by a class `optional`.

```java
interface Flyable{
	void fly();
	default void move() {
		System.out.println("default Moving method...");
	}
}
```
```java
class  Duck implements Flyable{
	@Override
	public void fly() {
		System.out.println("I am flying bae");
	}
}
Duck duck= new Duck();
duck.fly();
duck.move();
```
--- 

## **Interface References**

```java
	Flyable obj= new Duck();
	obj.fly();
	obj.move();
```


## **Use static Methods in an Interface**
- Another capability added to interface by JDK 8 is the ability to define one or more static methods.

```java
interface MyInterface{
	void makeCall();
	static void generateInfo() {
		System.out.println("Generating information.....");
	}
}
```
- A static method defined by an interface can be called independently of any object
```java
 MyInterface.generateInfo();
```
- A static method is called by specifying the interface name, followed by a period, followed by the method name.
- static interface methods are not inherited by either an implementing class or a subinterface.