public class FinancialForecast {

    // Recursive method to calculate future value
    public static double forecastValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue; // base case
        } else {
            return forecastValue(presentValue, growthRate, years - 1) * (1 + growthRate);
        }
    }

    public static void main(String[] args) {
        double initialAmount = 10000; // Starting amount
        double annualGrowthRate = 0.08; // 8% growth
        int totalYears = 5;

        System.out.println(" Financial Forecast for " + totalYears + " years:");
        for (int i = 0; i <= totalYears; i++) {
            double value = forecastValue(initialAmount, annualGrowthRate, i);
            System.out.printf("Year %d: %.2f%n", i, value);
        }
    }
}
