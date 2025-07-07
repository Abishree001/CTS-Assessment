public class TestProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("landscape.jpg");
        Image image2 = new ProxyImage("portrait.jpg");

        // Image is loaded from remote server (lazy load)
        image1.display();
        
        // Image is cached, no need to reload
        image1.display();

        // New image, triggers remote load
        image2.display();

        // Cached on second call
        image2.display();
    }
}
