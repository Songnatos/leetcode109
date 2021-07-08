public class Main {

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.hello();
        cat.hello();

        dog.doSomething();
        cat.doSomething();
    }
}
