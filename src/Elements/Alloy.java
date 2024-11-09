package Elements;

// Alloy.java
import java.util.List;
import java.util.ArrayList;

public abstract class Alloy extends Element {
    String name;
    List<Element> elements;

    public Alloy(String name, Element e1, Element e2) {
        super();
        elements = new ArrayList<>();
        elements.add(e1);
        elements.add(e2);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
    // Element op
    @Override
    public int state(double temp) {
        return 0;
    }


    public String getName() {
        return name;
    }
    public List getElements() {
        return elements;
    }

    // inner classes
    public static class Steel extends Alloy implements Magnetic {
        public Steel() {
            super ("Steel", new TransitionMetal.Iron(), new TransitionMetal.Copper());
        }

        // Magnetic op
        @Override
        public int magneticstrength() {
            return 1950;
        }
        @Override
        public int magnetictype() {
            return 1;
        }
    }

    public static class Bronze extends Alloy {
        public Bronze() {
            super ("Bronze", new PostTransitionMetal.Tin(), new TransitionMetal.Copper());
        }
    }

    public static class Brass extends Alloy implements Conductive {
        public Brass() {
            super ("Brass", new TransitionMetal.Copper(), new TransitionMetal.Zinc());
        }

        // Conductive op
        @Override
        public float percent_conductive() {
            return 0.28f;
        }
    }
}