package opencart.Repository;

import java.util.List;

public interface RoleRepository {
    List<String> getRoleNames(Integer customerid);
}
