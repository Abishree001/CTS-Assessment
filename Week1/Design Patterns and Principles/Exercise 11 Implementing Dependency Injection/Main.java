public class Main {
    public static void main(String[] args) {
        // Manually inject dependency
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        // Test
        service.displayCustomer(1);
        service.displayCustomer(2);
        service.displayCustomer(3);  // not found case
    }
}
