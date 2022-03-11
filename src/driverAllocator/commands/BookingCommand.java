package driverAllocator.commands;

import driverAllocator.clihandler.DriverAllocationCommandHandler;

public class BookingCommand implements ICommand {

    DriverAllocationCommandHandler commandHandler;

    public BookingCommand(DriverAllocationCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public void process(String... args) {
        commandHandler.completeBooking(args[1]);
    }
}
