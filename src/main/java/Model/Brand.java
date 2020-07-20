package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Brand extends Entity{
    private int brandID;
    private String name;
    private String description;
    private URL brandImage;
}
