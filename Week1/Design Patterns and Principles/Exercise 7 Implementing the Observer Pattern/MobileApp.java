public class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("[" + user + " - Mobile] Received update: " + stockName + " = $" + stockPrice);
    }
}
