package lessons.Default;

public interface ErrorLogger {
    default void log(String message) {
        System.out.println("[ERROR] " + message);
    }
}
