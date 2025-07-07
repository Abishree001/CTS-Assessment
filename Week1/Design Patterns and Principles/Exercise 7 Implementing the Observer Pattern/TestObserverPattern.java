public class TestObserverPattern {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("TCS");

        Observer mobileUser = new MobileApp("Abishree");
        Observer webUser = new WebApp("Ravi");

        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

        stockMarket.setStockPrice(720.45);
        stockMarket.setStockPrice(730.10);

        stockMarket.removeObserver(webUser);

        stockMarket.setStockPrice(740.00); // only MobileApp receives this
    }
}
