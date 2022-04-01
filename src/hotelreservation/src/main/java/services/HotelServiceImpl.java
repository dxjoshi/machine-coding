package hotelreservation.src.main.java.services;

import hotelreservation.src.main.java.exceptions.HotelSpaceFullException;
import hotelreservation.src.main.java.exceptions.InvalidHotelRoomException;
import models.BookingOrder;
import models.Hotel;
import models.HotelFloor;
import models.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HotelServiceImpl implements HotelService {

    private final Hotel hotel;

    public HotelServiceImpl(Hotel hotel) {
        this.hotel = hotel;
    }

    Map<Integer, Room> map = new HashMap<>();


    @Override
    public List<Integer> checkin(int count) {

        List<Integer> bookedRooms = new ArrayList<>();
        List<HotelFloor> floors = hotel.getFloors();

        if (hotel.getBookingOrder() == BookingOrder.HIGHER) {
            for (int j = floors.size() - 1; j >= 0; j--) {
                bookRooms(floors.get(j), bookedRooms, count);

                if (bookedRooms.size() == count)
                {
                    System.out.println(map);
                    return bookedRooms;
                }

            }
        } else {

            for (int j = 0; j < floors.size(); j++) {
                bookRooms(floors.get(j), bookedRooms, count);
                if (bookedRooms.size() == count)
                    return bookedRooms;
            }

        }

        throw new HotelSpaceFullException("Hotel space is full");
    }


    private void bookRooms(HotelFloor hotelFloor, List<Integer> bookedRooms, int count) {
        List<Room> availableRooms = hotelFloor.getRooms().stream().filter(room -> !room.isReserve()).collect(Collectors.toList());
        for (int i = 0; i < availableRooms.size(); i++) {
            Room curr = availableRooms.get(i);
            int roomId = curr.setReserve(true);
            bookedRooms.add(roomId);
            map.put(roomId, curr);

            if (bookedRooms.size() == count) {
                return;
            }
        }

    }

    @Override
    public void checkout(int roomId) {

        if (!map.containsKey(roomId)) {
            throw new InvalidHotelRoomException("RoomId is invalid");
        }

        System.out.println(map);
        Room room = map.get(roomId);
        room.setReserve(false);
        map.remove(roomId);
        System.out.println(map);
        System.out.println("Room has been successfully checkedout.");
    }
}
