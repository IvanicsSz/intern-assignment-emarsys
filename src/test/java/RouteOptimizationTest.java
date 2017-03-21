import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class RouteOptimizationTest {

    private RouteOptimization routeOptimization;

    private Location u;
    private Location v;
    private Location w;
    private Location x;
    private Location y;
    private Location z;

    @Before
    public void setUp() throws Exception {
        u = new Location("u");
        v = new Location("v");
        w = new Location("w");
        x = new Location("x");
        y = new Location("y");
        z = new Location("z");

        routeOptimization = new RouteOptimization();
    }

    @Test
    public void testRouteOptimizationWithEmptyParameter() throws Exception {

        assertNotNull(routeOptimization.getLocations());
    }

    @Test
    public void testRouteOptimizationWithParameters() throws Exception {
        routeOptimization = new RouteOptimization(u);

        assertEquals(routeOptimization.getLocations().get(0), u);
        assertEquals(routeOptimization.getLocations().size(), 1);
    }

    @Test
    public void testIsFurthestLocation() throws Exception {
        x.setCloserLocation(u);
        routeOptimization = new RouteOptimization(u, x);

        assertTrue(routeOptimization.isFurthestLocation(x));
        assertFalse(routeOptimization.isFurthestLocation(u));
    }

    @Test
    public void testGetOptimalRouteForTwoLocations() throws Exception {
        x.setCloserLocation(u);
        routeOptimization = new RouteOptimization(u, x);
        List<Location> optimal = Arrays.asList(u, x);

        assertEquals(routeOptimization.getOptimalRoute(), optimal);
    }

    @Test
    public void testGetOptimalRouteForMoreLocations() throws Exception {
        v.setCloserLocation(w);
        w.setCloserLocation(z);
        x.setCloserLocation(u);
        y.setCloserLocation(v);
        routeOptimization = new RouteOptimization(u, v, w, x, y, z);
        List<Location> optimal = Arrays.asList(z, w, v, y, u, x);

        assertEquals(routeOptimization.getOptimalRoute(), optimal);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointerExceptionInParameters() throws Exception {
        routeOptimization = new RouteOptimization(null);
    }

    @After
    public void tearDown() throws Exception {
        u = null;
        v = null;
        w = null;
        x = null;
        y = null;
        z = null;
        routeOptimization = null;
    }

}