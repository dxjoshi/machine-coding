package lruCache;

import controllers.InputProcessorImpl;
import controllers.StdOutPrinter;
import services.InputProcessor;

public class Runner {
    public static void main(String[] args) {
        InputProcessor inputProcessor = new InputProcessorImpl(new StdOutPrinter());
        inputProcessor.begin();
    }
}
