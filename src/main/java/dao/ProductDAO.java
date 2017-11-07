package dao;

import models.Manufacturer;
import models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductDAO {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void create(String productName, Long manufacturerId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = new Product();
        product.setProductName(productName);
        Manufacturer manufacturer = session.get(Manufacturer.class, manufacturerId);
        manufacturer.addProduct(product);
        session.save(product);
        session.save(manufacturer);
        transaction.commit();
        session.close();
    }

    public void update(String productName, long id){
        Product product = new Product();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        product = session.get(Product.class, id);
        product.setProductName(productName);
        transaction.commit();
        session.close();
    }

    public void delete(Long productId){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.get(Product.class, productId);
        session.delete(product);
        transaction.commit();
        session.close();
    }

    public Manufacturer getById(Long manufacturer_id){
        Session session = sessionFactory.openSession();
        Manufacturer manufacturer = session.get(Manufacturer.class, manufacturer_id);
        session.close();
        return manufacturer;
    }

    public static void main(String[] args) {
        ManufacturerDAO dao = new ManufacturerDAO();
        dao.create("Nestle");

    }
}
