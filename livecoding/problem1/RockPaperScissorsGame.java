import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    private static final int TOTAL_ROUNDS = 5;

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        String[] playerMoves = new String[TOTAL_ROUNDS];
        String[] computerMoves = new String[TOTAL_ROUNDS];
        String[] results = new String[TOTAL_ROUNDS];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int roundIndex = 0; roundIndex < TOTAL_ROUNDS; roundIndex++) {
            System.out.print("Round " + (roundIndex + 1) + " - Enter your move (Rock/Paper/Scissors): ");
            String playerMove = userInputScanner.nextLine().trim();
            String computerMove = MOVES[randomGenerator.nextInt(MOVES.length)];

            String result = playRound(playerMove, computerMove);

            playerMoves[roundIndex] = playerMove;
            computerMoves[roundIndex] = computerMove;
            results[roundIndex] = result;

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        printSummaryTable(playerMoves, computerMoves, results);
        printFinalSummary(wins, losses, draws);

        userInputScanner.close();
    }

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        boolean playerWins = (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors"))
                || (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock"))
                || (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    private static void printSummaryTable(String[] playerMoves, String[] computerMoves, String[] results) {
        System.out.println("Round | Player Move | Computer Move | Result");
        for (int roundIndex = 0; roundIndex < playerMoves.length; roundIndex++) {
            System.out.println((roundIndex + 1) + " | " + playerMoves[roundIndex] + " | "
                    + computerMoves[roundIndex] + " | " + results[roundIndex]);
        }
    }

    private static void printFinalSummary(int wins, int losses, int draws) {
        double winPercentage = ((double) wins / TOTAL_ROUNDS) * 100;
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws
                + " | Win % = " + String.format("%.1f", winPercentage) + "%");
    }
}
