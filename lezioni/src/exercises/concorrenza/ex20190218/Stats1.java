package exercises.concorrenza.ex20190218;

import java.util.ArrayList;
import java.util.List;

// voglio poter effettuare operazioni su activities e nutrients in contemporanea
// attenzione a cosa sincronizzare
public class Stats1 {
    private final List<Activity> activities;
    private final List<Nutrient> nutrients;

    private int caloriesBalance;

    public Stats1() {
        activities = new ArrayList<>();
        nutrients = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        // prendo il lock solo sulla lista di activities
        synchronized (activities) {
            // per evitare di aggiungere 2 attività alla stessa posizione
            // per evitare di leggere e scrivere contemporaneamente (guarda getActivities)
            activities.add(activity);
        }
    }

    public List<Activity> getActivities() {
        // List<Activity> res = new ArrayList<>(activities);
        // ritorna una nuova lista che contiene riferimenti agli stessi oggetti
        // se modificassi un oggetto nella lista ritornata esso dovrebbe essere
        // modificato anche nella originale
        // ciò non accade poichè la list è final

        // meglio usare questo metodo
        List<Activity> res = new ArrayList<>();
        // prendo il lock solo sulla lista di activities
        // per evitare che qualcuno scriva mentre sto leggendo la lista per ricopiarla
        synchronized (activities) {
            // aggiungo tutte le attività
            res.addAll(activities);
        }
        return res;
    }

    public synchronized void addNutrient(Nutrient nutrient) {
        synchronized (nutrients) {
            nutrients.add(nutrient);
        }
    }

    public synchronized List<Nutrient> getNutrients() {
        List<Nutrient> res = new ArrayList<>();
        synchronized (nutrients) {
            res.addAll(nutrients);
        }
        return res;
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
