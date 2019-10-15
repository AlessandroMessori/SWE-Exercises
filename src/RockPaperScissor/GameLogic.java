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

    private Outcome choiceSubmitted(Choice userChoice) throws Exception {
        Random r = new Random();
        Choice computerChoice = Choice.getRandomChoice(r);
        Outcome outcome;

        System.out.println("il computer gioca " + computerChoice.toString());

        outcome = userChoice.resultAgainst(computerChoice);
        System.out.println(outcome.Message);

        while (outcome == Outcome.DRAW) {
            String move = this.scanner.nextLine();


            if (move.equals("END")) {
                throw new Exception();
            }

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
        while (!move.equals("END")) {
            Choice userChoice = Choice.parseInput(move);
            try {

                Outcome outcome = this.choiceSubmitted(userChoice);
            } catch (Exception e) {
                break;
            }
            move = this.scanner.nextLine();
        }

    }


}
