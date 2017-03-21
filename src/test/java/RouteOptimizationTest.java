import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
    public void testIsFurthestLocation() throws Exception{
        routeOptimization = new RouteOptimization(u, x);
        x.setCloserLocation(u);

        assertTrue(routeOptimization.isFurthestLocation(x));
        assertFalse(routeOptimization.isFurthestLocation(u));
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