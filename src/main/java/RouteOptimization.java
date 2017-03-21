import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RouteOptimization {

    private List<Location> locations;

    public RouteOptimization(Location... locations){
        this.locations = Arrays.asList(locations);
    }

    public List<Location> getLocations() {
        return locations;
    }

    public boolean isFurthestLocation(Location location){
        return (!this.locations.stream().map(Location::getCloserLocation).collect(Collectors.toList()).contains(location));
    }
}
