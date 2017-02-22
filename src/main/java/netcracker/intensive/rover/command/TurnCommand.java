package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;

public class TurnCommand implements RoverCommand {
    Rover rover = null;
    Direction dicrection = null;
    TurnCommand() {

    }

    TurnCommand(Rover rover, Direction direction) {
        this.rover = rover;
        this.dicrection = direction;
    }

    public void execute() {

    }
}
