package hotelReservation.src.main.java.exceptions;

public class InvalidHotelRoomException extends RuntimeException {

    public InvalidHotelRoomException(String errorMessage) {
        super(errorMessage);
    }
}
