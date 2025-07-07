public class SlackNotifierDecorator extends NotifierDecorator {

    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);  // Send via previous notifier
        sendSlack(message);   // Add Slack notification
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack Message: " + message);
    }
}
