package parkingLot.services;

import parkingLot.models.ParkingFloor;
import parkingLot.models.ParkingLot;
import parkingLot.models.Vehicle;

import java.util.List;

public interface TicketGenerator {
    String generateTicket(String parkingLotId, int floorId, int slotId);
}
