package Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WishList {
    @Id
    @GeneratedValue(generator = GenerationType.AUTO)
    private int customerId;

    @Id
    @GeneratedValue(generator = GenerationType.AUTO)
    private int productId;

    private String status;
}
