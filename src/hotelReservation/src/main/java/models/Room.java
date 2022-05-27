package hotelReservation.src.main.java.models;

public class Room {

    private int id;
    private boolean reserve;

    public Room(int id) {
        this.id = id;
        this.reserve=false;
    }

    public int getId() {
        return id;
    }

    public boolean isReserve() {
        return reserve;
    }

    public int  setReserve(boolean reserve) {
        this.reserve = reserve;
        return this.id;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", reserve=" + reserve +
                '}';
    }
}
