package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand extends Entity{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand", fetch = FetchType.LAZY)
    private Set<Product> products;

    private String brandName;
    private String description;
}
