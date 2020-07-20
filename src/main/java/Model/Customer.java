package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Entity{
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String accountName;
    private String password;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
}
