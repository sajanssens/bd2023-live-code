package nl.belastingdienst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemo {

    private static final Logger log = LoggerFactory.getLogger(LoggingDemo.class);

    public static void main(String[] args) {
        log.error("Mayday! Mayday! SOS!"); // M'aider!
        log.warn("Attention...!");
        log.info("Have you tried turning it off and on again?");
        log.debug("See, the driver hooks a function by patching the system call table, " +
                "so it's not safe to unload it unless another thread's about to jump " +
                "in there and do its stuff, and you don't want to end up in the middle of invalid memory! ");
        log.trace("0xCAFEBABE MOV EAX, [EBX]; MOV [ESI+EAX], CL;");
        Person p = new Person();
        p.doeiets();
    }
}
