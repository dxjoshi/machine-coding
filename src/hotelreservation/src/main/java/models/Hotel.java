package hotelreservation.src.main.java.models;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private List<HotelFloor> floors;
    private BookingOrder bookingOrder;
    private String name;
    private int numFloors;
    private int roomsPerFloor;

    public Hotel(BookingOrder bookingOrder, String name, int numFloors, int roomsPerFloor) {
        this.bookingOrder = bookingOrder;
        this.name = name;
        this.numFloors = numFloors;
        this.roomsPerFloor = roomsPerFloor;
        this.floors = new ArrayList<>();

        for (int i = 1; i <= numFloors; i++) {
            this.floors.add(new HotelFloor(i, roomsPerFloor));
        }
    }

    public List<HotelFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<HotelFloor> floors) {
        this.floors = floors;
    }

    public BookingOrder getBookingOrder() {
        return bookingOrder;
    }

    public void setBookingOrder(BookingOrder bookingOrder) {
        this.bookingOrder = bookingOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    public int getRoomsPerFloor() {
        return roomsPerFloor;
    }

    public void setRoomsPerFloor(int roomsPerFloor) {
        this.roomsPerFloor = roomsPerFloor;
    }


}
