package exercises.concorrenza.ex20190125;

public interface TenIntArray {
    /**
     * Ritorna il valore contenuto in posizione pos, se presente,
     * altrimenti lancia una InvalidIndexException.
     */
    public int get(int pos) throws Exception;

    /**
     * Rimuove l’ultimo elemento dall’array.
     * Se l’array e’ vuoto non fa nulla.
     */
    public void remove();

    /**
     * Aggiunge val nella prima posizione libera dell’array.
     * Se l’array e’ pieno, blocca il chiamante fino a quando una
     * posizione si libera.
     */
    public void add(int val);
}
