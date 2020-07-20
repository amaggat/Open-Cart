package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productID;
    private int brandID;
    private String productName;
    private String description;
    private Date dateAdded;
    private Date dateModify;
    private int quantity;
    private double priceUnit;
    private URL productImage;
}
