package lab.rest.security.OAuth2JWT.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lab.rest.security.OAuth2JWT.domain.Customer;
import lab.rest.security.OAuth2JWT.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Iterable<Customer> getCustomers() {

		// -- if there is no data in the database, populate one for initial testing
		if (customerRepository.count() == 0) {
			Customer customer = new Customer();
			customer.setName("Right Inc.,");
			customer.setAddress("100 Right way");
			customer.setPhone("1-800-111-2222");
			customer.setContact("CEO");
			customerRepository.save(customer);
		}

		return customerRepository.findAll();
	}

	
	public Customer getCustomer(long customerId) {
		 Optional<Customer> cus = customerRepository.findById(customerId);
	
		 if(cus.isPresent())
			 return cus.get();
		 else
			 return null;
	}
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}	
	
	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
}
