import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RouteOptimization {

    private List<Location> locations;

    private List<Location> optimalRoute = new ArrayList<>();


    public RouteOptimization(Location... locations)  {
        if (locations == null) throw new NullPointerException("Null is not a valid Location");
        this.locations = Arrays.asList(locations);
        fromFurthestToClosest();

    }


    public boolean isFurthestLocation(Location location){
        return (!this.locations.stream().map(Location::getCloserLocation).collect(Collectors.toList()).contains(location));
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Location> getOptimalRoute() {
        return optimalRoute;
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
