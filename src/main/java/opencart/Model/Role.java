//package opencart.Model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
//@Entity
//@Table(name = "role")
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "roleId")
//    private Integer roleId;
//
////    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
////    private Set<CustomerRole> customerRoles;
//
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
//    private Set<Customer> customers;
//
//    private String name;
//
//}
