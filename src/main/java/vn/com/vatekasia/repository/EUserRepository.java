package vn.com.vatekasia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.vatekasia.entity.EUser;

public interface EUserRepository extends JpaRepository<EUser, Long> {
    EUser findEUserByUsername(String username);
    EUser findEUserByUsernameOrEmail(String username, String email);
}
