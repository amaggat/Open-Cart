package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order extends Entity {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    private String status;
    private Date orderDate;
    private Date requiredDate;
    private Date shippedDate;
}
