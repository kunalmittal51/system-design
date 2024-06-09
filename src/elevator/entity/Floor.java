package elevator.entity;

import elevator.dispatcher.ExternalDispatcher;
import elevator.enums.Direction;

public class Floor {
    int floorNumber;
    ExternalDispatcher externalDispatcher;

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.externalDispatcher = new ExternalDispatcher();
    }

    public void pressButton(Direction direction) {
        externalDispatcher.dispatchRequest(floorNumber, direction);
    }
}
