package nl.bramjanssens;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Singleton @Slf4j
public class OtherService {

    @Inject
    PersonDao dao;

    public void show() {
        log.info("------------------------ show" + this);
    }
}
