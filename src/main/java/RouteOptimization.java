import java.util.*;
import java.util.stream.Collectors;

public class RouteOptimization {

    private List<Location> locations;

    private List<Location> optimalRoute = new ArrayList<>();

    public RouteOptimization(Location... locations){
        this.locations = Arrays.asList(locations);
        fromFurthestToClosest();
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Location> getOptimalRoute() {
        return optimalRoute;
    }

    public boolean isFurthestLocation(Location location){
        return (!this.locations.stream().map(Location::getCloserLocation).collect(Collectors.toList()).contains(location));
    }

    private void fromFurthestToClosest(){
        for (Location location : locations) {
            if (isFurthestLocation(location)) {
                closerTown(location);
            }
        }
        Collections.reverse(optimalRoute);
    }

    private void closerTown(Location location) {
        optimalRoute.add(location);
        if (location.getCloserLocation() != null) {
            closerTown(location.getCloserLocation());
        }
    }

}
