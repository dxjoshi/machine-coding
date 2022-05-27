package hotelReservation.src.main.java.exceptions;

public class HotelSpaceFullException extends RuntimeException {

    public HotelSpaceFullException(String errorMessage) {
        super(errorMessage);
    }
}
