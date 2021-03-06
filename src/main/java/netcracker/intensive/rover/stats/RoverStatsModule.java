package netcracker.intensive.rover.stats;

import netcracker.intensive.rover.Point;

import java.util.Collection;
import java.util.HashSet;

public interface RoverStatsModule {

    void registerPosition(Point position);

    boolean isVisited(Point point);

    Collection<Point> getVisitedPoints();
}
