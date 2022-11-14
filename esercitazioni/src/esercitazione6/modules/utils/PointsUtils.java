package esercitazione6.modules.utils;

import esercitazione6.modules.Card;

import java.util.ArrayList;
import java.util.List;

public class PointsUtils {
    public static int getPoints(List<Card> cards) {
        List<int[]> multipleValues = new ArrayList<>();
        List<Integer> singleValues = new ArrayList<>();
        for (Card c : cards) {
            if ((c.getNumericValues().length>1) && multipleValues.size()<2) multipleValues.add(c.getNumericValues());
            else singleValues.add(c.getNumericValues()[0]);
        }
        int [][] values;
        if (multipleValues.size()==1) {
            values = new int [2][singleValues.size()+1];
            values[0][0] = multipleValues.get(0)[0];
            values[1][0] = multipleValues.get(0)[1];
            if (singleValues.size()>0) {
                for (int i = 0; i < values.length; i++) {
                    for (int j = 1; j < singleValues.size() + 1; j++) {
                        values[i][j] = singleValues.get(j-1);
                    }
                }
            }
        }
        else if (multipleValues.size()==2) {
            values = new int [4][singleValues.size()+2];
            values[0][0] = multipleValues.get(0)[0];
            values[0][1] = multipleValues.get(1)[0];
            values[1][0] = multipleValues.get(0)[0];
            values[1][1] = multipleValues.get(1)[1];
            values[2][0] = multipleValues.get(0)[1];
            values[2][1] = multipleValues.get(1)[0];
            values[3][0] = multipleValues.get(0)[1];
            values[3][1] = multipleValues.get(1)[1];
            if (singleValues.size()>0) {
                for (int i = 0; i < values.length; i++) {
                    for (int j = 2; j < singleValues.size() + 2; j++) {
                        values[i][j] = singleValues.get(j-2);
                    }
                }
            }
        } else {
            values = new int [1][singleValues.size()];
            for (int i=0; i<singleValues.size(); i++) values[0][i] = singleValues.get(i);
        }

        int max = -1;
        for (int[] v : values) {
            int sum = sumArray(v);
            if (sum<=21 && sum>max) max = sum;
        }
        return max;
    }

    public static int sumArray (int [] a) {
        int sum = 0;
        for (int x : a) sum += x;
        return sum;
    }
}
