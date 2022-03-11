package driverAllocator;

import driverAllocator.clihandler.DriverAllocationCommandHandler;
import driverAllocator.commands.CommandFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        DriverAllocationCommandHandler commandHandler = new DriverAllocationCommandHandler();
        CommandFactory.init(commandHandler);

        while(true) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String input = reader.readLine();
                String[] split = input.split(" ");
                CommandFactory.process(split);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*
        Driver - count, dist
                DriverAllocator - Map<> availableDriversMap
                CLIF

        register_driver <<driver_id>>
                $ dispatch_driver_for_a_booking <<booking distance>>
                $ complete_booking <<booking-id>>

        $ register_driver driver-001
        Driver driver-001 registered
        $ register_driver driver-002
        Driver driver-002 registered
        $ dispatch_driver_for_a_booking 4
        Driver driver-001 is assigned to booking booking-1 with 4 km distance
        $ dispatch_driver_for_a_booking 15
        Driver driver-002 is assigned to booking booking-2 with 15 km
                distance
        $ dispatch_driver_for_a_booking 1
        Sorry, driver is not available
        $ complete_booking booking-1
        Driver driver-001 is released to allocation pool
        $ dispatch_driver_for_a_booking 1
        Driver driver-001 is assigned to booking booking-3 with 1 km distance
        $ complete_booking booking-3
Driver driver-001 is released to allocation pool
$ dispatch_driver_for_a_booking 1
Driver driver-001 is assigned to booking booking-4 with 1 km distance
$ complete_booking booking-4
Driver driver-001 is released to allocation pool
*/
    }

    public static void process1(String[] args, DriverAllocationCommandHandler commandHandler) {
        if (args[1] != null || args[1] == "") {
            System.out.println("Invalid argument");
            return;
        }

    }
}
