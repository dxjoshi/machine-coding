package lruCache.controllers;

import services.Cache;
import services.InputProcessor;
import services.Printer;

import java.util.Scanner;

public class InputProcessorImpl implements InputProcessor {

    private final Printer printer;
    private Cache cache;

    public InputProcessorImpl(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void begin() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0] == "exit") {
                break;
            }
            String result = process(input);
            if (result != null) printer.print(result);
        }
    }

    private String process(String[] input) {
        String res= null;
        switch (input[0]) {
            case "Cache":
                create(Integer.valueOf(input[1]));
                break;
            case "SET":
                res = processSet(input);
                break;
            case "GET":
                res = get(input[1]);
                break;
            case "GET_TTL":
                res = get_ttl(input[1]);
                break;
            case "DEL":
                res = delete(input[1]);
                break;
        }
        return res;
    }

    private String processSet(String[] input) {
        String result = "Successfully set entry";
        if (input.length == 3) {
            set(input[1], input[2]);
        } else if (input.length == 4) {
            set(input[1], input[2], Integer.valueOf(input[3]));
        } else {
            result = "Invalid number of arguments passed!";
        }
        return result;
    }

    @Override
    public void create(int capacity) {
        cache = new CustomCache(capacity);
    }


    @Override
    public void set(String key, String value) {
        set(key, value, -1);
    }

    @Override
    public void set(String key, String value, Integer ttl) {
        cache.set(key, value, ttl);
    }

    @Override
    public String delete(String key) {
        return cache.delete(key);
    }

    @Override
    public String get(String key) {
        return cache.get(key);
    }

    @Override
    public String get_ttl(String key) {
        return cache.get_ttl(key);
    }
}
