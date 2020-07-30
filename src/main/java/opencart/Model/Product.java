/*
25/7/20
 */
package opencart.Model;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityScan(basePackages = {"opencart.Model"})
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "brandid")
    private Brand brand;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category-product", joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "catetogoryId"))
    private Set<Category> categories;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "wishlist-product", joinColumns = @JoinColumn(name = "productid"),
            inverseJoinColumns = @JoinColumn(name = "customerid"))
    private Set<WishList> wishLists;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cart-product", joinColumns = @JoinColumn(name = "productid"),
            inverseJoinColumns = @JoinColumn(name = "customerid"))
    private Set<Cart> carts;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product", fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;


    @Column(name = "productname")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "dateadded")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date dateAdded;

    @Column(name = "datemodified")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date dateModified;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "priceunit")
    private double price;

}