public class Hole {
    private int holeNumber;
    private int distance;
    private int par;

    public Hole(int holeNumber, int distance, int par) {
        this.holeNumber = holeNumber;
        this.distance = distance;
        this.par = par;
    }

    @Override
    public String toString() {
        return "Hole " + holeNumber + ": Distance = " + distance + " meters, Par = " + par;
    }

    
}
