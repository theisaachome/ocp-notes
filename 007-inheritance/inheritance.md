# **Inheritance**

## What is Inheritance?
- Inheritance in Java is a mechanism in which one object acquires all the properties and behaviors of a parent object. It is an important part of OOPs.

### `superclass`
-  In the terminology of Java, a class that is inherited is called a superclass.

### `subclass`
- The class that does the inheriting is called a subclass.
- Therefore, a subclass is a specialized version of a superclass.


---

## Inheritance Basics

-  using the `extends` keyword.

```java
class Person{
    String name;
    String email;
}

class Employee extends Person{
    String employeCard;
}
```

- Employee inherits all of the members defined by the Person and adds its own, unique elements.

- Superclass  :
    -  is a completely independent, stand-alone class.
    - does not mean that the superclass cannot be used by itself.

- Subclass : 
    - a subclass can be a superclass for another subclass.
    - only specify one superclass per one subclass.


---
## `Member Access and Inheritance`

- A subclass includes all of the members of its superclass.
- It cannot access those members of the superclass that have been declared as private.

```java
class Parent {
    private String socialId;
    String address;
}
class Child extends Parent{}

```
-  A class member that has been declared as private will remain private to its class.

--- 

## **`Types of inheritance in java`**

- On the basis of class, there can be three types of inheritance in java:
    - single inheritance, 
    - multilevel inheritance and
    - hierarchical inheritance.

- In java programming, multiple and hybrid inheritance is supported through interface only.

### **`Single Inheritance`**

 When a class inherits another class, it is known as a single inheritance.

```java
class Animal{  
    void eat(){
        System.out.println("eating...");
    }  
}  
class Dog extends Animal{  
    void bark(){
        System.out.println("barking...");
    }  
}  
// usage
new Dog().eat();
new Dog().bark();
```
### **`Multilevel Inheritance`**

When two or more classes inherits a single class, it is known as hierarchical inheritance.

```java
class Animal{  
    void eat(){
        System.out.println("eating...");
    }  
}  
class Dog extends Animal{  
    void bark(){
        System.out.println("barking...");
    }  
}  
class Cat extends Animal{  
    void meow(){
        System.out.println("meowing...");
    }  
}  
// usage
Cat c=new Cat();  
c.meow();  
c.eat();  
```
----

## **`Important facts about inheritance in Java`** 

- `Default superclass:` Except Object class, which has no superclass, every class has one and only one direct superclass (single inheritance). In the absence of any other explicit superclass, every class is implicitly a subclass of the Object class.

- `Superclass can only be one:` A superclass can have any number of subclasses. But a subclass can have only one superclass. This is because Java does not support multiple inheritances with classes. Although with interfaces, multiple inheritances are supported by java.

- `Inheriting Constructors:` A subclass inherits all the members (fields, methods, and nested classes) from its superclass. Constructors are not members, so they are not inherited by subclasses, but the constructor of the superclass can be invoked from the subclass.

- `Private member inheritance:` A subclass does not inherit the private members of its parent class. However, if the superclass has public or protected methods(like getters and setters) for accessing its private fields, these can also be used by the subclass.

---

## **`A Superclass Variable Can Reference a Subclass Object`**

- A reference variable of a superclass can be assigned a reference to any subclass derived from that superclass. 

```java
class Parent{}
class Child extends Parent{}

Parent obj= new Child();
```
---

## **`Using super`**

Super has two general forms.

### **`A first Use for super`**

- The first calls the superclass’ constructor. 
- A subclass can call a constructor defined by its superclass by use of the following form of super:

```java
super(arg-list);
```

- Here, arg-list specifies any arguments needed by the constructor in the superclass. 
- super( ) must always be the first statement executed inside a subclass’ constructor.
```java
class Parent{
     String name;
    Parent(String name){
        this.name=name;
    }
}
```
```java
class Child extends Parent{
     String phone;
    Child(String name,String phone){
        super(name);
        this.phone = phone;
    }
}
```
```java
var obj = new Child("Aung Aung","0925084251");
obj.getName();
object.getPhone();
```

### **`A Second Use for super`**
- The second is used to access a member of the superclass that has been hidden by a member of a subclass.
- it always refers to the superclass of the subclass in which it is used.

```java
class A{
    int i;
}
class B extends A{
    int i;
    B(int x,y){
        super.i=x;
        this.i=y;
    }
	void show() {
		System.out.println("i in super : " + super.i);
		System.out.println("i in sub : " + this.i);
	}
}
```

- This second form of super is most applicable to situations in which member
names of a subclass hide members by the same name in the superclass.

--- 

## **`When Constructors Are Executed`**

- In a class hierarchy, constructors complete their execution in order of derivation, from superclass to subclass.

- Since super( ) must be the first statement executed in a subclass’ constructor, 
    - this order is the same whether or not super( ) is used.

- If super( ) is not used, then the default or parameterless constructor of each superclass will be executed

```java
class A{
    A(){
        System.out.println("In A constructor");
    }
}
class B extends A{
    B(){
        System.out.println("In B constructor");
    }
}
class C extends B{
    C(){
        System.out.println("In C constructor");
    }
}
```
----

## **`Method Overriding`**

Rules for Java Method Overriding
- The method must have the same name as in the parent class
- The method must have the same parameter as in the parent class.
- There must be an IS-A relationship (inheritance).

```java
class Vehicle{  
  void run(){System.out.println("Vehicle is running");}  
}  
```
```java
//Creating a child class  
class Bike extends Vehicle{  
  //defining the same method as in the parent class  
  void run(){
    System.out.println("Bike is running safely");
  }
}  

  Bike obj = new Bike();//creating object  
  obj.run();//calling method  
```
---

### Can we override static method?
No, a static method cannot be overridden.

### Why can we not override static method?
It is because the static method is bound with class whereas instance method is bound with an object.
- Static belongs to the class area, and an instance belongs to the heap area.

### Can we override java main method?
No, because the main is a static method.

## `Java Access Modifiers with Method Overriding`

- If you are overriding any method, overridden method (i.e. declared in subclass) must not be more restrictive.

### Example 
- The following snippet has  a compile-time error.
```java
class A{
    protected void show() {
    	System.out.println("A show method.");
    }
}
```
- The default modifier is more restrictive than protected. 
```java
class B extends A{
    void show() {
    	System.out.println("B show method.");
    }
}
```