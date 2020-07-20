package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category-product", joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private Set<Category> categories;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "wishlist-product", joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "wishlistId"))
    private Set<WishList> wishLists;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cart-product", joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "cartId"))
    private Set<Cart> carts;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product", fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;

    @Column(name = "productName")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "dateAdded")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate dateAdded;

    @Column(name = "dateModify")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate dateModify;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "priceunit")
    private double price;
}
