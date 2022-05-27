package hotelReservation.src.main.java;


import hotelReservation.src.main.java.models.BookingOrder;
import hotelReservation.src.main.java.models.Hotel;
import hotelReservation.src.main.java.services.HotelService;
import hotelReservation.src.main.java.services.HotelServiceImpl;

public class HotelMain {

    public static void main(String[] args) {

        Hotel hotel = new Hotel(BookingOrder.LOWER, "Treebo", 5,3);
        HotelService service = new HotelServiceImpl(hotel);
        System.out.println(service.checkin(5));
        System.out.println(service.checkin(5));
        service.checkout(501);

    }

}
