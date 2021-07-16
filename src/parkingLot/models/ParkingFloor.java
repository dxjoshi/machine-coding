package parkingLot.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingFloor {
    private final int id;
    private final int totalSlots;
    private final List<Slot> slots;


    public ParkingFloor(int id, int totalSlots) {
        this.id = id;
        this.totalSlots = totalSlots;
        this.slots = new ArrayList<>();
        createSlots();
    }

    private void createSlots() {
        for (int i = 1; i <= totalSlots; i++) {
            Vehicle.Type type = Vehicle.Type.CAR;
            if (i == 1) {
                type = Vehicle.Type.TRUCK;
            } else if (i < 4) {
                type = Vehicle.Type.BIKE;
            }
            slots.add(new Slot(id, i, type));
        }
    }

    public int getId() {
        return id;
    }

    public String getFreeSlotIds(String vehicleType) {
        return slots
                .stream()
                .filter(slot -> slot.getSlotType().name().equals(vehicleType) && slot.isEmpty())
                .map(slot -> String.valueOf(slot.getSlotId()))
                .collect(Collectors.joining(","));
    }

    public String getOccupiedSlotIds(String vehicleType) {
        return slots
                .stream()
                .filter(slot -> slot.getSlotType().name().equals(vehicleType) && !slot.isEmpty())
                .map(slot -> String.valueOf(slot.getSlotId()))
                .collect(Collectors.joining(","));
    }

    public Optional<Slot> getFreeSlot(String vehicleType) {
        return slots
                .stream()
                .filter(slot -> slot.getSlotType().name().equals(vehicleType) && slot.isEmpty())
                .findFirst();
    }

    public long getFreeSlotCount(String vehicleType) {
        return slots
                .stream()
                .filter(slot -> slot.getSlotType().name().equals(vehicleType) && slot.isEmpty())
                .count();
    }

    public List<Slot> getSlots() {
        return slots;
    }

}
