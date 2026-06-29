public class FinancialForecasting {

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: no more years left
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 10000.0; // Initial investment
        double growthRate = 0.08; // 8% annual growth
        int years = 5; // 5 years

        System.out.println("=== Financial Forecasting Tool ===");
        System.out.println("Present Value: $" + presentValue);
        System.out.println("Annual Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Investment Period: " + years + " years");
        System.out.println("==================================");

        for (int i = 1; i <= years; i++) {
            double futureValue = calculateFutureValue(presentValue, growthRate, i);
            System.out.printf("Year %d: $%.2f%n", i, futureValue);
        }

        double finalValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.println("==================================");
        System.out.printf("Final Future Value after %d years: $%.2f%n", years, finalValue);
    }
}