package strategy_pattern.duck.legacy;

abstract public class Duck {

    public void quack() {
        System.out.println("I can quack!");
    }

    public void swim() {
        System.out.println("I can swim!");
    }

    public abstract void display();

    //TODO add fly()
//    public void fly() {
//        //System.out.println("I can fly!");
//    }

    @Override
    public String toString() {
        display();
        quack();
        swim();
//        fly();
        return "";
    }
}

class MallardDuck extends Duck {

    @Override
    public void display() {
        System.out.println("I am Mallard duck");
    }

}

class RedheadDuck extends Duck {

    @Override
    public void display() {
        System.out.println("I am Readhead duck");
    }

}

class RubberDuck extends Duck {

    @Override
    public void quack() {
        System.out.println("I can squeak!");
    }

    @Override
    public void display() {
        System.out.println("I am Rubber duck");
    }

}

//class WoodenDuck extends Duck {
//
//    @Override
//    public void display() {
//        System.out.println("I am wooden duck");
//    }
//
//}
