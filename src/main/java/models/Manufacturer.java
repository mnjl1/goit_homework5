package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manufacturerid")
    private Long id;

    @Column(name = "manufacturername")
    private String manufacturerName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacturer")
    Set<Product> products = new HashSet <Product>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Set <Product> getProducts() {
        return products;
    }

    public void setProducts(Set <Product> products) {
        this.products = products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", products=" + products +
                '}';
    }
}
