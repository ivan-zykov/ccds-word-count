package net.ivanzykov.wordcounter;

/**
 * It should terminate execution of this app.
 */
public class CriticalAppException extends RuntimeException {
    public CriticalAppException(String message) {
        super(message);
    }
}
