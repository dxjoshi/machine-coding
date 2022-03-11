package driverAllocator.service;

public class IdGenerator {
    static int id;

    public static String getId() {
        String bookingId = String.format("Booking-%d", id);
        id++;
        return bookingId;
    }
}
