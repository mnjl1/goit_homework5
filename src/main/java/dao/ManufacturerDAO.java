package dao;

import models.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManufacturerDAO {
    private Long id;
    private String name;

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void create(){
        Manufacturer manufacturer = new Manufacturer();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        manufacturer.setManufacturerName(name);
        transaction.commit();
        session.close();
    }

    public void update(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Manufacturer manufacturer = session.get(Manufacturer.class, id);
        manufacturer.setManufacturerName(name);
        transaction.commit();
        session.close();
    }

    public void delete(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Manufacturer manufacturer = session.get(Manufacturer.class, id);
        session.delete(manufacturer);
        transaction.commit();
        session.close();
    }

    public Manufacturer getById(Long manufactureId){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Manufacturer manufacturer = session.get(Manufacturer.class, id);
        transaction.commit();
        session.close();
        return manufacturer;
    }
}
