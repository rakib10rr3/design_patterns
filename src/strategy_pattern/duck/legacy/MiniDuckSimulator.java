package strategy_pattern.duck.legacy;

public class MiniDuckSimulator {
    public static void main(String[] args) {

        Duck mallardDuck = new MallardDuck();
        System.out.println(mallardDuck);

        Duck redheadDuck = new RedheadDuck();
        System.out.println(redheadDuck);

        Duck rubberDuck = new RubberDuck();
        System.out.println(rubberDuck);
    }

}
