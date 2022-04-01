package lruCache.controllers;

import services.Printer;

public class StdOutPrinter implements Printer {
    @Override
    public void print(String output) {
        System.out.println(output);
    }
}
