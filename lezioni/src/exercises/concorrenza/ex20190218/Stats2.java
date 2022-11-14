package exercises.concorrenza.ex20190218;

import java.util.ArrayList;
import java.util.List;

public class Stats2 {
    private final List<Activity> activities;
    private final List<Nutrient> nutrients;

    private int caloriesBalance;

    public Stats2() {
        activities = new ArrayList<>();
        nutrients = new ArrayList<>();
        caloriesBalance = 0;
    }

    public synchronized void addActivity(Activity activity) {
        activities.add(activity);
        caloriesBalance -= activity.getCalories();
    }

    public synchronized  List<Activity> getActivities() {
        // List<Activity> res = new ArrayList<>(activities);
        // ritorna una nuova lista che contiene riferimenti agli stessi oggetti
        // se modificassi un oggetto nella lista ritornata esso dovrebbe essere modificato anche nella originale
        // ciò non accade poichè la list è final

        // meglio usare questo metodo
        List<Activity> res = new ArrayList<>();
        res.addAll(activities);
        return res;
    }

    public synchronized void addNutrient(Nutrient nutrient) {
        nutrients.add(nutrient);
        caloriesBalance += nutrient.getCalories();
    }

    public synchronized List<Nutrient> getNutrients() {
        List<Nutrient> res = new ArrayList<>();
        res.addAll(nutrients);
        return res;
    }

    public synchronized int getCaloriesBalance() {
        return caloriesBalance;
    }
}

class Activity {
    public int getCalories() {
        return 0;
    }
}

class Nutrient {
    public int getCalories() {
        return 0;
    }
}
