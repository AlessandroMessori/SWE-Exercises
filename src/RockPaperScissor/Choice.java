package RockPaperScissor;


import java.util.Random;

public enum Choice {
    CARTA, FORBICE, SASSO;

    //restituisce OUTCOME in base al confronto di this con input
    public Outcome resultAgainst(Choice other) {

        if (this == other) {
            return Outcome.DRAW;
        }

        if (this == SASSO) {
            return (other == FORBICE) ? Outcome.WINNER : Outcome.LOSER;
        }

        if (this == CARTA) {
            return (other == SASSO) ? Outcome.WINNER : Outcome.LOSER;
        }

        if (this == FORBICE) {
            return (other == CARTA) ? Outcome.WINNER : Outcome.LOSER;
        }

        return Outcome.DRAW;

    }

    //restitiuisce tipo di Choice in base ad input
    public static Choice parseInput(String input) {
        switch (input) {
            case "SASSO":
                return Choice.SASSO;
            case "CARTA":
                return Choice.CARTA;
            default:
                return Choice.FORBICE;
        }
    }

    //restituisce un valore a caso di Choise, dato un oggetto Random input
    public static Choice getRandomChoice(Random random) {
        int ran = random.nextInt(3);

        switch (ran) {
            case 0:
                return Choice.SASSO;
            case 1:
                return Choice.CARTA;
            case 2:
                return Choice.FORBICE;
        }

        return Choice.SASSO;

    }
}