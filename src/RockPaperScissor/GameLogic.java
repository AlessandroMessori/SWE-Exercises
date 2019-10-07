package RockPaperScissor;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Random;

public class GameLogic {

    private final Scanner scanner;

    public GameLogic(InputStream input) {
        this.scanner = new Scanner(input);
    }

    public void close() {
        this.scanner.close();
    }

    private Outcome choiceSubmitted(Choice userChoice) {
        Random r = new Random();
        Choice computerChoice = Choice.getRandomChoice(r);
        Outcome outcome;

        System.out.println("il computer gioca " + computerChoice.toString());

        outcome = userChoice.resultAgainst(computerChoice);
        System.out.println(outcome.Message);

        while (outcome == Outcome.DRAW) {
            String move = this.scanner.nextLine();

            userChoice = Choice.parseInput(move);
            computerChoice = Choice.getRandomChoice(r);
            System.out.println("il computer gioca " + computerChoice.toString());

            outcome = userChoice.resultAgainst(computerChoice);
            System.out.println(outcome.Message);
        }

        return outcome;
    }


    public void round() {
        String move = this.scanner.nextLine();
        Choice userChoice = Choice.parseInput(move);
        Outcome outcome = this.choiceSubmitted(userChoice);
    }


}
