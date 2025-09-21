# DesignPatternsAssignment1

Implementing Factory method pattern to produce architecture for a smart bulb and smart lock

Repository Structure  
/src  
└── App.java  - one Java source file that contains all the classes and test driver code

Test Methods

All testing is done inside App.java in the main() method. The tests:  
Create BrandA and BrandB devices using their respective factories.  
Demonstrate behavior of bulbs: turning on/off, setting brightness, reading power usage from a file.  
Demonstrate behavior of locks: locking, unlocking, auto-locking, and updating lock status accordingly.  
Print device attributes (colour, wattage, status, usage) to confirm correctness.  

Test Output:

<img width="1138" height="571" alt="image" src="https://github.com/user-attachments/assets/da966695-4ec0-4c71-b7c5-87c24512e1db" />


These tests confirm that each factory consistently produces a family of products that behave correctly and maintain their brand-specific characteristics.

Importance of design pattern:  
Encapsulation of object creation: Clients (like App.java) do not directly instantiate devices (new BrandABulb()). Instead, they use factories (brandAFactory.createSmartBulb()), making the code flexible.

Product family consistency:
A factory guarantees that bulbs and locks come from the same brand, avoiding accidental mixing of BrandA bulbs with BrandB locks.
Polymorphism and extensibility:
Adding a new brand (e.g., BrandCFactory) requires no changes to existing client code — only a new factory and product implementations.

These attribute allow **Scalability** in the design. If there are more Lock brands or Bulb Brands we can extend as many classes as needed. It also allows the same client code to work with any family of Lock or Bulb, which makes it very **Flexible**. Having an assembly to create any Brand similiarly keeps **consistency**, reducing potential errors for larger systems.
