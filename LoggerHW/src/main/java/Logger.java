import java.util.Date;

public final class Logger {

    private int num = 1;
    private static Logger logger;

    Date date = new Date();

    private Logger() {}

    public static Logger getInstance() {
        if(logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        System.out.println("[" + date + " " + num++ + "] " + msg);
    }
}
