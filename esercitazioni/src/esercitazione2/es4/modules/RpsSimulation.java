package esercitazione2.es4.modules;

public class RpsSimulation {
    private RpsSimulation () {}

    private static Player calculateGameWinner (Player p1, Player p2) {
        if (p1.getShape() == p2.getShape()) return null;
        switch (p1.getShape()) {
            case PAPER -> {
                if (p2.getShape() == Shape.ROCK) return p1;
                return p2;
            }
            case ROCK -> {
                if (p2.getShape() == Shape.PAPER) return p2;
                return p1;
            }
            default -> {  //scissors
                if (p2.getShape() == Shape.PAPER) return p1;
                return p2;
            }
        }
    }

    public static Player simulateMatch(Player p1, Player p2, int pointsToWin) {
        int p1Points = 0, p2Points = 0;

        while (p1Points < pointsToWin && p2Points < pointsToWin) {
            p1.throwShape();
            p2.throwShape();
            System.out.println(p1.getName()+" throws " + p1.getShape());
            System.out.println(p2.getName()+" throws " + p2.getShape());

            Player winner = calculateGameWinner(p1, p2);
            if (winner == null) System.out.println("It's a draw!");
            else {
                System.out.println(winner.getName() + " wins the game!");
                if (winner == p1) p1Points++;
                else if (winner == p2) p2Points++;
            }

            System.out.println("Current result: "+ p1.getName() + " " + p1Points+", " + p2.getName() + " " + p2Points+"\n");
        }
        if (p1Points > p2Points) {
            System.out.println(p1.getName()+" WINS THE MATCH!");
            return p1;
        } else {
            System.out.println(p2.getName()+" WINS THE MATCH!");
            return p2;
        }
    }
}
