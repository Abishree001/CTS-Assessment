public class EmployeeManagement {
    static final int MAX_EMPLOYEES = 100;
    static Employee[] employees = new Employee[MAX_EMPLOYEES];
    static int count = 0;

    // Add employee
    public static void addEmployee(int id, String name, String position, double salary) {
        if (count < MAX_EMPLOYEES) {
            employees[count++] = new Employee(id, name, position, salary);
            System.out.println(" Employee added.");
        } else {
            System.out.println("Cannot add more employees. Array is full.");
        }
    }

    // Search employee by ID
    public static Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse employees
    public static void displayEmployees() {
        if (count == 0) {
            System.out.println(" No employees to display.");
            return;
        }
        System.out.println("\n Employee List:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee by ID
    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                // Shift elements
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        // Sample test
        addEmployee(1, "Arun", "Manager", 55000);
        addEmployee(2, "Meena", "Developer", 45000);
        addEmployee(3, "Ravi", "Analyst", 48000);

        displayEmployees();

        System.out.println("\n Searching for Employee ID 2:");
        Employee emp = searchEmployee(2);
        System.out.println(emp != null ? "Found: " + emp : "Not found");

        System.out.println("\n Deleting Employee ID 1");
        deleteEmployee(1);

        displayEmployees();
    }
}
