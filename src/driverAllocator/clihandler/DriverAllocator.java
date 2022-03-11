package driverAllocator.clihandler;

import driverAllocator.entity.Driver;
import driverAllocator.entity.Trip;
import driverAllocator.exceptions.DriverNotAvaialbleException;
import driverAllocator.service.IdGenerator;
import driverAllocator.utils.Constants;

import java.util.*;

import static driverAllocator.utils.Constants.DRIVER_REGISTERED_MSG;

public class DriverAllocator {
    private Map<String, Driver> allocatedDrivers;
    Map<String, Driver> availableDrivers;

    public DriverAllocator() {
        this.allocatedDrivers = new HashMap<>();
        this.availableDrivers = new HashMap<>();
    }

    public void initialize(int numDrivers) {
        for (int i = 0; i < numDrivers; i++) {
            Driver driver = new Driver(i);
            availableDrivers.put(driver.getName(), new Driver(i));
        }
    }

    public void registerDriver(String driverId) {
        if (!availableDrivers.containsKey(driverId)) {
            availableDrivers.put(driverId, new Driver(driverId));
        }
        Driver driver = availableDrivers.get(driverId);
        driver.setRegistered(true);
        System.out.println(String.format(DRIVER_REGISTERED_MSG, driver.getName()));
    }

    public void book(int distance) {
        Optional<Driver> optionalDriver = availableDrivers.entrySet()
                .stream()
                .filter(entry -> entry.getValue().isRegistered())
                .map(entry -> entry.getValue())
                .findAny();

        if (!optionalDriver.isPresent()) {
            System.out.println("No driver available!");
            return;
        }
        Driver driver = optionalDriver.get();
        driver.attachTrip(new Trip(distance));
        String id = IdGenerator.getId();
        allocatedDrivers.put(id, driver);
        availableDrivers.remove(driver.getName());
        System.out.println(String.format(Constants.DRIVER_BOOKED_MSG, driver.getName(), id, distance));
    }


    public void completeBooking(String bookingId)   {
        if (!allocatedDrivers.containsKey(bookingId)) {
            System.out.println(Constants.INVALID_BOOKING_MSG);
            return;
        }
        Driver driver = allocatedDrivers.get(bookingId);

        updateDriverIncentives(driver);
        allocatedDrivers.remove(bookingId);
        availableDrivers.put(driver.getName(), driver);

        System.out.println(String.format(Constants.BOOKING_COMPLETE_MSG, driver.getName()));
    }

    private void updateDriverIncentives(Driver driver) {
        Trip trip = driver.getTrip();
        driver.updateTripCount(1);
        driver.updateDistance(trip.getDistance());
        driver.attachTrip(null);
    }
}
