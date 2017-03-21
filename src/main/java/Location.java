public class Location {

    private String name;

    private Location closerLocation = null;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Location getCloserLocation() {
        return closerLocation;
    }

    public void setCloserLocation(Location closerLocation) {
        this.closerLocation = closerLocation;
    }

    @Override
    public String toString() {
        return "Town{" +
                "name='" + name + '\'' +
                '}';
    }
}


