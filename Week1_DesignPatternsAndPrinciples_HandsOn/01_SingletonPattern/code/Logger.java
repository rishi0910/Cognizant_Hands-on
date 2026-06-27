public class Logger {

    private static Logger loggerObject;
    private String sessionUser;
    private String accessKey;

    private Logger() {}

    public static synchronized Logger getInstance() {
        if (loggerObject == null) {
            loggerObject = new Logger();
        }
        return loggerObject;
    }

    public void updateCredentials(String user, String key) {
        this.sessionUser = user;
        this.accessKey = key;
    }

    public void showActiveSession() {
        System.out.println("Active User : " + (sessionUser != null ? sessionUser : "NONE"));
        System.out.println("Access Token: " + (accessKey != null ? accessKey : "NONE"));
    }
}