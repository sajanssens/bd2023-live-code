package nl.bramjanssens.ocp;

import java.io.IOException;

public class Device implements AutoCloseable {
    String header = null;

    public void open() throws IOException {
        header = "OPENED";
        System.out.println("Device Opened");
        throw new IOException("Unknown");
    }

    public String read() throws IOException { return ""; }

    public void close() {
        System.out.println("Closing device");
        header = null;
        // throw new RuntimeException("rte");
    }

    public static void main(String[] args) throws Exception {
        try (Device d = new Device()) {
            try {
                erGaatIetsFout();
            } catch (IllegalArgumentException e) {
                throw new Exception("test", e);
            }
        }
    }

    private static void erGaatIetsFout() {
        try {
            erGaatNogIetsFout();
        } catch (Throwable e) {
            throw new IllegalArgumentException("cause", e);
        }
    }

    private static void erGaatNogIetsFout() {
        throw new IllegalArgumentException("root cause");
    }
}
