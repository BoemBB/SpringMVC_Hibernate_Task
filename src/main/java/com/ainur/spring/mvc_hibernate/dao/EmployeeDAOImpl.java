package com.ainur.spring.mvc_hibernate.dao;

import com.ainur.spring.mvc_hibernate.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee> allEmployees = session.createQuery("from Employee",
                Employee.class).getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id =:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

    //Запрос с группировкой
    @Override
    public List<Employee> groupEmployeesByName() {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT name FROM Employee GROUP BY name";
        Query query = session.createQuery(hql);
        List<Employee> results = query.list();
        return results;
    }

    //Запрос по нескольким таблицам
    @Override
    public List<?> getEmployeesWithPosition() {
        Session session = sessionFactory.getCurrentSession();
        List<?> list = session.createQuery("select e.name, p.name from Employee as e inner join Position as p on e.position.id = p.id").list();
        return list;
    }
}
