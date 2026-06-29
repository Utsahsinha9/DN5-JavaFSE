import java.util.ArrayList;
import java.util.List;

public class VerifyingInteractionsTest {

    interface NotificationService {
        void sendEmail(String to, String message);

        void sendSMS(String phone, String message);
    }

    static class MockNotificationService implements NotificationService {
        private List<String> emailsSent = new ArrayList<>();
        private List<String> smsSent = new ArrayList<>();
        private int emailCount = 0;
        private int smsCount = 0;

        public void sendEmail(String to, String message) {
            emailsSent.add(to);
            emailCount++;
            System.out.println("Mock: Email sent to " + to + " - " + message);
        }

        public void sendSMS(String phone, String message) {
            smsSent.add(phone);
            smsCount++;
            System.out.println("Mock: SMS sent to " + phone + " - " + message);
        }

        public int getEmailCount() {
            return emailCount;
        }

        public int getSmsCount() {
            return smsCount;
        }

        public boolean emailSentTo(String to) {
            return emailsSent.contains(to);
        }

        public boolean smsSentTo(String phone) {
            return smsSent.contains(phone);
        }
    }

    static class UserRegistrationService {
        private NotificationService notificationService;

        UserRegistrationService(NotificationService notificationService) {
            this.notificationService = notificationService;
        }

        void registerUser(String email, String phone) {
            System.out.println("Registering user: " + email);
            notificationService.sendEmail(email, "Welcome to our platform!");
            notificationService.sendSMS(phone, "Your account has been created.");
        }
    }

    static void testRegisterUserSendsEmail() {
        MockNotificationService mockNotification = new MockNotificationService();
        UserRegistrationService registrationService = new UserRegistrationService(mockNotification);

        registrationService.registerUser("utsah@example.com", "9876543210");

        assert mockNotification.emailSentTo("utsah@example.com") : "Email should be sent";
        assert mockNotification.smsSentTo("9876543210") : "SMS should be sent";
        assert mockNotification.getEmailCount() == 1 : "Email should be sent exactly once";
        assert mockNotification.getSmsCount() == 1 : "SMS should be sent exactly once";
        System.out.println("✓ testRegisterUserSendsEmail passed");
    }

    static void testMultipleRegistrations() {
        MockNotificationService mockNotification = new MockNotificationService();
        UserRegistrationService registrationService = new UserRegistrationService(mockNotification);

        registrationService.registerUser("user1@example.com", "1111111111");
        registrationService.registerUser("user2@example.com", "2222222222");

        assert mockNotification.getEmailCount() == 2 : "Two emails should be sent";
        assert mockNotification.getSmsCount() == 2 : "Two SMS should be sent";
        System.out.println("✓ testMultipleRegistrations passed");
    }

    public static void main(String[] args) {
        System.out.println("=== Running Verifying Interactions Tests ===");
        testRegisterUserSendsEmail();
        testMultipleRegistrations();
        System.out.println("=== All Interaction Tests Passed ===");
    }
}