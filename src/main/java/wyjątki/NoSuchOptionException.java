package wyjątki;

public class NoSuchOptionException extends Exception {
    public NoSuchOptionException(String message) {
        super(message);
    }
}