package RockPaperScissor;


import java.io.InputStream;
import java.util.Scanner;
import java.util.Random;

public class GameLogic {

    private int winCounter;
    private int drawCounter;
    private int loseCounter;

    private final Scanner scanner;

    public GameLogic(InputStream input) {
        this.scanner = new Scanner(input);
        this.winCounter = 0;
        this.drawCounter = 0;
        this.loseCounter = 0;
    }

    private void close() {
        this.scanner.close();
    }

    private Outcome choiceSubmitted(Choice userChoice) {
        Random r = new Random();
        Choice computerChoice = Choice.getRandomChoice(r);
        Outcome outcome;

        System.out.println("il computer gioca " + computerChoice.toString());

        outcome = userChoice.resultAgainst(computerChoice);
        System.out.println(outcome.Message);


        return outcome;
    }

    private void updateScoreBoard(Outcome out) {
        switch (out) {
            case WINNER:
                this.winCounter++;
                break;
            case DRAW:
                this.drawCounter++;
                break;
            case LOSER:
                this.loseCounter++;
                break;
        }
    }

    private void printScoreboard() {
        System.out.printf("Vittorie: %d, Pareggi: %d, Sconfitte %d\n", this.winCounter, this.drawCounter, this.loseCounter);
    }


    void round() {
        String move = this.scanner.nextLine();
        while (!move.equals("END")) {
            Choice userChoice = Choice.parseInput(move);
            Outcome outcome = this.choiceSubmitted(userChoice);
            this.updateScoreBoard(outcome);
            this.printScoreboard();
            move = this.scanner.nextLine();
        }
        this.close();
    }


}
