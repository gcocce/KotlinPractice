
# Visitor

The purpose of a Visitor pattern is to define a new operation without introducing the modifications 
to an existing object structure. Imagine that we have a composite object which consists of components.

In object-oriented programming and software engineering, the visitor design pattern is a way of separating 
an algorithm from an object structure on which it operates. A practical result of this separation is the 
ability to add new operations to existing object structures without modifying the structures. 
It is one way to follow the open/closed principle.

In essence, the visitor allows adding new virtual functions to a family of classes, without modifying 
the classes. Instead, a visitor class is created that implements all of the appropriate specializations 
of the virtual function. The visitor takes the instance reference as input, and implements the goal 
through double dispatch.

Moving operations into visitor classes is beneficial when

    many unrelated operations on an object structure are required,
    the classes that make up the object structure are known and not expected to change,
    new operations need to be added frequently,
    an algorithm involves several classes of the object structure, but it is desired to manage it in one single location,
    an algorithm needs to work across several independent class hierarchies.

A drawback to this pattern, however, is that it makes extensions to the class hierarchy more difficult, 
as new classes typically require a new visit method to be added to each visitor.

https://en.wikipedia.org/wiki/Visitor_pattern

https://stackoverflow.com/questions/33602705/best-way-to-implement-visitor-pattern-in-kotlin
