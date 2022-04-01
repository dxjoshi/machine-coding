package hotelreservation.src.main.java.models;

import java.util.ArrayList;
import java.util.List;

public class HotelFloor {

    private int id;
    private int totalRooms;
    private List<Room> rooms;

    public HotelFloor(int id, int totalRooms) {
        this.id = id;
        this.totalRooms = totalRooms;
        this.rooms = new ArrayList<>();
        createRooms();
    }

    private void createRooms() {
        for (int i = 1; i <= totalRooms; i++) {
            rooms.add(new Room(id*100+i));
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(int totalRooms) {
        this.totalRooms = totalRooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
