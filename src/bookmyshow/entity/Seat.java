package bookmyshow.entity;

import bookmyshow.enums.SeatCategory;

public class Seat {
    int id;
    int rowNumber;
    SeatCategory seatCategory;

    public Seat(int id, int rowNumber, SeatCategory seatCategory) {
        this.id = id;
        this.rowNumber = rowNumber;
        this.seatCategory = seatCategory;
    }
}
