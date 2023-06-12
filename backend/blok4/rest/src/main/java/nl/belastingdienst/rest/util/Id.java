package nl.belastingdienst.rest.util;

import java.util.concurrent.atomic.AtomicInteger;

public class Id {

    static AtomicInteger lastId = new AtomicInteger(0);
    // static int lastId = 0;
    // static ReentrantLock plasketting = new ReentrantLock();

    public static int next() {
        // synchronized (Id.class) {
        //     return ++lastId;
        // }

        // plasketting.lock();
        // int i = ++lastId;
        // plasketting.unlock();
        // return i;

        return lastId.incrementAndGet();
    }
}
