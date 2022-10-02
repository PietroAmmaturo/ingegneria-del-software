package esercitazione2.es2;

import esercitazione2.es2.modules.Coin;
import esercitazione2.es2.modules.CoinFairnessTest;

public class Main {
    public static void main(String[] args)
    {
       Coin cFair = new Coin(0.5);
       Coin cNotFair1 = new Coin(0.1);
       Coin cNotFair2 = new Coin(0.48);
       Coin cNotFair3 = new Coin(0.4);

       System.out.println(CoinFairnessTest.isFair(cFair));
       System.out.println(CoinFairnessTest.isFair(cNotFair1));
       System.out.println(CoinFairnessTest.isFair(cNotFair2));
       System.out.println(CoinFairnessTest.isFair(cNotFair3));
    }
}
