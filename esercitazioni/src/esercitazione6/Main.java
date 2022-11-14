package esercitazione6;

import esercitazione6.modules.*;
import esercitazione6.modules.exceptions.NoFichesException;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Collection<Player> players = new HashSet<>();
        players.add(new HumanPlayer("Federico", 100));
        players.add(new DummyPlayer("Giacomo", 50));
        Dealer d = new Dealer();

        boolean repeat = true;

        do {
            try {
                MatchSimulation simulation = new MatchSimulation(players, d);
                simulation.simulateMatch();
            } catch (NoFichesException e) {
                System.out.println(e);
                System.exit(0);
            }

            System.out.println();
            String in = "";
            if (players.size()>0)
                while (in.equals("")) {
                    System.out.println("! Do you want to play again? (Y/N)");
                    try {
                        Scanner scanner = new Scanner(System.in);
                        in = scanner.nextLine();
                        if (in.toUpperCase().equals("Y")) repeat = true;
                        else if (in.toUpperCase().equals("N")) repeat = false;
                        else {
                            in = "";
                            System.out.println("! Please insert 'Y' or 'N'.");
                        }
                    } catch (Exception e) {
                        in = "";
                        System.out.println("! Please insert 'Y' or 'N'.");
                    }
                }
            else repeat=false;
            System.out.println();
        } while (repeat);
    }
}
