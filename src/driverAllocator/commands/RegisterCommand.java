package driverAllocator.commands;

import driverAllocator.clihandler.DriverAllocationCommandHandler;

public class RegisterCommand implements ICommand {

    DriverAllocationCommandHandler commandHandler;

    public RegisterCommand(DriverAllocationCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @Override
    public void process(String... args) {
        commandHandler.register(args[1]);
    }
}
