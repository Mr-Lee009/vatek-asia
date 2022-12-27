package vn.com.vatekasia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.com.vatekasia.util.ListCustomer;
import vn.com.vatekasia.entity.Customer;
import vn.com.vatekasia.repository.CustomerReponsitory;

@RestController
@RequestMapping("/api/customer")
public class CustomerControllerAPI {
	@Autowired
	CustomerReponsitory customerRepo;

	@PostMapping("/create")
	public Customer create(@RequestBody Customer customer) {
		customerRepo.save(customer);
		return customer;

	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam(value = "id") Long id) {
		customerRepo.deleteById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Customer customer) {
		Customer customers = customerRepo.getById(customer.getId());
		;

		customers.setName(customer.getName());
		customerRepo.save(customers);
	}

	@PostMapping("/search")
	public ListCustomer search(@RequestParam(name = "name", required = false) String name,
							   @RequestParam(name = "id", required = false) Long id,
							   @RequestParam(name = "sortBy", required = false) Integer sortBy,
							   @RequestParam(name = "page", required = false) Integer page,
							   @RequestParam(name = "size", required = false) Integer size) {

		if (size == null)
			size = 3;// max records per page
		if (page == null)
			page = 0;// trang hien tai
		Sort sort = Sort.by("id").ascending();
		if (sortBy != null && sortBy.equals("name")) {
			sort = Sort.by("name").ascending();
		}

		Pageable pageable = PageRequest.of(page, size, sort);
		Page<Customer> pageCustomer = null;
		if (name != null && !name.isEmpty()) {
			pageCustomer = customerRepo.searchAll("%" + name + "%", pageable);

		} else {
			pageCustomer = customerRepo.findAll(pageable);
		}
		ListCustomer listCustomer = new ListCustomer();
		listCustomer.setListCustomer(pageCustomer.toList());
		listCustomer.setTotalPage(pageCustomer.getTotalPages());
		listCustomer.setSize(size);
		listCustomer.setPage(page);

		return listCustomer;
	}
}
