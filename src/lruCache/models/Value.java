package lruCache.models;

public class Value {

    private final Object val;
    private Integer ttl;
    private Long currTime;

    public Value(Object val) {
        this.val = val;
        currTime = System.currentTimeMillis();
    }

    public Value(Object val, Integer ttl) {
        this.val = val;
        this.ttl = ttl;
        currTime = System.currentTimeMillis();
    }

    public Object getVal() {
        return val;
    }

    public Integer getTtl() {
        return ttl;
    }

    public boolean isExpired() {
        if (ttl == -1) return false;

        Long now = System.currentTimeMillis();
        if (now > currTime + ttl*1000l) {
            return true;
        }
        return false;
    }
}
