package Elements;

// Conductive.java

// Place all interfaces here
interface Conductive {
    float percent_conductive();
    // returns ranges in 0-1
}

interface Magnetic {
    int magneticstrength();
    // returns int
    int magnetictype();
    // returns 1: Ferromagnetic, 2: Paramagnetic
}

interface Radioactive {
    int halflife();
    // returns num of days of elems half life
    void radiate();
    // prints elem's string output + emits radiation
}