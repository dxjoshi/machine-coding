package parkingLot.models;

import parkingLot.services.TicketGenerator;

import java.util.List;

public class TicketGeneratorStrategy implements TicketGenerator {

    @Override
    public String generateTicket(String parkingLotId, int floorId, int slotId) {
        //<parking_lot_id>_<floor_no>_<slot_no>
        return parkingLotId + "_" +  floorId + "_" + slotId;
    }
}
