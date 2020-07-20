package Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Entity
public class Customer extends Entity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @Column(name="accountName")
    @NotEmpty
    private String accountName;

    @Column(name="password")
    @NotEmpty
    private String password;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
}
