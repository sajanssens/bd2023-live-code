package nl.belastingdienst.rest.util;

import java.util.concurrent.atomic.AtomicInteger;

public class Id {

    static AtomicInteger lastId = new AtomicInteger(0);

    public static int next() {
        return lastId.incrementAndGet();
    }
}
