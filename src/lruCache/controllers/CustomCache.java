package lruCache.controllers;


import lruCache.models.Value;
import lruCache.services.Cache;

import java.util.*;

public class CustomCache implements Cache {

    Map<String, Value> map;
    int cap;
    List<String> q = new ArrayList<>();

    public CustomCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;

    }

    public void put(String key, Value value) {
        if (q.size() == cap) {
            String evict = q.get(0);
            q.remove(0);
            map.remove(evict);
        }
        map.put(key, value);
        q.add(key);
    }

    @Override
    public void set(String key, String value, Integer ttl) {
        evictExpiredKeys();
        Value val = new Value(value, ttl);
        put(key, val);
    }

    private void evictExpiredKeys() {
        Set<String> expiredKeys = new HashSet<>();
        for (Map.Entry<String, Value> entry : map.entrySet()) {
            String key = entry.getKey();
            Value value = entry.getValue();
            if (value.isExpired()) {
                expiredKeys.add(key);
            }
        }
        expiredKeys.stream().forEach(key -> map.remove(key));
    }

    @Override
    public String delete(String key) {
        String result = null;

        if (!map.containsKey(key)) {
            result = String.valueOf(0);
        } else {
            map.remove(key);
            result = String.valueOf(1);
        }
        return result;
    }

    @Override
    public String get(String key) {
        String result = "Null";
        if (!map.containsKey(key)) {
        } else {
            Value val = map.get(key);
            q.remove(key);
            q.add(key);
            if (!val.isExpired()) {
                result = String.valueOf(val.getVal());
            }
        }

        return result;
    }

    @Override
    public String get_ttl(String key) {
        String result = null;
        if (!map.containsKey(key)) {
            result = "-1";
        } else {
            Value val = map.get(key);
            result = String.valueOf(val.getTtl());
        }

        return result;
    }

}
