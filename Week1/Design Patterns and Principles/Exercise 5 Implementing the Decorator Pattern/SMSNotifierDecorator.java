public class SMSNotifierDecorator extends NotifierDecorator {

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message); // Send via wrapped notifier first
        sendSMS(message);    // Then add SMS
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
