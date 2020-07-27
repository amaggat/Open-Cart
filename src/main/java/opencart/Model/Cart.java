package opencart.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDate;
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



    //27/7/20
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "carts")
    private Set<Product> products;





    @Column(name = "dateAdded")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate dateAdded;

    @Column(name = "quantity")
    private int quantity;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}