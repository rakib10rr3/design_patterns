package state_pattern.gumball_machine.state;


public interface State {
    void insertCoin();
    void ejectCoin();
    void turnCrank();
    void dispense();
}

class NoCoinState implements State{

    GumballMachine gumballMachine;

    public NoCoinState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You inserted a coin");
        gumballMachine.setState(gumballMachine.hasCoinState);
    }

    @Override
    public void ejectCoin() {
        System.out.println("You haven't inserted a coin");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but there's no coin");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }
}

class HasCoinState implements State{

    GumballMachine gumballMachine;

    public HasCoinState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You can't insert another coin");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Coin returned");
        gumballMachine.setState(gumballMachine.noCoinState);
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.soldState);
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}

class SoldOutState implements State{

    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("You can't insert now, the machine is sold out!");
    }

    @Override
    public void ejectCoin() {
        System.out.println("You can't eject, the machine in sold out!");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned but the machine is out of gumballs!");
    }

    @Override
    public void dispense() {
        System.out.println("There's no gumball in the machine");
    }
}

class SoldState implements State{

    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait, we are getting a gumball");
    }

    @Override
    public void ejectCoin() {
        System.out.println("You already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice won't give you another gumball");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.noCoinState);
        } else {
            System.out.println("Oops, out of gumballs");
            gumballMachine.setState(gumballMachine.soldOutState);
        }

    }
}


