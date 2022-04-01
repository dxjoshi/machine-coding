package hotelreservation.src.main.java.services;

import java.util.List;

public interface HotelService {

    List<Integer> checkin(int count);

    void checkout(int roomId);
}
