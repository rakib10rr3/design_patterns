package strategy_pattern.duck.strategy;

interface QuackBehavior {
    void quack();
}

class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Normal Quack!");
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
        System.out.println("Silent");
    }
}