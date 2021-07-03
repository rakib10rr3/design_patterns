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
        System.out.println("Rubber Duck squeak");
    }
}

class MuteQuack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Can't quack");
    }
}