package RockPaperScissor;


public enum Outcome {
    WINNER("Hai vinto!"), LOSER("Hai perso!"), DRAW("Parita'!");

    public String Message;

    private Outcome(String message) {
        this.Message = message;
    }

    public static Outcome winsIfTrue(boolean condition) {
        return condition ? Outcome.WINNER : Outcome.LOSER;
    }
}
