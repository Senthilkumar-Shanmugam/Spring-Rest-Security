package lab.rest.security.OAuth2JWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab.rest.security.OAuth2JWT.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
