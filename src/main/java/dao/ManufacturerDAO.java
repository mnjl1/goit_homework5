package dao;

import models.Manufacturer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ManufacturerDAO {

    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void create(String manufacturerName) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerName(manufacturerName);
        session.save(manufacturer);
        transaction.commit();
        session.close();
    }

    public void update(String manufacturerName, long id){
        Manufacturer manufacturer = new Manufacturer();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        manufacturer = session.get(Manufacturer.class, id);
        manufacturer.setManufacturerName(manufacturerName);
        transaction.commit();
        session.close();
    }

    public void delete(Long manufacturerId){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Manufacturer manufacturer = session.get(Manufacturer.class, manufacturerId);
        session.delete(manufacturer);
        transaction.commit();
        session.close();
    }

    public Manufacturer getById(Long manufacturer_id){
        Session session = sessionFactory.openSession();
        Manufacturer manufacturer = session.get(Manufacturer.class, manufacturer_id);
        session.close();
        return manufacturer;
    }

    public List <Manufacturer> getAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getSession().createQuery("from Manufacturer");
        List<Manufacturer> manufacturerList =query.getResultList();
        session.close();
        return manufacturerList;
    }

    public static void main(String[] args) {
        ManufacturerDAO manufacturerDAO = new ManufacturerDAO();
        manufacturerDAO.create("Nestle");
    }


}
