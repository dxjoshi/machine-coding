package driverAllocator.commands;

import driverAllocator.clihandler.DriverAllocationCommandHandler;

public class DispatchDriverCommand implements ICommand{

    DriverAllocationCommandHandler commandHandler;

    public DispatchDriverCommand(DriverAllocationCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public void process(String... args) {
        commandHandler.dispatchDriver(Integer.parseInt(args[1]));

    }
}
