package driverAllocator.clihandler;

public class DriverAllocationCommandHandler {

    private DriverAllocator driverAllocator;

    public void register(String numDrivers) {
        driverAllocator = new DriverAllocator();
        driverAllocator.initialize(10);
        driverAllocator.registerDriver(numDrivers);

    }

    public void dispatchDriver(int distance) {
        driverAllocator.book(distance);

    }

    public void completeBooking(String bookingId) {
        driverAllocator.completeBooking(bookingId);

    }



}
