package parkingLot.controller;

import parkingLot.services.Printer;

public class StdOutPrinter implements Printer {
    @Override
    public void print(String output) {
        System.out.println(output);
    }
}
