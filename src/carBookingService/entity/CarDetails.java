package carBookingService.entity;

import java.util.ArrayList;
import java.util.List;

public class CarDetails {
    private List<Car> carList;
    private Integer price;

    public CarDetails() {
        this.carList = new ArrayList<>();
    }

    public Integer getPrice() {
        return price;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
