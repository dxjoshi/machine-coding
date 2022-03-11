# Object Oriented Design

**4 Imp UML diagrams:**     
1. [Use Case Diagrams](https://www.educative.io/courses/grokking-the-object-oriented-design-interview/7npMYmzm8DA)
2. [Class Diagram](https://www.educative.io/courses/grokking-the-object-oriented-design-interview/g7Lw3O0A2Aj)
    - A class is depicted in the class diagram as a rectangle with three horizontal sections: The class’s name, its fields/variables, and its methods/operations.
    - Class can have following relationships:
        - **Association:** If two classes in a model need to communicate with each other, there is association between them. 
        - **Multiplicity:** Multiplicity indicates how many instances of a class participate in the relationship. It is a constraint that specifies the range of permitted cardinalities between two classes.
        - **Composition:** Composition implies a relationship where the child cannot exist independent of the parent. **A HAS-A B, but B cannot exist without A**
        - **Aggregation:** Aggregation implies a relationship where the child can exist independently of the parent. **A HAS-A B, but B can exist without A**
        - **Generalization:** Generalization is the mechanism for combining similar classes of objects into a single, more general class. Ex. Manager and Employee are Person.
3. [Sequence diagram](https://www.educative.io/courses/grokking-the-object-oriented-design-interview/7nX38BMK9NO)
    - Sequence diagrams show a detailed flow for a specific use case or even just part of a particular use case.
    - A sequence diagram has two dimensions: The vertical dimension shows the sequence of messages in the chronological order that they occur; the horizontal dimension shows the object instances to which the messages are sent.
4. [Activity Diagrams](https://www.educative.io/courses/grokking-the-object-oriented-design-interview/B8RPL3VEl8N)
    - An activity diagram shows the flow of control for a system functionality; it emphasizes the condition of flow and the sequence in which it happens.
    - Activity diagram captures the process flow. It is used for functional modeling. A functional model represents the flow of values from external inputs, through operations and internal data stores, to external outputs.
    

