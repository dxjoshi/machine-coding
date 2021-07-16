package parkingLot.models;

import parkingLot.services.TicketGenerator;

import java.util.*;

public class ParkingLot {

    private final String id;
    private final int floors;
    private final int perFloorSlots; //(1 truck, 2 bikes, remaining cars)
    private final List<ParkingFloor> parkingFloors;
    private final TicketGenerator ticketGenerator;
    private final Map<String, Slot> parkedVehicleDetails;

    public ParkingLot(String id, int floors, int perFloorSlots, TicketGenerator ticketGenerator) {
        this.id = id;
        this.floors = floors;
        this.perFloorSlots = perFloorSlots;
        this.parkingFloors = new ArrayList<>(floors);
        this.parkedVehicleDetails = new HashMap<>();
        for (int i = 0; i < floors; i++) {
            this.parkingFloors.add(new ParkingFloor(i+1, perFloorSlots));
        }
        this.ticketGenerator = ticketGenerator;
    }

    public String getId() {
        return id;
    }

    public int getFloors() {
        return floors;
    }

    public int getPerFloorSlots() {
        return perFloorSlots;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public String park(String vehicleType, String registrationNumber, String color) {
        String ticketId = null;
        for (ParkingFloor floor : parkingFloors) {
            Optional<Slot> freeSlot = floor.getFreeSlot(vehicleType);
            if (freeSlot.isPresent()) {
                Slot slot = freeSlot.get();
                slot.setVehicle(new Vehicle(Vehicle.Type.getType(vehicleType), registrationNumber, color));
                ticketId = ticketGenerator.generateTicket(id, slot.getFloorId(), slot.getSlotId());
                parkedVehicleDetails.put(ticketId, slot);
                break;
            }
        }
        return ticketId;
    }

    public Vehicle unpark(String ticketId) {
        Slot parkedAt = parkedVehicleDetails.get(ticketId);
        Vehicle vehicle = null;
        if (parkedAt != null) {
            vehicle = parkedAt.getVehicle();
            parkedAt.setVehicle(null);
            parkedVehicleDetails.put(ticketId, null);
        }
        return vehicle;
    }
}
