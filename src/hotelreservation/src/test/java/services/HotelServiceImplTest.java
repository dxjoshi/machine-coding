package hotelreservation.src.test.java.services;

import exceptions.HotelSpaceFullException;
import exceptions.InvalidHotelRoomException;
import hotelreservation.src.main.java.services.HotelServiceImpl;
import models.BookingOrder;
import models.Hotel;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class HotelServiceImplTest {

    private Hotel hotel =  new Hotel(BookingOrder.HIGHER, "Treebo", 5,3);
    private HotelService service = new HotelServiceImpl(hotel);

    @Test
    public void checkin() {

        List<Integer> actual = service.checkin(5);
        List<Integer> expected = Arrays.asList(501,502,503,401,402);
        assertTrue(actual.size() == expected.size() && actual.containsAll(expected) && expected.containsAll(actual));
    }

    @Test
    public void validCheckout() {
        service.checkin(5);
        service.checkout(501);
    }

    @Test(expected = InvalidHotelRoomException.class)
    public void checkout() {
        service.checkout(501);
    }


    @Test(expected = HotelSpaceFullException.class)
    public void invalidCheckin() {

        hotel =  new Hotel(BookingOrder.HIGHER, "Treebo", 1,1);
        service= new HotelServiceImpl(hotel);
        service.checkin(5);
    }
}
