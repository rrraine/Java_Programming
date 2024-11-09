package Elements;

// PostTransitionMetal.java
public abstract class PostTransitionMetal extends Element {
    public PostTransitionMetal(int num, String symbol, String name, double weight, double melt, double boil) {
        super(num, symbol, name, weight, melt, boil);
    }

    // Element op
    @Override
    public int state(double temp) {
        if (temp < super.melt)
            return 1;
        if (temp > super.melt && temp < super.boil)
            return 2;

        return 3;

    }

    // inner classes
    public static class Tin extends PostTransitionMetal {
        public Tin() {
            super(50, "Sn", "Tin", 118.7, 231.9, 2602);
        }

    }

    public static class Aluminum extends PostTransitionMetal implements Conductive {
        public Aluminum() {
            super(13, "Al", "Aluminum", 27, 660.3, 2470);
        }

        // Conductive op
        @Override
        public float percent_conductive() {
            return 0.61f;
        }
    }
}