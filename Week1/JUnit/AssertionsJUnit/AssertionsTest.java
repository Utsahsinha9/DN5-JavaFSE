public class AssertionsTest {

    static class Calculator {
        int add(int a, int b) {
            return a + b;
        }

        int subtract(int a, int b) {
            return a - b;
        }

        int multiply(int a, int b) {
            return a * b;
        }

        double divide(double a, double b) {
            if (b == 0)
                throw new ArithmeticException("Cannot divide by zero");
            return a / b;
        }
    }

    static void testAdd() {
        Calculator calc = new Calculator();
        assert calc.add(5, 3) == 8 : "Addition failed";
        assert calc.add(0, 0) == 0 : "Addition with zeros failed";
        assert calc.add(-1, 1) == 0 : "Addition with negatives failed";
        System.out.println("✓ testAdd passed");
    }

    static void testSubtract() {
        Calculator calc = new Calculator();
        assert calc.subtract(10, 3) == 7 : "Subtraction failed";
        assert calc.subtract(0, 0) == 0 : "Subtraction with zeros failed";
        System.out.println("✓ testSubtract passed");
    }

    static void testMultiply() {
        Calculator calc = new Calculator();
        assert calc.multiply(4, 3) == 12 : "Multiplication failed";
        assert calc.multiply(0, 5) == 0 : "Multiplication with zero failed";
        System.out.println("✓ testMultiply passed");
    }

    static void testDivide() {
        Calculator calc = new Calculator();
        assert calc.divide(10, 2) == 5.0 : "Division failed";
        System.out.println("✓ testDivide passed");
    }

    static void testDivideByZero() {
        Calculator calc = new Calculator();
        try {
            calc.divide(10, 0);
            System.out.println("✗ testDivideByZero failed - exception not thrown");
        } catch (ArithmeticException e) {
            System.out.println("✓ testDivideByZero passed - exception caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Running Assertions Tests ===");
        testAdd();
        testSubtract();
        testMultiply();
        testDivide();
        testDivideByZero();
        System.out.println("=== All Assertions Passed ===");
    }
}