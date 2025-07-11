package com.example.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        // Insert data
        Employee emp1 = new Employee("John", "Doe", 5000f);
        Employee emp2 = new Employee("Jane", "Smith", 7000f);
        session.save(emp1);
        session.save(emp2);
        tx.commit();

        // Read all
        System.out.println("=== All Employees ===");
        List<Employee> list = session.createQuery("from Employee").list();
        for (Employee e : list) {
            System.out.println("ID: " + e.getId() + ", Name: " + e.getFirstName() + " " + e.getLastName() + ", Salary: " + e.getSalary());
        }

        // Get one by ID
        Employee fetched = session.get(Employee.class, emp1.getId());
        System.out.println("\n=== Get by ID ===");
        System.out.println(fetched.getFirstName() + " " + fetched.getLastName());

        // Delete one
        tx = session.beginTransaction();
        session.delete(emp2);
        tx.commit();

        // Read again
        System.out.println("\n=== After Deletion ===");
        list = session.createQuery("from Employee").list();
        for (Employee e : list) {
            System.out.println(e.getFirstName() + " " + e.getLastName());
        }

        session.close();
        factory.close();
    }
}
