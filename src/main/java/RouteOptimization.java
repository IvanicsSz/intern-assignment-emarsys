import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RouteOptimization {

    private List<Location> locations;

    private List<Location> optimalRoute = new ArrayList<>();


    public RouteOptimization(Location... locations) {
        if (locations == null) throw new NullPointerException("Null is not a valid Location");
        this.locations = Arrays.asList(locations);
        fromFurthestToClosest();
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Location> getOptimalRoute() {
        return optimalRoute;
    }

    public boolean isFurthestLocation(Location location) {
        return (!locations.stream().map(Location::getCloserLocation).collect(Collectors.toList()).contains(location));
    }

    private void fromFurthestToClosest() {
        locations.stream().filter(this::isFurthestLocation).forEach(this::closerTown);
        Collections.reverse(optimalRoute);
    }

    private void closerTown(Location location) {
        optimalRoute.add(location);
        if (location.getCloserLocation() != null) {
            closerTown(location.getCloserLocation());
        }
    }


}
