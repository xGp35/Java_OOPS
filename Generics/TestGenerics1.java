import java.util.*;

public class TestGenerics1 {
    public static void main(String[] args) {

        TestGenerics1 test1 = new TestGenerics1();
        TestGenerics1.go();
    }

    public void go() {
        List<Animal> animals = List.of(new Dog(), new Cat(), new Dog());
        takeAnimals(animals);

        // List<Dog> dogs = List.of(new Dog(), new Dog());
        // takeAnimals(dogs); // This will error out
    }

    // public void takeAnimals(List<Animal> animals) {
    //     for (Animal a: animals) {
    //         a.eat();
    //     }
    // }

    // public void takeAnimals(List<? extends Animal> animals) {
    //     for (Animal a: animals) {
    //         a.eat();
    //     }
    // }

    public <T extends Animal> void takeAnimals(List<T> list) {
        for (Animal a: animals) {
            a.eat();
        }
    }
}