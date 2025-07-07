import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<Integer, Customer> customerData = new HashMap<>();

    public CustomerRepositoryImpl() {
        customerData.put(1, new Customer(1, "shree ", "Tn"));
        customerData.put(2, new Customer(2, "John Doe", "Chennai"));
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerData.get(id);
    }
}
