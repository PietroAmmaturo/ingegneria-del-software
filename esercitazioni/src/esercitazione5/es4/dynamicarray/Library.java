package esercitazione5.es4.dynamicarray;

import esercitazione5.es4.modules.Document;

public class Library {
    final private DynamicArrayOfDocuments catalogue; //polimorfismo

    public Library() {
        catalogue = new DynamicArrayOfDocuments();
    }

    public void addDocument(Document d) {
        catalogue.add(d);
    }

    public boolean loanDocument(Document d) {
        d.loanDocument();
        // a runtime in base al tipo dinamico viene chiamato il metodo corretto
        // il metodo deve essere presente nella superclasse
        return d.isLoanable();
    }

    public Document getDocumentByCode(int code) {
        for (int i=0; i< catalogue.size(); i++) {
            Document d = catalogue.get(i);
            if (d.getCode() == code) return d;
        }
        return null;
    }

    public int generateCode() {
        return catalogue.size()+1;
    }

    public String toString() {
        String s = "";
        for (int i=0; i< catalogue.size(); i++) {
            s += catalogue.get(i).toString() + "\n\n";
        }
        return s.substring(0, s.length()-2);
    }
}
