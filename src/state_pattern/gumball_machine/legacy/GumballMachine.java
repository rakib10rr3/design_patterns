package state_pattern.gumball_machine.legacy;

public class GumballMachine {

    final static int SOLD_OUT = 0;
    final static int NO_COIN = 1;
    final static int HAS_COIN = 2;
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_COIN;
        }
    }

    public void insertCoin() {
        switch (state) {
            case SOLD_OUT -> System.out.println("You can't insert now, the machine in sold out!");
            case NO_COIN -> {
                state = HAS_COIN;
                System.out.println("You inserted a coin");
            }
            case HAS_COIN -> System.out.println("You can't insert another coin");
            case SOLD -> System.out.println("Please wait, we are getting a gumball");
        }
    }

    public void ejectCoin() {
        switch (state) {
            case SOLD_OUT -> System.out.println("You can't eject, the machine in sold out!");
            case NO_COIN -> System.out.println("You haven't inserted a coin");
            case HAS_COIN -> {
                System.out.println("Coin returned");
                state = NO_COIN;
            }
            case SOLD -> System.out.println("You already turned the crank");
        }
    }

    public void turnCrank() {
        switch (state) {
            case SOLD_OUT -> System.out.println("You turned but the machine is out of gumballs!");
            case NO_COIN -> System.out.println("You turned but there's no coin");
            case HAS_COIN -> {
                System.out.println("You turned ... ");
                state = SOLD;
                dispense();
            }
            case SOLD -> System.out.println("Turning twice won't give you another gumball");
        }
    }

    public void dispense() {
        switch (state) {
            case SOLD_OUT -> System.out.println("There's no gumball in the machine");
            case NO_COIN -> System.out.println("You need to pay first");
            case HAS_COIN -> System.out.println("You need to turn the crank");
            case SOLD -> {
                System.out.println("A gumball comes rolling out!");
                count--;
                if (count == 0) {
                    System.out.println("Oops, out of gumballs");
                    state = SOLD_OUT;
                } else {
                    state = NO_COIN;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\nMighty Gumball, Inc.");
        result.append("\nJava-enabled Standing Gumball Model #2004\n");
        result.append("Inventory: ").append(count).append(" gumball");
        if (count != 1) {
            result.append("s");
        }
        result.append("\nMachine is ");
        if (state == SOLD_OUT) {
            result.append("sold out");
        } else if (state == NO_COIN) {
            result.append("waiting for quarter");
        } else if (state == HAS_COIN) {
            result.append("waiting for turn of crank");
        } else if (state == SOLD) {
            result.append("delivering a gumball");
        }
        result.append("\n");
        return result.toString();
    }
}
