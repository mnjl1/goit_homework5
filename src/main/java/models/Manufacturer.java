package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manufacturer_id")
    private Long id;

    @Column(name = "manufacture_name")
    private String manufacturerName;

    @OneToMany(fetch = FetchType.LAZY)
    Set<Product> products;

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

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", products=" + products +
                '}';
    }
}
