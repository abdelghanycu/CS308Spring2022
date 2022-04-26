package com.sci.dao;

import com.sci.criteria.FilterQuery;
import com.sci.criteria.Operator;
import com.sci.models.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DBEmployee {

  public List<Employee> get() {

    try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

      return session.createQuery("FROM Employee").list();

//      return session.createSQLQuery("select * from hr.employees").addEntity(Employee.class).list();

    } catch (Exception ex) {
      System.err.println(ex.getMessage());
    }

    return null;
  }

  public Employee get(Integer employeeId) {

    try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

      return session.get(Employee.class, employeeId);

    } catch (Exception ex) {
      System.err.println(ex.getMessage());
    }

    return null;
  }


  public Integer insert(Employee employee) {

    Transaction transaction = null;
    int employeeId = 0;

    try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

      transaction = session.beginTransaction();

      employeeId = (Integer) session.save(employee);

      transaction.commit();

    } catch (Exception ex) {
      if (transaction != null) {
        transaction.rollback();
      }
      System.err.println(ex.getMessage());
    }

    return employeeId;
  }

  public void update(Employee employee) {

    Transaction transaction = null;

    try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

      transaction = session.beginTransaction();

      session.update(employee);

      transaction.commit();

    } catch (Exception ex) {
      if (transaction != null) {
        transaction.rollback();
      }
      System.err.println(ex.getMessage());
    }
  }

  public void delete(Integer employeeId) {

    Transaction transaction = null;

    try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

      transaction = session.beginTransaction();

      Employee employee = get(employeeId);

      session.delete(employee);

      transaction.commit();

    } catch (Exception ex) {
      if (transaction != null) {
        transaction.rollback();
      }
      System.err.println(ex.getMessage());
    }
  }

  public List<Employee> getByFilter(List<FilterQuery> filterQueries) {

    try (Session session = DBConfig.SESSION_FACTORY.openSession()) {

      CriteriaBuilder cb = session.getCriteriaBuilder();
      CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
      Root<Employee> root = cr.from(Employee.class);
//      cr.select(root);

      Predicate[] predicates = new Predicate[filterQueries.size()];
      for (int i = 0; i < filterQueries.size(); i++) {
        if (filterQueries.get(i).getOp() == Operator.EQ) {
          predicates[i] = cb.equal(root.get(filterQueries.get(i).getAttributeName()),
              filterQueries.get(i).getAttributeValue());
        } else if (filterQueries.get(i).getOp() == Operator.GT) {
          predicates[i] = cb.gt(root.get(filterQueries.get(i).getAttributeName()),
              (Integer) filterQueries.get(i).getAttributeValue());
        }
      }
        cr.select(root).where(predicates);

//      for (FilterQuery filterQuery : filterQueries) {
//        if (filterQuery.getOp() == Operator.EQ) {
//          cr.select(root).where(
//              cb.equal(root.get(filterQuery.getAttributeName()), filterQuery.getAttributeValue()));
//        } else if (filterQuery.getOp() == Operator.GT) {
//          cr.select(root).where(
//              cb.gt(root.get(filterQuery.getAttributeName()),
//                  (Integer) filterQuery.getAttributeValue()));
//        }
//      }
      Query<Employee> query = session.createQuery(cr);
      return query.getResultList();

    } catch (Exception ex) {
      System.err.println(ex.getMessage());
    }

    return new ArrayList<>();
  }

}
