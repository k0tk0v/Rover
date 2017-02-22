package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;
import netcracker.intensive.rover.constants.Direction;

public class Rover implements Moveable, Turnable, Liftable, Landable {

    private Point coordinates = null;
    private Direction direction = null;
    private GroundVisor visor = null;
    private boolean liftable = false;

    public Rover() {

    }

    public Rover(GroundVisor visor) {
        coordinates = new Point(0, 0);
        direction = Direction.SOUTH;
        this.visor = visor;
    }

    /**
     * Двигаемся в нужном направлении
     */
    public void move() {
        switch (direction) {
            case NORTH:
                coordinates.setPoint(coordinates.getX(), coordinates.getY() - 1);
                break;
            case EAST:
                coordinates.setPoint(coordinates.getX() + 1, coordinates.getY());
                break;
            case WEST:
                coordinates.setPoint(coordinates.getX() - 1, coordinates.getY());
                break;
            case SOUTH:
                coordinates.setPoint(coordinates.getX(), coordinates.getY() + 1);
                break;
        }
        try {
            visor.hasObstacles(coordinates);
        } catch (OutOfGroundException e) {
            System.out.println(e);
            lift();
        }
    }

    /**
     * Повернуть в любую сторону
     *
     * @param direction
     */
    public void turnTo(Direction direction) {
        this.direction = direction;
    }

    /**
     * Взлететь
     */
    public void lift() {
        if (!liftable) {
            liftable = true;
        //    direction = null;
        //    coordinates = null;
        }
    }

    /**
     * Опуститься на заданную клетку, если она свободна
     *
     * @param position
     * @param direction
     */
    public void land(Point position, Direction direction)
    {
        try {
            if( position.getX() > visor.ground.getiSize() || position.getY() > visor.ground.getjSize()
                    || position.getX() < 0 || position.getY() < 0 ||
                    visor.ground.getCell(position.getX(),position.getY()).getState() == CellState.OCCUPIED)
            {
                liftable = true;
            }
            else
            {
                liftable = false;
            }
        }
        catch (OutOfGroundException e) {}

    }
    /**
     * Возвращает координаты ровера(в данный момент)
     *
     * @return object Point
     */
    public Point getCurrentPosition() {
        return coordinates;
    }

    /**
     * Летит ли наш ровер или нет
     *
     * @return false/true
     */
    public boolean isAirborne() {
        return liftable;
    }

    /**
     * Возвращает направление ровера
     *
     * @return enum Direction
     */
    public Direction getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        String message = null;
        switch (direction) {
            case EAST:
                message = "Heading EAST";
                break;
            case NORTH:
                message = "Heading NORTH";
                break;
            case WEST:
                message = "Heading WEST";
                break;
            case SOUTH:
                message = "Heading SOUTH";
                break;
            default:
                message = "";
                break;
        }
        return message;
    }
}
