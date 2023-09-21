package com.fyodork.spring.mvc_hibernate_aop.dao;

import com.fyodork.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    //@Transactional
    public List<Employee> getAllEmployees() {
        Session session=sessionFactory.getCurrentSession();
       /* List<Employee> allEmployees=session
                .createQuery("from Employee",Employee.class)
                .getResultList();*/
        Query<Employee> query=session.createQuery("from Employee",Employee.class);
        List<Employee> allEmployees=query.getResultList();
        return allEmployees;


    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session=sessionFactory.getCurrentSession();
        session.persist(employee);
    }
}
