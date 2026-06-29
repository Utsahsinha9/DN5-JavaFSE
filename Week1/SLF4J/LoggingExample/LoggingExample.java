public class LoggingExample {

    static class SimpleLogger {
        private String className;

        SimpleLogger(String className) {
            this.className = className;
        }

        void info(String message) {
            System.out.println("[INFO]  " + className + " - " + message);
        }

        void warn(String message) {
            System.out.println("[WARN]  " + className + " - " + message);
        }

        void error(String message) {
            System.out.println("[ERROR] " + className + " - " + message);
        }

        void error(String message, Exception e) {
            System.out.println("[ERROR] " + className + " - " + message + " : " + e.getMessage());
        }

        void debug(String message) {
            System.out.println("[DEBUG] " + className + " - " + message);
        }
    }

    static class BankingService {
        private static final SimpleLogger logger = new SimpleLogger("BankingService");

        void processTransaction(String accountId, double amount) {
            logger.info("Processing transaction for account: " + accountId);

            if (amount <= 0) {
                logger.warn("Invalid transaction amount: " + amount);
                return;
            }

            if (amount > 100000) {
                logger.warn("Large transaction detected: " + amount + " for account: " + accountId);
            }

            try {
                logger.debug("Validating account: " + accountId);
                if (accountId == null || accountId.isEmpty()) {
                    throw new IllegalArgumentException("Invalid account ID");
                }
                logger.info("Transaction successful for account: " + accountId + " amount: " + amount);
            } catch (Exception e) {
                logger.error("Transaction failed for account: " + accountId, e);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== SLF4J Logging Example ===\n");
        BankingService service = new BankingService();

        service.processTransaction("ACC001", 5000.0);
        System.out.println();

        service.processTransaction("ACC002", 150000.0);
        System.out.println();

        service.processTransaction("ACC003", -100.0);
        System.out.println();

        service.processTransaction("", 1000.0);
    }
}
