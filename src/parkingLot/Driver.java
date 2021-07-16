package parkingLot;

import parkingLot.controller.CommandLineInputProcessor;
import parkingLot.controller.StdOutPrinter;
import parkingLot.services.InputProcessor;

public class Driver {
    public static void main(String[] args) {
        InputProcessor cli = new CommandLineInputProcessor(new StdOutPrinter());
        cli.begin();
    }
}
