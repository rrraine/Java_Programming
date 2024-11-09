package Elements;
// Actinide.java

public abstract class Actinide extends Element {
    public Actinide(int num, String symbol, String name, double weight, double melt, double boil) {
        super (num, symbol, name, weight, melt, boil);
    }

    // Element op
    @Override
    public int state(double temp) {
        if (temp < super.melt)
            return 1;
        if (temp > super.melt && temp < super.boil)
            return 2;
        if (temp > super.melt && temp > super.boil)
            return 3;
        return 0;
    }

    // inner classes
    public static class Uranium extends Actinide implements Radioactive {
        public Uranium() {
            super(92, "U", "Uranium", 238, 1132.3, 4131);
        }

        // Radioactive op
        @Override
        public int halflife() {
            return 25166;
        }
        @Override
        public void radiate() {
            System.out.println(super.toString() + " emitting radiation");
        }
    }
}