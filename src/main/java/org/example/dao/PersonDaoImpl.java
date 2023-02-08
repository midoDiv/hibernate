package org.example.dao;

import org.example.domain.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class PersonDaoImpl  implements PersonDao{
    private StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
    private Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
    private SessionFactory factory = meta.getSessionFactoryBuilder().build();

    @Override
    public void save() {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Person p=new Person();
        p.setName("mohamed");
        session.persist(p);
        try {
            transaction.commit();
            System.out.print("person saved ");
        }catch (Exception e)
        {
            transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    @Override
    public void update() {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Person p=new Person();
        p.setId(2L);
        p.setName("mhada");
        session.merge(p);
        try {
            transaction.commit();
            System.out.print("person updated ");
        }catch (Exception e)
        {
            transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    @Override
    public void delete() {
        Session session=factory.openSession();
        Transaction transaction=session.beginTransaction();
        Person p=new Person();
        p.setId(2L);
        session.remove(p);
        try {
            transaction.commit();
            System.out.print("person deleted ");
        }catch (Exception e)
        {
            transaction.rollback();
        }
        finally {
            session.close();
        }
    }

    @Override
    public Person findById(Long id) {
        Session session=factory.openSession();
        Person p=session.get(Person.class,id);
        session.close();
        return p;
    }
}
