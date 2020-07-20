package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderdetail")
public class OrderDetail {

    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;
}