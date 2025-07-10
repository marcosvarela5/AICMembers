package es.marcos.backend.domain.exception;

public class SocioNotFound extends RuntimeException {
    public SocioNotFound(String message) {
        super(message);
    }
}
