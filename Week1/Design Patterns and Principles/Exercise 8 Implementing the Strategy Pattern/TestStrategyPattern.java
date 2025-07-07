public class TestStrategyPattern {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234567890123456"));
        context.executePayment(250.75);

        // Use PayPal
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.executePayment(150.00);
    }
}
