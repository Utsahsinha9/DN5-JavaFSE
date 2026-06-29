import java.util.ArrayList;
import java.util.List;

public class MockingStubbingTest {

    interface PaymentService {
        boolean processPayment(String customerId, double amount);

        double getAccountBalance(String customerId);
    }

    static class OrderService {
        private PaymentService paymentService;

        OrderService(PaymentService paymentService) {
            this.paymentService = paymentService;
        }

        String placeOrder(String customerId, double amount) {
            double balance = paymentService.getAccountBalance(customerId);
            if (balance < amount) {
                return "Order failed: Insufficient balance";
            }
            boolean success = paymentService.processPayment(customerId, amount);
            if (success) {
                return "Order placed successfully";
            }
            return "Order failed: Payment unsuccessful";
        }
    }

    static class MockPaymentService implements PaymentService {
        private boolean paymentResult;
        private double balance;
        private List<String> calledMethods = new ArrayList<>();

        MockPaymentService(boolean paymentResult, double balance) {
            this.paymentResult = paymentResult;
            this.balance = balance;
        }

        public boolean processPayment(String customerId, double amount) {
            calledMethods.add("processPayment");
            System.out.println("Mock: processPayment called for " + customerId + " amount: " + amount);
            return paymentResult;
        }

        public double getAccountBalance(String customerId) {
            calledMethods.add("getAccountBalance");
            System.out.println("Mock: getAccountBalance called for " + customerId);
            return balance;
        }

        public List<String> getCalledMethods() {
            return calledMethods;
        }
    }

    static void testSuccessfulOrder() {

        MockPaymentService mockPayment = new MockPaymentService(true, 1000.0);
        OrderService orderService = new OrderService(mockPayment);

        String result = orderService.placeOrder("CUST001", 500.0);

        assert result.equals("Order placed successfully") : "Order should succeed";
        assert mockPayment.getCalledMethods().contains("processPayment") : "processPayment should be called";
        System.out.println("✓ testSuccessfulOrder passed - " + result);
    }

    static void testInsufficientBalance() {

        MockPaymentService mockPayment = new MockPaymentService(true, 100.0);
        OrderService orderService = new OrderService(mockPayment);

        String result = orderService.placeOrder("CUST002", 500.0);

        assert result.equals("Order failed: Insufficient balance") : "Order should fail";
        System.out.println("✓ testInsufficientBalance passed - " + result);
    }

    public static void main(String[] args) {
        System.out.println("=== Running Mocking and Stubbing Tests ===");
        testSuccessfulOrder();
        testInsufficientBalance();
        System.out.println("=== All Mocking Tests Passed ===");
    }
}