package Behavioralpattern.chainofresponsibility;

public class LoggingDemo {
    public static void main(String[] args) {
        System.out.println("###### Chain of Responsibility Design Pattern ######");

        // Get the chain of loggers
        Logprocessor logProcessor = getChainOfLoggers();

        System.out.println("Logging messages:");
        System.out.println("===== Logging DEBUG message =====");
        logProcessor.logMessage(Logprocessor.DEBUG, "This is a debug message");
        System.out.println("===== Logging INFO message =====");
        logProcessor.logMessage(Logprocessor.INFO, "This is an info message");
        System.out.println("===== Logging ERROR message =====");
        logProcessor.logMessage(Logprocessor.ERROR, "This is an error message");
        System.out.println("===== Logging FATAL message =====");
        logProcessor.logMessage(Logprocessor.FATAL, "This is a fatal message");
    }

    private static Logprocessor getChainOfLoggers() {
        Logprocessor fatalLogger = new FatalLogger(Logprocessor.FATAL); // 4
        Logprocessor errorLogger = new ErrorLogger(Logprocessor.ERROR); // 3
        Logprocessor infoLogger = new InfoLogger(Logprocessor.INFO); // 2
        Logprocessor debugLogger = new DebugLogger(Logprocessor.DEBUG); // 1

        //  Dynamic Chaining: DEBUG -> INFO -> ERROR -> FATAL
        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(errorLogger);
        errorLogger.setNextLogger(fatalLogger);
        // fatalLogger.nextLoggerProcessor is null; // Last logger in chain

        return debugLogger;  // Return the first LogProcessor in chain
    }
}
