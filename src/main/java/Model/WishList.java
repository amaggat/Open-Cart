package Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wishlist")
public class WishList extends BaseEntity{

    @OneToOne
    @PrimaryKeyJoinColumn(name = "customerId", foreignKey = @ForeignKey(name = "WISHLIST_FK_CUSTOMER"))
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "wishlist-product", joinColumns = @JoinColumn(name = "customerId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    private Set<Product> products;

    @Column(name = "status")
    private String status;
}
