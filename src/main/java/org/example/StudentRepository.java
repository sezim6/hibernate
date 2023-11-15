package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentRepository {
    private  final SessionFactory sessionFactory = Dbconfiguration.getSessionFactory();
    public  void save (Student student){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }
    public  Student findById(Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }
    public List<Student>findAll(){
        Session session = sessionFactory.openSession();
        Query<Student > query= session.createQuery("select s from Student s");
        List<Student >list= query.getResultList();
        session.close();
        return list;
    }
    public void update(Long id,Student student){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student1 = session.get(Student.class, id);
        student1.setName(student1.getName());
        student1.setAge(student1.getAge());
        session.update(student1);
        System.out.println("updated!");
        transaction.commit();
        session.close();
    }
    public  void deleteById(Long id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        transaction.commit();
        session.close();
    }
    public  void deleteAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query <?>query = session.createQuery("delete  from Student s");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
