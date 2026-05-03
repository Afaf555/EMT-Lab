package mk.ukim.finki.wp.lab_emt.service;

import java.util.Optional;
import mk.ukim.finki.wp.lab_emt.model.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Optional<User> findByUsername(String username);

    User register(User user);

    User login(String username, String password);
}
