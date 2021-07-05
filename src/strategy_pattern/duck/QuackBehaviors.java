package strategy_pattern.duck;

interface QuackBehavior {
    void quack();
}

class Quack implements QuackBehavior{

    @Override
    public void quack() {
        System.out.println("Quack Quack!");
    }
}

class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}

class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Can't quack");
    }
}