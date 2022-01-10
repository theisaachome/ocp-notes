# Java Annotation

## **Annotations**

- A feature that enables you to embed supplemental information into a source file.

- An annotation, does not change the actions of a program.

- An annotation leaves the semantics of a program unchanged.

- The information can be used by various tools during both development and deployment.

- An annotation might be processed by a source-code generator.

- The term metadata is also used to refer to this feature,

---

## **Annotation Basics**

- Created through a mechanism based on the interface.

```java
@interface MyAnno{
	String str();
	int num();
}
```

## **Specifying a Retention Policy**

- A retention policy determines at what point an annotation is discarded.
- Java defines three such policies:

  - They are SOURCE, CLASS, and RUNTIME.

- A retention policy of SOURCE is retained only in the source file and is discarded during compilation.

- A retention policy of CLASS is stored in the .class file during compilation.

- it is not available through the JVM during run time.

- A retention policy of RUNTIME is stored in the .class file during compilation and is available through the JVM during run time.

### **The default policy of CLASS is used.**

```java
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno{
	String str();
	int num();
}
```

### Obtaining Annotations at Run Time by Use of Reflection

```java
	@MyAnno(num = 33,str = "isaachome")
	public static void myMethod() {
		MainApp ob = new MainApp();
		try {
			Class<?> c = ob.getClass();
			Method m = c.getMethod("myMethod");
			MyAnno anno = m.getAnnotation(MyAnno.class);
			System.out.println(anno.num() + " " + anno.str());
		} catch (NoSuchMethodException e) {
			// TODO: handle exception
			System.out.println("No Method Found.");
		}
	}
	public static void main(String[] args) {
		myMethod();
	}
```

---

### **A Second Reflection Example**

```java

	@Info(name = "isaacHome",age=33)
	public static void showInfo(String str,int num) {
		Employee ob= new Employee();
		try {
			Class<?> c = ob.getClass();
			Method m = c.getMethod("showInfo",String.class,int.class);

			Info infoAnno = m.getAnnotation(Info.class);
			System.out.println(infoAnno.name() + " " + infoAnno.age());
		} catch (NoSuchMethodException e) {
			System.out.println("No Such Method Found.");
		}
	}
	public static void main(String[] args) {
		showInfo("Test",20);
	}
```

### **Obtaining All Annotations**

```java

@Data(name = "Class Level Annotation", num = 99)
@What(description = "I am using at Class Level")
public class MetaApp {

	@Data(name = "sample info for resource",num = 100)
	@What(description = "We are using java Annotation")
	public static void myMethod() {
		try {
			MetaApp ob =new MetaApp();
			Annotation [] annos = ob.getClass().getAnnotations();
			System.out.println("All annotation for MetaApp");
			for (Annotation a : annos) {
				System.out.println(a);
			}
			System.out.println();
			Method m = ob.getClass().getMethod("myMethod");
			annos = m.getAnnotations();
			System.out.println("All annotation for myMethod()");
			for(var a :annos) {
				System.out.println(a);
			}
		} catch (NoSuchMethodException e) {
			System.out.println("No Such Method found.");
		}
	}
	public static void main(String[] args) {
		myMethod();
	}
}
```

---

## **Using Default Values**

- You can give annotation members default values that will be used if no value is specified when the annotation is applied.

- A default value is specified by adding a default clause to a member’s declaration.

```java
@Retention(RetentionPolicy.RUNTIME)
public @interface Data {
	String name() default "Default Name";
	int num() default 0;
}

// usage
@Data
@Data(name = "Person name",num=20)
@Data(name = "Person name")
@Data(num=20)
class Person{}

```
---

## **Types of Annotation**
- There are three types of annotations.
    - Marker Annotation
    - Single-Value Annotation
    - Multi-Value Annotation


### **Marker Annotations**
- A marker annotation is a special kind of annotation that contains no members.
- Its sole purpose is to mark an item.
- its presence as an annotation is sufficient.
- The best way to determine if a marker annotation is present is to use the method isAnnotationPresent( ),
- which is defined by the AnnotatedElement interface.

```java
@Retention(RetentionPolicy.RUNTIME)
public @interface MyMarker {}

@MyMarker
public static void myMethod() {
try {
	Marker ob = new Marker();
	Method m = ob.getClass().getMethod("myMethod");
	if(m.isAnnotationPresent(MyMarker.class)) {
	System.out.println("MyMarker is present.");
	}
			
} catch (NoSuchMethodException e) {
	System.out.println("No Such Method found.");
	}
}
```

---
## **Single-Member Annotations**
- A single-member annotation contains only one member. 
- When only one member is present, you can simply specify the value for that member when the annotation is applied
- in order to use this shorthand, the name of the member must be value.

```java

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle{
	int value();
}
```
- Normal Usage
```java
@MySingle(value = 100)
public static void myMethod() {}
```
- Shorthand
```java
@MySingle(100)
public static void myMethod() {}
```
### other example

```java
@Retention(RetentionPolicy.RUNTIME)
@interface SomeAnno{
	int value();
	int otherValue() default 100;
}
```
- shorthand Usage
```java
@SomeAnno(1500)
public static void myMethod2() {}
// 1500 100 (default value of other)
```
- override default value Usage
```java
@SomeAnno(value = 1500,otherValue =100 )
public static void myMethod2() {}

```

## Built-In Java Annotations used in Java code
- @Override
- @SuppressWarnings
- @Deprecated
## Built-In Java Annotations used in other annotations
- @Target
- @Retention
- @Inherited
- @Documented

---

## @Target
`@Target` tag is used to specify at which type, the annotation is used.

- The java.lang.annotation.ElementType enum declares many constants to specify the type of element where annotation is to be applied such as TYPE, METHOD, FIELD etc. Let's see the constants of ElementType enum:

### Example to specify annoation for a class

```java
@Target(ElementType.TYPE)  
@interface MyAnnotation{  
int value1();  
String value2();  
} 
```

### Example to specify annotation for a class, methods or fields
```java
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})  
@interface MyAnnotation{  
int value1();  
String value2();  
}  
```

## @Retention
`@Retention` annotation is used to specify to what level annotation will be available.

```java
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.TYPE)  
@interface MyAnnotation{  
int value1();  
String value2();  
}  
```

## Repeated Annotation
```java

@Retention(RetentionPolicy.RUNTIME)
@interface MyRepeatedAnno{
	Anno [] value();
}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyRepeatedAnno.class)
@interface Anno{
	String str() default "Testing Repeat";
	int num() default 9000;
}

```

```java
	@Anno(str = "First Annotation",num = 1000)
	@Anno(str="Second Annotation ",num=2000)
	public static void myMethod(String name, int num) {
		RepeatAnnoDemo ob = new RepeatAnnoDemo();
		try {
			Class<?> c = ob.getClass();
			Method m = c.getMethod("myMethod", String.class,int.class);
			Annotation anno = m.getAnnotation(MyRepeatedAnno.class);
			System.out.println(anno);
		} catch (NoSuchMethodException e) {
			System.out.println("No such Method found.");
		}
	}
	public static void main(String[] args) {
		myMethod("Testing Reapted Anno", 10);
	}
```