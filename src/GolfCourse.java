import java.util.*;

public class GolfCourse {
    private String name;
    private String location;
    private int holes;
    private double coursePrice;
    private double drivingRangePrice;
    private int drivingRangeBays;
    private List<Hole> holeList;
    private List<String> facilities;

    public GolfCourse(String name, String location, int holes, double coursePrice, double drivingRangePrice, int drivingRangeBays) {
        this.name = name;
        this.location = location;
        this.holes = holes;
        this.coursePrice = coursePrice;
        this.drivingRangePrice = drivingRangePrice;
        this.drivingRangeBays = drivingRangeBays;
        this.holeList = new ArrayList<>();
        this.facilities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getHoles() {
        return holes;
    }

    public double getCoursePrice() {
        return coursePrice;
    }

    public double getDrivingRangePrice() {
        return drivingRangePrice;
    }

    public int getDrivingRangeBays() {
        return drivingRangeBays;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void addHole(int number, int distance, int par) {
        holeList.add(new Hole(number, distance, par));
    }

    public void addFacility(String facility) {
        facilities.add(facility);
    }

    public void displayHoles() {
        for (Hole hole : holeList) {
            System.out.println("Hole " + hole.getNumber() + " - " + hole.getDistance() + "m (Par " + hole.getPar() + ")");
        }
    }

    private class Hole {
        private int number;
        private int distance;
        private int par;

        public Hole(int number, int distance, int par) {
            this.number = number;
            this.distance = distance;
            this.par = par;
        }

        public int getNumber() {
            return number;
        }

        public int getDistance() {
            return distance;
        }

        public int getPar() {
            return par;
        }
    }
}
