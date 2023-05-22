package nl.bramjanssens.unittesting.faking.person;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message, IllegalArgumentException e) {
        super(message, e);
    }
}
