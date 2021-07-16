package parkingLot.models;

import java.util.Objects;

public class Slot {
    private final int floorId;
    private final int slotId;
    private final Vehicle.Type slotType;
    private Vehicle vehicle;

    public Slot(int floorId, int slotId, Vehicle.Type slotType) {
        this.floorId = floorId;
        this.slotId = slotId;
        this.slotType = slotType;
    }

    public int getFloorId() {
        return floorId;
    }

    public int getSlotId() {
        return slotId;
    }

    public Vehicle.Type getSlotType() {
        return slotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isEmpty() {
        return vehicle != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return floorId == slot.floorId &&
                slotId == slot.slotId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorId, slotId);
    }
}
