package esercitazione5.es4.dynamicarray;

import esercitazione5.es4.modules.Document;

public class DynamicArrayOfDocuments {
    private static final int allocationSize = 10;
    private int size;
    private Document arr[];

    public DynamicArrayOfDocuments() {
        arr = new Document[allocationSize];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Document get(int index) {
        return arr[index];
    }

    public void add(Document d) {
        for (int i=0; i<size; i++) {
            if (arr[i].equals(d)) return;
        }
        // per evitare che lo stesso documento sia presente due volte.
        if (size < arr.length) {
            arr[size] = d;
            size++;
        } else {
            Document temp[] = arr;
            arr = new Document[arr.length + allocationSize];
            for (int i=0; i<temp.length; i++) {
                arr[i] = temp[i];
            }
            arr[size] = d;
            size++;
        }
    }
}
