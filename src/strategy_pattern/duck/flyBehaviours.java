package strategy_pattern.duck;

interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("Flying like a duck");
    }
}

class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("Can not fly");
    }
}