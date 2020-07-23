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
@Table(name = "order")
public class Order extends BaseEntity {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @Column(name = "status")
    private String status;

    @Column(name = "orderDate")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate orderDate;

    @Column(name = "requiredDate")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate requiredDate;

    @Column(name = "shippedDate")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate shippedDate;
}