import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private Set<String> roles;

    public boolean hasRole(String roleName) {
        return roles.contains(roleName);
    }

    public boolean hasAnyRole(Collection<String> roles) {
        for (String role : roles) {
            if (roles.contains(role)) {
                return true;
            }
        }
        return false;
    }
}
