package esercitazione6.modules;

import esercitazione6.modules.exceptions.NoCardsException;
import esercitazione6.modules.exceptions.NoFichesException;
import esercitazione6.modules.utils.PointsUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

public class MatchSimulation {
    private final Deck deck;
    private final Collection<Player> players;
    private final Dealer dealer;
    private final Hashtable<String, Integer> points;

    public MatchSimulation(Collection<Player> players, Dealer dealer) throws NoFichesException {
        for (Player p : players) {
            if (p.getFiches()<1) {
                throw new NoFichesException("Player "+p.getName()+" has no fiches yet.");
            }
        }
        deck = new Deck();
        this.players = players;
        this.dealer = dealer;
        points = new Hashtable<>();
    }

    private void getCall (Player p) {
        int call = p.call();
        try {
            p.decreaseFiches(call);
        } catch (NoFichesException e) {
            System.out.println("Players " + p.getName() + " has not enough fiches, the call has been set to his/her maximum fiches.");
            call = p.getFiches();
            p.resetFiches();
        }
        p.setLastCall(call);
    }

    private void firstDraw(GenericPlayer p) {
        Card card;
        try {
            card = deck.drawCard();
            p.addCard(card);
        } catch (NoCardsException e) {
            card = deck.initializeDeckAndDraw();
            p.addCard(card);
        }
        System.out.println("Player " + p.getName() + " draws " + card + ".");
        points.put(p.getName(), PointsUtils.getPoints(p.getCards()));
        System.out.println("Player " + p.getName() + " has " + points.get(p.getName()) + " points.\n");
    }

    private void playerMatch(GenericPlayer p) {
        Card card;
        int currentPoints = 0;
        while(currentPoints>=0 && currentPoints<21 && p.drawCard(getOtherPlayersCards(p))) {
            System.out.println("Player "+p.getName()+" asks for a card.");
            try {
                card = deck.drawCard();
                p.addCard(card);
            } catch (NoCardsException e) {
                card = deck.initializeDeckAndDraw();
                p.addCard(card);
            }
            System.out.println("Player " + p.getName() + " draws " + card + ".");
            currentPoints = PointsUtils.getPoints(p.getCards());
            points.put(p.getName(), currentPoints);
            System.out.println("Player " + p.getName() + " has " + points.get(p.getName()) + " points.");
        }
        System.out.println();
    }

    private void calculateWinLose (Player p) {
        if (points.get(p.getName()) > points.get(dealer.getName())) {
            p.win(p.getLastCall()*2);
            dealer.loose(p.getLastCall());
            System.out.println("Player "+p.getName()+" wins "+p.getLastCall()+" fiches.");
        } else {
            dealer.win(p.getLastCall());
            System.out.println("Player "+p.getName()+" looses "+p.getLastCall()+" fiches.");
        }
        p.resetCards();
        p.setLastCall(0);
        System.out.println("Player "+p.getName()+" has "+p.getFiches()+" fiches.");
        if (p.getFiches()<1) {
            System.out.println("Player "+p.getName()+" has no fiches yet.");
            players.remove(p);
        }
    }

    public void simulateMatch() {
        for (Player p : players) getCall(p);
        for (Player p : players) firstDraw(p);
        firstDraw(dealer);
        System.out.println();
        for (Player p : players) playerMatch(p);
        playerMatch(dealer);
        System.out.println();
        for (Player p : players) calculateWinLose(p);

        System.out.println("Player "+dealer.getName()+" has a balance of " + dealer.getFiches() + " fiches.");
        dealer.resetCards();

        deck.initializeDeck();
    }

    private List<List<Card>> getOtherPlayersCards(GenericPlayer p1) {
        List<List<Card>> playersCards = new ArrayList<>();
        playersCards.add(dealer.getCards());
        for(Player p2 : players) {
            if (!(p1.equals(p2))) playersCards.add(p2.getCards());
        }
        return playersCards;
    }

    public void addPlayer(Player p) throws NoFichesException {
        if (p.getFiches() < 1) throw new NoFichesException("Player "+p.getName()+" has no fiches yet.");
        players.add(p);
    }

    public void removePlayer(Player p) {
        players.remove(p);
    }
}
