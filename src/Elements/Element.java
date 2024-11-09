package Elements;
// Element.java
// Also put Actinide and Uranium as inner class here

public abstract class Element implements Comparable<Element> {
    int num;
    String symbol;
    String name;
    double weight;
    double melt;
    double boil;

    public Element(int num, String symbol, String name, double weight, double melt, double boil) {
        this.num = num;
        this.symbol = symbol;
        this.name = name;
        this.weight = weight;
        this.melt = melt;
        this.boil = boil;
    }
    public Element() {}

    public int getAtomicNum() {
        return num;
    }
    public String getElementSymbol() {
        return symbol;
    }
    public String getElementName() {
        return name;
    }
    public double getAtomicWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return num + " " + name + " (" + symbol + ")";
    }

    // methods
    public abstract int state(double temp);


    // COMPARATORS
    public int compareTo(Element e) {
        return Double.compare(this.weight, e.weight);
    }



    // inner classes
    //public static Actinide extends Element {
    //public Actinide() {
    // TODO constructor
    //}
    //}

    //public static Uranium extends Element {
    // public Uranium() {
    // TODO constructor
    //}
    //}

}
