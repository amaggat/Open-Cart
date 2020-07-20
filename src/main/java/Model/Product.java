package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends Entity{
    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category-product", joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private Set<Category> categories;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product", fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;

    private String name;
    private String description;
    private Date dateAdded;
    private Date dateModify;
    private int quantity;
    private double price;


    private int brandID;
}
