package lessons.Default;

// Клас реалізує обидва інтерфейси з однаковим default методом
class FileLogger implements Logger, ErrorLogger {
    // ОБОВ'ЯЗКОВО перевизначити, бо конфлікт!
    @Override
    public void log(String message) {
        // Викликаємо конкретну версію через InterfaceName.super
        System.out.print("До файлу: ");
        Logger.super.log(message);  // Викликаємо Logger.log()

        System.out.print("До файлу: ");
        ErrorLogger.super.log(message);  // Викликаємо ErrorLogger.log()
    }
}
