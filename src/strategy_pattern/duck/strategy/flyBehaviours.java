package strategy_pattern.duck.strategy;

interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("Flying with wings");
    }
}

class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("Can not fly");
    }
}

//TODO Fly with rockets