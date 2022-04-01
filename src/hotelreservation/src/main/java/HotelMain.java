package hotelreservation.src.main.java;

import models.BookingOrder;
import models.Hotel;
import services.HotelService;
import services.HotelServiceImpl;

public class HotelMain {

    public static void main(String[] args) {

        Hotel hotel = new Hotel(BookingOrder.LOWER, "Treebo", 5,3);
        HotelService service = new HotelServiceImpl(hotel);
        System.out.println(service.checkin(5));
        System.out.println(service.checkin(5));
        service.checkout(501);

    }

}
