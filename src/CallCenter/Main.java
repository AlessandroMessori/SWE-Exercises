package CallCenter;

// this program simulates a call center with many callers trying to call an operator who can only receive 1 call at the same time

import java.util.ArrayList;
import java.util.Random;

class Operator {

    private boolean isFree;

    public boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(boolean value) {
        isFree = value;
    }

    // receives call from a caller,set isFree to false,terminates call and set isFree back to True after a few seconds
    synchronized public void receiveCall(Caller caller) throws Exception {
        try {
            System.out.println("Call with caller #" + caller.getNumber() + " started...");
            this.setIsFree(false);
            Thread.sleep(caller.getTimer() * 1000);
            System.out.println("Call with caller #" + caller.getNumber() + " terminated after " + caller.getTimer() + " seconds");
            this.setIsFree(true);
            caller.notifyAll();
        } catch (Exception e) {
            throw e;
        }
    }

    public Operator() {
        isFree = true;
    }


}

class Caller extends Thread {

    private int timer; // call time of the caller
    private int number; // caller identifier
    private Operator operator; // the operator the caller is trying to call

    int getTimer() {
        return timer;
    }

    int getNumber() {
        return number;
    }

    // tries to call the operator,if it isn't free the caller waits
    synchronized void call() throws Exception {
        while (!operator.getIsFree()) {
            try {
                wait();
            } catch (Exception e) {
                throw e;
            }
        }
        operator.receiveCall(this);
    }

    @Override
    public void run() {

        System.out.println("Starting Thread of Caller #"+number);

        try {
            call();
        } catch (Exception e) {

        }

    }

    public Caller(int timer, int number, Operator operator) {
        this.timer = timer;
        this.number = number;
        this.operator = operator;
    }


}

public class Main {
    private static ArrayList<Caller> callers;
    private static Operator operator;

    static void initCallers(int n) {
        for (int i = 0; i < n; i++) {
            callers.add(new Caller(new Random().nextInt(10), i, operator));
        }
    }

    public static void main(String args[]) {
        operator = new Operator();
        callers = new ArrayList<>();


        initCallers(5);

        for (Caller caller:callers)
        {
            caller.start();
        }


    }
}
