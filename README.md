# Java OOPS Projects

This workspace contains Java practice projects focused on object-oriented programming and core Java concepts.

## Projects

- `AutoBoxing/` - Examples of Java auto-boxing and unboxing behavior.
- `Constructor/` - Constructor and inheritance practice, including `Student` and subclasses of `Animal`.
- `Dog_Array/` - Array examples using dog classes such as `Dog`, `Dog2`, and `GoodDog`.
- `Garbage_Collector/` - Garbage collection demo code.
- `Generics/` - Generic types and collections examples.
- `Guessing_Game/` - A number guessing game with `GuessGame` and `Player` classes.
- `Head_First/` - Exercises inspired by Head First Java, including `DrumKit`, `PhraseOMatic`, and `Shuffle_game`.
- `Inheritance/` - Inheritance and polymorphism examples.
- `Iterable_interface/` - Iterable and enhanced for-loop examples.
- `Maps/` - Map usage examples.
- `Random/` - Java concept examples such as composition, aggregation, inheritance, and generalization.
- `SimpleStartup/` - Simple startup game project with helper classes.
- `Sorting/` - Sorting and music library examples using Jukebox-style classes.
- `StartupBust/` - Startup-themed Java game implementation.
- `Static_Keyword/` - Static keyword examples and test drive classes.
- `Statics/` - Static class and method examples.
- `StreamsAPI/` - Java Streams API examples.

## How to run

From the `Java_OOPS` directory, compile and run Java files using standard `javac` and `java` commands.

```bash
javac <path-to-file>.java
java <MainClass>
```

For example, to run the guessing game:

```bash
cd Guessing_Game
javac GuessGame.java Player.java
java GuessGame
```

If a package is used or a class depends on others, compile all required files in the same directory.

```bash
javac *.java
java MainClass
```

## Notes

This repository is intended for Java learning, experimentation, and practice with object-oriented programming principles.
