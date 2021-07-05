package state_pattern.gumball_machine.state;

public class GumballMachine {

    State noCoinState, hasCoinState, soldOutState, soldState;

    State state;
    private  int count = 0;

    public GumballMachine(int numberOfGumballs) {

        noCoinState = new NoCoinState(this);
        hasCoinState = new HasCoinState(this);
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);

        this.count = numberOfGumballs;

        if (numberOfGumballs > 0) {
            state = noCoinState;
        } else {
            state = soldOutState;
        }
    }

    public void insertCoin() {
        state.insertCoin();
    }

    public void ejectCoin() {
        state.ejectCoin();
    }

    public void turnCrank() {
        state.turnCrank();
        dispense();
    }

    public void dispense() {
        state.dispense();
    }

    void setState(State state) {
        this.state = state;
    }

    void releaseBall() {
        System.out.println("A gumball comes tolling out the slot...");
        if (count > 0)
            count--;
    }

    public int getCount() {
        return count;
    }

    public State getHasCoinState() {
        return hasCoinState;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2021\n");
        result.append("Inventory: ").append(count).append(" gumball");
        if (count > 1) {
            result.append("s");
        }

        result.append("\nMachine is ");

        if (state == soldOutState) {
            result.append("sold out");
        } else if (state == noCoinState) {
            result.append("waiting for quarter");
        } else if (state == hasCoinState) {
            result.append("waiting for turn of crank");
        } else if (state == soldState) {
            result.append("delivering a gumball");
        }
        result.append("\n");
        return result.toString();
    }
}
