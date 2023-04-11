package nl.bramjanssens.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JDemo {

    private final Logger logger = LoggerFactory.getLogger(SLF4JDemo.class);

    public static void main(String[] args) {
        new SLF4JDemo().start();
    }

    private void start() {
        logger.error("Er ging iets vreselijk mis....");
        logger.warn("waarschuwing!!");
        logger.info("human readable voor service desk"); // servicedesk
        logger.debug("voor developer");
        logger.trace("zeer gedetailleerde info");
    }
}
