public class TestDecoratorPattern {
    public static void main(String[] args) {
        // Step-by-step decoration
        Notifier baseNotifier = new EmailNotifier(); // Email only

        Notifier smsNotifier = new SMSNotifierDecorator(baseNotifier); // Email + SMS

        Notifier fullNotifier = new SlackNotifierDecorator(smsNotifier); // Email + SMS + Slack

        System.out.println("Sending Alert:");
        fullNotifier.send("System down at 3 AM!");
    }
}
