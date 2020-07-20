package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import java.net.URL;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends Model.Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;

    @OneToMany
    @JoinColumn(name = "brandID")
    private int brandID;
    private String productName;
    private String description;
    private Date dateAdded;
    private Date dateModify;
    private int quantity;
    private double priceUnit;
    private URL productImage;
}
