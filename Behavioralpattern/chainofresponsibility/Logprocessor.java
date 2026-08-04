package Behavioralpattern.chainofresponsibility;

public abstract class Logprocessor {
    public static final int DEBUG = 1;
    public static final int INFO = 2;
    public static final int ERROR = 3;
    public static final int FATAL = 4;
    
    int level;
    Logprocessor NextLogger;

    public void setNextLogger(Logprocessor NextLogger){
        this.NextLogger = NextLogger;
    }
    
    public void logMessage(int level, String message){
        if (this.level == level) {
            write(message);
            return;
        }

        // Pass to next handler in chain if exists
        if (this.NextLogger != null) {
            this.NextLogger.logMessage(level, message);
        }
    }
    abstract protected void write(String message);

}
