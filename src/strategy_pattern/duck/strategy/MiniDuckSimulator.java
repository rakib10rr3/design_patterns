package strategy_pattern.duck.strategy;

public class MiniDuckSimulator {
    public static void main(String[] args) {

        Duck mallardDuck = new MallardDuck(new FlyWithWings(), new Quack());
        System.out.println(mallardDuck);
        mallardDuck.setFlyBehavior(new FlyNoWay());
        System.out.println(mallardDuck);

        mallardDuck = new RubberDuck();

//        duck.setFlyBehavior(new FlyNoWay());
//        duck.performFly();
//
//        duck = new RubberDuck();
//        duck.performFly();
//        duck.performQuack();
    }

}
