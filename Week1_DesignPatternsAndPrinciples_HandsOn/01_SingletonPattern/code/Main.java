public class Main {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("Developer: Rishi Srivastava");
        System.out.println("Exercise 1: Implementing Singleton Pattern");
        System.out.println("=========================================\n");

        Logger logInstance1 = Logger.getInstance();
        Logger logInstance2 = Logger.getInstance();

        System.out.println("Configuring session details via Instance 1...");
        logInstance1.updateCredentials("Rishi_Admin", "SecurePass2026");

        System.out.println("\nReading session details via Instance 2:");
        logInstance2.showActiveSession();

        System.out.println("\n--- Integrity Verification ---");
        System.out.println("Instance 1 Memory Hash : " + logInstance1.hashCode());
        System.out.println("Instance 2 Memory Hash : " + logInstance2.hashCode());

        if (logInstance1 == logInstance2) {
            System.out.println("\nVERDICT: Singleton verification successful. Perfect match.");
        } else {
            System.out.println("\nVERDICT: Mismatch detected in instance references.");
        }
    }
}