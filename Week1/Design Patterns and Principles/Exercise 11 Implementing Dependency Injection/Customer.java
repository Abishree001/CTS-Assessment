public class Customer {
    private int id;
    private String name;
    private String city;

    public Customer(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "[ID: " + id + ", Name: " + name + ", City: " + city + "]";
    }
}
