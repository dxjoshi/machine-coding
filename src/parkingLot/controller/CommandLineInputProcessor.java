package parkingLot.controller;

import parkingLot.models.ParkingFloor;
import parkingLot.models.ParkingLot;
import parkingLot.models.TicketGeneratorStrategy;
import parkingLot.models.Vehicle;
import parkingLot.services.InputProcessor;
import parkingLot.services.Printer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CommandLineInputProcessor implements InputProcessor {

    private final Printer printer;
    private ParkingLot parkingLot;

    public CommandLineInputProcessor(Printer printer) {
        this.printer = printer;
    }

    @Override
    public String create_parking_lot(String parkingLotId, int floors, int slotsPerFloor) {
        parkingLot = new ParkingLot(parkingLotId, floors, slotsPerFloor, new TicketGeneratorStrategy());
        return String.format("Created parking lot with %d floors and %d slots per floor", parkingLot.getFloors(), parkingLot.getPerFloorSlots());
    }

    @Override
    public String park_vehicle(String vehicleType, String registrationNumber, String color) {
        String ticketId = parkingLot.park(vehicleType, registrationNumber, color);
        return ticketId != null ? String.format("Parked vehicle. Ticket ID: %s", ticketId) : "Parking Lot Full";
    }

    @Override
    public String unpark_vehicle(String ticketId) {
        Vehicle vehicle = parkingLot.unpark(ticketId);
        return vehicle != null ? String.format("Unparked vehicle with Registration Number: %s and Color: %s", vehicle.getRegistrationId(), vehicle.getColor()) : "Invalid Ticket";
    }

    @Override
    public String display(String displayType, String vehicleType) {
        List<String> responses = new ArrayList<>();
        if ("free_count".equals(displayType)) {
            for (ParkingFloor floor : parkingLot.getParkingFloors()) {
                long result = floor.getFreeSlotCount(vehicleType);
                responses.add(String.format("No. of free slots for %s on Floor %s: %s", vehicleType, floor.getId(), result));
            }
        } else if ("free_slots".equals(displayType)) {
            for (ParkingFloor floor : parkingLot.getParkingFloors()) {
                String result = floor.getFreeSlotIds(vehicleType);
                responses.add(String.format("No. of free slots for %s on Floor %s: %s", vehicleType, floor.getId(), result));
            }
        } else if ("occupied_slots".equals(displayType)) {
            for (ParkingFloor floor : parkingLot.getParkingFloors()) {
                String result = floor.getOccupiedSlotIds(vehicleType);
                responses.add(String.format("No. of free slots for %s on Floor %s: %s", vehicleType, floor.getId(), result));
            }
        }
        return responses.stream().collect(Collectors.joining("\n"));
    }

    public void begin() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0] == "exit") {
                break;
            }
            String result = process(input);
            printer.print(result);
        }
    }

    private String process(String[] input) {
        String result = null;
        switch (input[0]) {
            case "create_parking_lot":
                result = create_parking_lot(input[1], Integer.valueOf(input[2]), Integer.valueOf(input[3]));
                break;
            case "park_vehicle":
                result = park_vehicle(input[1], input[2], input[2]);
                break;
            case "unpark_vehicle":
                result = unpark_vehicle(input[1]);
                break;
            case "display":
                result = display(input[1], input[2]);
                break;
        }
        return result;
    }
}
