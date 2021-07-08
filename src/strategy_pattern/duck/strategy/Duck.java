package strategy_pattern.duck.strategy;

abstract public class Duck {

    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public abstract void display();

    public void performFly() { flyBehavior.fly(); }

    public void performQuack() {
        quackBehavior.quack();
    }

    void swim() {
        System.out.println("I can swim!");
    }

    void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    @Override
    public String toString() {
        display();
        swim();
        performFly();
        performQuack();
        return "";
    }
}

class MallardDuck extends Duck {

    MallardDuck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    @Override
    public void display() {
        System.out.println("I am Mallard duck");
    }
}

class RubberDuck extends Duck {

    RubberDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("I am Rubber duck");
    }
}