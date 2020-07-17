package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productID;
    private String name;
    private String description;
    private Date dateAdded;
    private Date dateModify;
    private int quantity;
    private double price;
    private int brandID;
}
