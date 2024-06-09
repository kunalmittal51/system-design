package elevator.controller;

import elevator.entity.Elevator;
import elevator.enums.Direction;

import java.util.List;
import java.util.PriorityQueue;

public class ElevatorController {
    Elevator elevator;
    PriorityQueue<Integer> upQueue;
    PriorityQueue<Integer> downQueue;
    List<Integer> pendingTasks;

    public void submitRequest(int floorNumber, Direction direction) {
        if (Direction.UP.equals(direction)) {
            if (elevator.getDirection().equals(direction)) {
                if (floorNumber > elevator.getCurrentFloor()) {
                    upQueue.offer(floorNumber);
                } else {
                    pendingTasks.add(floorNumber);
                }
            } else {
                downQueue.offer(floorNumber);
            }
        } else {
            if (elevator.getDirection().equals(direction)) {
                if (floorNumber < elevator.getCurrentFloor()) {
                    downQueue.offer(floorNumber);
                } else {
                    pendingTasks.add(floorNumber);
                }
            } else {
                upQueue.offer(floorNumber);
            }
        }
    }

    public void processRequest() {
        if (elevator.getDirection().equals(Direction.UP)) {
            while (!upQueue.isEmpty()) {
                elevator.move(upQueue.poll(), Direction.UP);
            }
            elevator.setDirection(Direction.DOWN);
            while (pendingTasks.isEmpty()) {
                upQueue.offer(pendingTasks.get(0));
                pendingTasks.remove(0);
            }
        } else {
            while (!downQueue.isEmpty()) {
                elevator.move(downQueue.poll(), Direction.UP);
            }
            elevator.setDirection(Direction.UP);
            while (pendingTasks.isEmpty()) {
                downQueue.offer(pendingTasks.get(0));
                pendingTasks.remove(0);
            }
        }
    }
}
