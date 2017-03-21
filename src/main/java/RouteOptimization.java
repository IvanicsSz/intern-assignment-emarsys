import java.util.Arrays;
import java.util.List;

public class RouteOptimization {

    private List<Location> locations;

    public RouteOptimization(Location... locations){
        this.locations = Arrays.asList(locations);
    }

    public List<Location> getLocations() {
        return locations;
    }
}
