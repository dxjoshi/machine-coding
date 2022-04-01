package lruCache.services;

public interface Cache {

    void set(String key, String value, Integer ttl);
    String delete(String key);
    String get(String key);
    String get_ttl(String key);
}
