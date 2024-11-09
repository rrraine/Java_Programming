package Elements;

// TransitionMetal.java
public abstract class TransitionMetal extends Element {
    public TransitionMetal(int num, String symbol, String name, double weight, double melt, double boil) {
        super(num, symbol, name, weight, melt, boil);
    }

    // Element op
    public int state(double temp) {
        if (temp < super.melt)
            return 1;
        if (temp > super.melt && temp < super.boil)
            return 2;
        return 3;
    }

    // inner classes
    public static class Titanium extends TransitionMetal {
        public Titanium() {
            super(22, "Ti", "Titanium", 47.9, 1668, 3287);
        }
    }

    public static class Gold extends TransitionMetal implements Conductive {
        public Gold() {
            super(79, "Au", "Gold", 197, 1064, 2970);
        }

        // Conductive op
        @Override
        public float percent_conductive() {
            return 0.7f;
        }
    }

    public static class Zinc extends TransitionMetal implements Conductive {
        public Zinc() {
            super(30, "Zn", "Zinc", 65.4, 419.5, 907.0);
        }

        // Conductive op
        @Override
        public float percent_conductive() {
            return 0.27f;
        }
    }

    public static class Iron extends TransitionMetal implements Magnetic {
        public Iron() {
            super(26, "Fe", "Iron", 55.8, 1538, 2862);
        }

        // Magnetic op
        @Override
        public int magneticstrength() {
            return 1710;
        }
        @Override
        public int magnetictype() {
            return 1;
        }
    }

    public static class Copper extends TransitionMetal implements Conductive {
        public Copper() {
            super(29, "Cu", "Copper", 63.5, 1085, 2562);
        }

        // Conductive op
        @Override
        public float percent_conductive() {
            return 1.0f;
        }
    }

    public static class Technetium extends TransitionMetal implements Conductive, Magnetic, Radioactive {
        public Technetium() {
            super(43, "Tc", "Technetium", 98, 2157, 4265);
        }

        // Conductive op
        @Override
        public float percent_conductive() {
            return 0.65f;
        }

        // Magnetic op
        @Override
        public int magneticstrength() {
            return 270;
        }
        @Override
        public int magnetictype() {
            return 2;
        }

        // Radioactive op
        @Override
        public int halflife() {
            return 61;
        }
        @Override
        public void radiate() {
            System.out.println(super.toString() + " emitting radiation");
        }
    }
}