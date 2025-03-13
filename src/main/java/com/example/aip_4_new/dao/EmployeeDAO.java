package com.example.aip_4_new.dao;

import com.example.aip_4_new.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;
import org.hibernate.Session;

import java.util.List;

public class EmployeeDAO {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("my-persistence-unit");

    public void addEmployee(Employee employee) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        // Extract address from employee
        if (employee.getAddress() != null) {
            em.persist(employee.getAddress());  // Persist address first
        }

        em.persist(employee); // Persist employee now
        em.getTransaction().commit();
        em.close();
    }


    public Employee getEmployee(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Employee employee = em.find(Employee.class, id);
        em.close();
        return employee;
    }

    public List<Employee> getAllEmployees() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Employee> employees = em.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
        em.close();
        return employees;
    }

    public void deleteEmployee(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        Employee employee = em.find(Employee.class, id);
        if (employee != null) {
            em.remove(employee);
        }

        em.getTransaction().commit();
        em.close();
    }

    public void updateEmployee(Employee employee) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(employee); // Update employee in database
        em.getTransaction().commit();
        em.close();
    }


}
