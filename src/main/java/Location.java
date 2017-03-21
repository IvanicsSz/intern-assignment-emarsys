public class Location {

    private String name;

    private Location closerLocation = null;

    public Location(String name) {
        if (name == null) throw new NullPointerException("Null is not a valid location name");
        this.name = name;
    }

    public Location getCloserLocation() {
        return closerLocation;
    }

    public void setCloserLocation(Location closerLocation) {
        this.closerLocation = closerLocation;
    }

    @Override
    public String toString() {
        return "Town{ name = " + name + " }";
    }
}


