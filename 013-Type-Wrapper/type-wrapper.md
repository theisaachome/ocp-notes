# Type Wrappers

-  Java uses primitive types such as int or double, to hold the basic data types supported by the language.
-  Primitive types are used for these quantities for the sake of performance.
- The primitive types  do not inherit Object and they
are not part of the object hierarchy.

- Java provides type wrappers, which are classes that encapsulate a primitive type within an object.

- The type wrappers are 
    - Double, 
    - Float, 
    - Long, 
    - Integer, 
    - Short, 
    - Byte, 
    - Character, and 
    - Boolean.

## Character
- Character is a wrapper around a char.
- The constructor for Character is:
    ```java
    Character(char ch)
    ```
- `ch` specifies the character that will be wrapped by the Character object being created.
- the static method `valueOf( )` to obtain a Character object.

    ```java
    static Character valueOf(char ch)
    ```
- To obtain the char value contained in a Character object, call charValue( ):

    ```java
    char charValue( )
    ```