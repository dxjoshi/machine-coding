package parkingLot.services;

public interface InputProcessor {
 public void begin();
 public String create_parking_lot(String parkingLotId, int floors, int slotsPerFloor);
 public String park_vehicle(String vehicleType, String registrationNumber, String color);
 public String unpark_vehicle(String ticketId);
 public String display(String displayType, String vehicleType); //values of display_type: free_count, free_slots, occupied_slots
}
