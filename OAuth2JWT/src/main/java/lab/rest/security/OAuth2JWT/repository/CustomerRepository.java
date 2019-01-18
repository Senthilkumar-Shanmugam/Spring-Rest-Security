package lab.rest.security.OAuth2JWT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab.rest.security.OAuth2JWT.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
