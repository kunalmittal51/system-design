package elevator.dispatcher;

import elevator.controller.ElevatorController;
import elevator.enums.Direction;

import java.util.List;

public class ExternalDispatcher {
    List<ElevatorController> elevatorControllerList;

    public void dispatchRequest(int floorNumber, Direction direction) {
        ElevatorController elevatorController = getElevatorController(floorNumber, direction);
        elevatorController.submitRequest(floorNumber, direction);
    }

    // algo to find the best elevator
    public ElevatorController getElevatorController(int floorNumber, Direction direction ){
        List<ElevatorController> elevatorControllerList1 = elevatorControllerList;
        return elevatorControllerList.get(0);
    }
}
