public class AnimalTester {
    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 5, "Brown", "Bulldog");
        Cat cat = new Cat("Kitty", 3, "White", "Persian");
        System.out.println("1.========");
        System.out.println(dog.info());
        System.out.println("2.========");
        System.out.println(cat.info());
        System.out.println("3.========");
        dog.makeSound();
        System.out.println("4.========");
        cat.makeSound();
    }
}

class Animal {
    public String name;
    public int age;
    public String color;

    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public void makeSound() {
        System.out.println("Animal makes a sound");
    }

    public String info() {
        return "Name: " + name + "\nAge: " + age + "\nColor: " + color + "\n";
    }
}

class Dog extends Animal {
    public String breed;

    public Dog(String name, int age, String color, String breed) {
        super(name, age, color);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(color + " color " + name + " is barking");
    }

    @Override
    public String info() {
        return super.info() + "Breed: " + breed;
    }
}

class Cat extends Animal {
    public String breed;

    public Cat(String name, int age, String color, String breed) {
        super(name, age, color);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println(color + " color " + name + " is meowing");
    }
    @Override
    public String info() {
        return super.info() + "Breed: " + breed;
    }
}