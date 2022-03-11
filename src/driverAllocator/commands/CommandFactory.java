package driverAllocator.commands;

import driverAllocator.clihandler.DriverAllocationCommandHandler;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    static Map<String, ICommand> map;

    public CommandFactory() {
        map = new HashMap<>();
    }

    public static void init(DriverAllocationCommandHandler driverAllocationCommandHandler) {
        map = new HashMap<>();
        map.put("register_driver", new RegisterCommand(driverAllocationCommandHandler));
        map.put("complete_booking", new BookingCommand(driverAllocationCommandHandler));
        map.put("dispatch_driver_for_a_booking", new DispatchDriverCommand(driverAllocationCommandHandler));

    }

    public static void process(String[] split) {
        String command = split[0];
        if  (!map.containsKey(command) || split.length < 2)  {
            System.out.println("Invalid Command!!");
        }
        map.get(command).process(split);
    }
}
