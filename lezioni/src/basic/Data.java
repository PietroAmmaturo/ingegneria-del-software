package basic;

public class Data {
    private int giorno;
    private int mese;
    private int anno;

    public Data(int giorno, int mese, int anno) {
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
    }

    public Data(int mese, int anno) {
        if (mese < 1 || mese > 12) {
            this.mese = 1;
        } else {
            this.mese = mese;
        }
    }

    public Data(int anno) {
        this(1, anno);
    }

    public int getGiorno() {
        return this.giorno;
    }

    public int getMese() {
        return this.mese;
    }

    public int getAnno() {
        return anno;
    }

    public void setGiorno(int giorno) {
        this.giorno = giorno;
    }

    public void capodanno() {
        giorno = 1;
        mese = 1;
        anno = anno + 1;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + giorno;
        result = prime * result + mese;
        result = prime * result + anno;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Data other = (Data) obj;
        if (giorno != other.giorno)
            return false;
        if (mese != other.mese)
            return false;
        if (anno != other.anno)
            return false;
        return true;
    }

}
