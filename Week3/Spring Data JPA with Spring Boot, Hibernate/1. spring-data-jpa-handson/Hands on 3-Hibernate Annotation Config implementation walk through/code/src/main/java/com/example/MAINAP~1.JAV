package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {
            // Insert employees
            Transaction tx1 = session.beginTransaction();

            Employee emp1 = new Employee("John", "Doe", 5000);
            Employee emp2 = new Employee("Jane", "Smith", 7000);

            session.save(emp1);
            session.save(emp2);

            tx1.commit();

            // Fetch all employees
            System.out.println("\n=== All Employees ===");
            session = factory.openSession();
            List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
            for (Employee emp : employees) {
                System.out.println("ID: " + emp.getId() + ", Name: " + emp.getFirstName() + " " + emp.getLastName() + ", Salary: " + emp.getSalary());
            }

            // Fetch employee by ID
            System.out.println("\n=== Get by ID ===");
            Employee empById = session.get(Employee.class, emp1.getId());
            System.out.println(empById.getFirstName());

            // Delete employee by ID (correct way)
            System.out.println("\n=== Delete by ID ===");
            Transaction tx3 = session.beginTransaction();

            Employee empToDelete = session.get(Employee.class, emp2.getId());
            if (empToDelete != null) {
                session.delete(empToDelete);
                System.out.println("Deleted employee: " + empToDelete.getFirstName());
            } else {
                System.out.println("Employee not found.");
            }

            tx3.commit();

            // After deletion
            System.out.println("\n=== After Deletion ===");
            List<Employee> remaining = session.createQuery("from Employee", Employee.class).list();
            for (Employee emp : remaining) {
                System.out.println(emp.getFirstName());
            }

        } finally {
            session.close();
            factory.close();
        }
    }
}
