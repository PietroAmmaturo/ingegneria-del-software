package esercitazione6.modules;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player{
    public HumanPlayer(String name, int fiches) {
        super(name, fiches);
    }

    private void printCards (List<Card> cards) {
        for (Card c : cards) {
            System.out.println(c);
        }
    }

    @Override
    public boolean drawCard(List<List<Card>> cards) {
        System.out.println(">>> " + getName().toUpperCase() + ", these are DEALER'S CARDS:");
        printCards(cards.get(0));
        cards.remove(0);
        for (int i=0; i<cards.size(); i++) {
            List<Card> c = cards.get(0);
            System.out.println(">>> " + getName().toUpperCase() + ", these are PLAYER "+ (i+1) +"'S CARDS:");
            printCards(c);
        }
        System.out.println(">>> " + getName().toUpperCase() + ", these are YOUR CARDS:");
        printCards(this.cards);
        String in = "";
        boolean choice = false;
        while (in.equals("")) {
            System.out.println(">>> " + getName().toUpperCase() + ", do you want a card? (Y/N)");
            try {
                Scanner scanner = new Scanner(System.in);
                in = scanner.nextLine();
                if (in.toUpperCase().equals("Y")) choice=true;
                else if (in.toUpperCase().equals("N")) choice=false;
                else {
                    in="";
                    System.out.println(">>> Please insert 'Y' or 'N'.");
                }
            } catch (Exception e) {
                in = "";
                System.out.println(">>> Please insert 'Y' or 'N'.");
            }
        }
        return choice;
    }

    @Override
    public int call() {
        int call = -1;
        while (call <= 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(">>> " + getName().toUpperCase() + ", how many fiches do you want to call?");
            try {
                call = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(">>> Please insert a numeric value.");
            }
            if (call <= 0) System.out.println(">>> Please insert a positive value.");
            if (call > fiches) {
                call = -1;
                System.out.println(">>> You have only " + fiches + " fiches left.");
            }
        }
        return call;
    }
}
