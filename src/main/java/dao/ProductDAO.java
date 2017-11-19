package dao;

import models.Manufacturer;
import models.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class ProductDAO {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void create(String productName, Long manufacturerId, BigDecimal price) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(new BigDecimal(String.valueOf(price)));
        Manufacturer manufacturer = session.get(Manufacturer.class, manufacturerId);
        //manufacturer.addProduct(product);
        product.setManufacturer(manufacturer);
        session.save(manufacturer);
        session.save(product);
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

    public Long getById(Long productId){
        Session session = sessionFactory.openSession();
        Manufacturer manufacturer = session.get(Manufacturer.class, productId);
        session.close();
        return productId;
    }

    public List<Product> getAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.getSession().createQuery("from Product");
        List<Product> productList =query.getResultList();
        session.close();
        return productList;
    }
}
