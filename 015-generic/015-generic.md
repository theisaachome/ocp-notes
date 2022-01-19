# **Generic**


## **What is Generic?.**

-  The term `generics` means parameterized types. 

- A class, interface, or method that operates on a parameterized type is called generic, as in generic class or generic method.
- Java always give the ability to create generalized classes, interfaces, and methods by operating through references of type Object.
-  Object is the superclass of all other classes, an Object reference can refer to any type object.
- The problem was that they could not do so with type safety.
- `Generics` added the type safety that was lacking.
- With generics, all casts are automatic and implicit.
- Generics expanded your ability to reuse code and let you do so safely and easily.

--- 
## **The General Form of a Generic Class**
- The syntax for declaring a generic class:
```java
class class-name<type-param-list > {}
```
- declaring a reference to a generic class and instance
creation:
```java
class-name<type-arg-list > var-name =new class-name<type-arg-list >(cons-arg-list);
```
---
## A Simple Generics

```java
public class Gen<T>{}
```
- T is the name of a type parameter, a placeholder for the actual type that will be passed to Gen when an object is created.

- Generic Constructor
    ```java
    Gen(T t){
        this.t = t;
    }
    // Creating instance
    Gen<String> strGen = new Gen<String>("Java Generic");
    Gen<Integer> intGen = new Gen<Integer>(100);
    ```
- Generic Method
    ```java
    T getObject() {
        return t;
    }
    ```

---
## **Generics Work Only with Reference Types**

- The type argument passed to the type parameter must be a reference type.
- You cannot use a primitive type, such as int or char. 
```java
Gen<int> intOb = new Gen<int>(53);
```

---
## **Generics Improve Type Safety**

- Generics automatically ensure the type safety of all operations involving Gen.

### Non-Generic Example

```java
class NonGen{
	Object obj;

	NonGen(Object obj){this.obj = obj;}

	Object getObj () {return obj;}

	void showType() {
		System.out.println("Object type is " + obj.getClass().getName());
	}
}
```
### Need Type casting
```java
NonGen iObj = new NonGen(88);
int v =(Integer) iObj.getObj();
```

### Run-time error
```java
NonGen strObj= new NonGen("Testing Non-gen");
iObj = strObj;
v = (Integer)obj.getObj();
```
---

## **A Generic Class with Two Type Parameters**

- You can declare more than one type parameter in a generic type. 
- To specify two or more type parameters, simply use a comma-separated list.

- It specifies two type parameters: T and V, separated by a comma. 
```java
class TwoGen<T,V> {}
```
- When an object is created.

```java
TwoGen<String,Integer> twoGen = new TwoGen<>("Aung Aung", 100);
```

---

## **Bounded Types**

-  The type parameters could be replaced by any class type.
- Sometime It is useful to limit the types that can be passed to a type parameter.

-  use of an extends clause when specifying the type parameter.

```java
<T extends superclass>
class State<T extend Number>{}
```
## Class Bound and interface
- using a class type as a bound, you can also use an interface type.
- You can specify multiple interfaces as bounds.
- A bound can include both a class type and one or more interfaces. 
- A bound that has a class and an interface, or multiple interfaces, use the & operator to connect them. 
```java
class Gen<T extends MyClass & MyInterface> {}
```

---

## **Using Wildcard Arguments**
- The wildcard argument is specified by the ?, and it represents an unknown type. 
```java
	boolean isSameAvg(Stats<?> obj) {
		if(getAverage() == obj.getAverage())return true;
		return false;
	}
```

## **Bounded Wildcards**
- Wildcard arguments can be bounded in much the same way that a type parameter can be bounded.
- A bounded wildcard is  important on creating a generic type that will operate on a class hierarchy.


### Example

```java
package com.isaachome.bounded.wildcard;

class TwoD{
	int x;
	int y;
	TwoD(int x, int y){
		this.x=x;
		this.y = y;
	}
}
```
```java
class ThreeD extends TwoD{
	int z;
	ThreeD(int a, int b, int c){
		super(a,b);
		this.z=c;
	}
}
```
```java
class FourD extends ThreeD{
	int t;
	FourD(int a, int b, int c, int d){
		super(a,b,c);
		this.t=d;
	}
}
```
```java
class Coords<T extends TwoD> {
	T [] coords;
	Coords(T[]o){
		this.coords=o;
	}
}
```

```java
public class BoundedWilcard {
	public static void main(String[] args) {
		FourD[] fdloc = {
			new FourD(2, 4, 6, 8),
			new FourD(12, 14, 16, 18),
			new FourD(22, 24, 26, 28),
			new FourD(32, 34, 36, 38)
		};
		Coords<FourD> coords = new Coords<>(fdloc);
		showXY(coords);
		showXYZ(coords);
		showXYZT(coords);
	}
	
	public static void showXY(Coords<?> c) {
		System.out.println("X and Y Coordinates...");
		for (int i = 0; i < c.coords.length; i++) {
			System.out.println(c.coords[i].x + " "+ c.coords[i].y);
			System.out.println();
		}
	}
	public static void showXYZ(Coords<? extends ThreeD> c) {
		System.out.println("X , Y and Z Coordinates...");
		for (int i = 0; i < c.coords.length; i++) {
			System.out.println(c.coords[i].x 
					+ " " + c.coords[i].y 
					+ " " + c.coords[i].z);
			System.out.println();
		}
	}
	
	public static void showXYZT(Coords<? extends FourD> c) {
		System.out.println("X,Y,Z and T Coordinates...");
		for (int i = 0; i < c.coords.length; i++) {
			System.out.println(c.coords[i].x 
					+ " "+ c.coords[i].y 
					+ " " +c.coords[i].z
					+ " " + c.coords[i].t);
			System.out.println();
		}
	}
}


```

---
## **Generic Methods**

### Syntax
- A Generic method includes a type parameter, inside angle brackets and appears before the method’s return type.

```java
public static <T> T identical(T obj){
        return returnValue;
}
```

### Example
```java

public <T>void showItemInfo(T item) {
	System.out.println("Item  : " + item);
	System.out.println("Item type  : " + item.getClass().getName());
}
public <T,U>void showItemInfo(T t,U u){
	System.out.println("Item  : " + t + " and Price : " + u);
	System.out.println("Item types  : " + t.getClass().getName() + " and " + u.getClass().getName());
}
```
```java
	Item item = new Item();
	item.showItemInfo("Text Book");
	System.out.println();
	item.showItemInfo("Reactjs Course", 9.99);
```

---
## **Generic Constructors**

- It is possible for constructors to be generic.

```java
class MyGen{
	double myValue;
	public <T extends Number>MyGen(T args){
		this.myValue = args.doubleValue();
	}
}
```
```java
MyGen myGen = new MyGen(Integer.valueOf(100));
```

## **Generic Interfaces**
- Generic interfaces are specified just like generic classes.

```java

interface MinMax<T extends Comparable<T>> {
	T min();

	T max();

}
```
```java
class MyClass<T extends Comparable<T>> implements MinMax<T> {

	T[] vals;

	MyClass(T[] o) {
		this.vals = o;
	}

	@Override
	public T min() {
		T v =vals[0];
		for(int i =0; i<vals.length;i++) {
			if(vals[i].compareTo(v)<0)v=vals[i];
		}
		return v;
	}

	@Override
	public T max() {
		T v =vals[0];
		for(int i =0;i<vals.length;i++) {
			if(vals[i].compareTo(v)>0)v=vals[i];
		}
		return v;
	}

}
```

---
## **Generic Class Hierarchies**
-  a generic class can act as a superclass or be a subclass.

```java

class Parent<T>{
	T t;
	Parent(T t){
		this.t=t;
	}
}
class Child<T,V> extends Parent<T>{
	V v;
	Child(T t,V v){
		super(t);
		this.v=v;
	}
}
```
```java
Child<String,Integer> child=new Child<>("Age", 10);
```

## **A Generic Subclass**
- It is perfectly acceptable for a non-generic class to be the superclass of a generic subclass.