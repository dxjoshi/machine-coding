package lruCache;


import lruCache.controllers.InputProcessorImpl;
import lruCache.controllers.StdOutPrinter;
import lruCache.services.InputProcessor;

public class Runner {
    public static void main(String[] args) {
        InputProcessor inputProcessor = new InputProcessorImpl(new StdOutPrinter());
        inputProcessor.begin();
    }
}
