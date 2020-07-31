//package opencart.Service.ServiceImpl;
//
//import opencart.Model.Customer;
//
//import opencart.Repository.CustomerRepository;
//import opencart.Repository.RoleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {
//        Customer customer = this.customerRepository.findCustomerAccount(accountName);
//
//        if (customer == null) {
//            System.out.println("User not found! " + accountName);
//            throw new UsernameNotFoundException("Customer " + accountName + " was not found in the database");
//        }
//
//        System.out.println("Found User: " + customer);
//
//        // [ROLE_USER, ROLE_ADMIN,..]
//        List<String> roleNames = this.roleRepository.getRoleNames(customer.getCustomerId());
//
//        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//        if (roleNames != null) {
//            for (String role : roleNames) {
//                // ROLE_USER, ROLE_ADMIN,..
//                GrantedAuthority authority = new SimpleGrantedAuthority(role);
//                grantList.add(authority);
//            }
//        }
//
//        UserDetails userDetails = (UserDetails) new User(customer.getAccountName(), //
//                customer.getPassword(), grantList);
//
//        return userDetails;
//    }
//}
