package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart")
public class Cart extends BaseEntity{
    @OneToOne
    @PrimaryKeyJoinColumn(name = "customerId", foreignKey = @ForeignKey(name = "CART_FK_CUSTOMER"))
    private Customer customer;

    @ManyToMany
    @JoinTable(name = "cart-product", joinColumns = @JoinColumn(name = "customerId"),
            inverseJoinColumns = @JoinColumn(name = "productId"))
    private Set<Product> products;

    @Column(name = "dateAdded")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate dateAdded;

    @Column(name = "quantity")
    private int quantity;
}
