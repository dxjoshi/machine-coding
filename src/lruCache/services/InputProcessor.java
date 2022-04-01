package lruCache.services;

public interface InputProcessor {
    void begin();
    void create(int capacity);
    void set(String key, String value);
    void set(String key, String value, Integer ttl);
    String delete(String key);
    String get(String key);
    String get_ttl(String key);
}
