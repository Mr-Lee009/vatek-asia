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

import vn.com.vatekasia.util.ListService;
import vn.com.vatekasia.entity.Service;
import vn.com.vatekasia.repository.ServiceReponsitory;

@RestController
@RequestMapping("/api/service")
public class ServiceControllerAPI {
	@Autowired
	ServiceReponsitory serviceRepo;

	@PostMapping("/create")
	public Service create(@RequestBody Service service) {
		serviceRepo.save(service);
		return service;

	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam(value = "id") Long id) {
		serviceRepo.deleteById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Service service) {
		Service services = serviceRepo.getById(service.getId());
		;

		services.setName(service.getName());
		serviceRepo.save(services);
	}

	@PostMapping("/search")
	public ListService search(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "id", required = false) Integer id,
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
		Page<Service> pageSerivce = null;
		if (name != null && !name.isEmpty()) {
			pageSerivce = serviceRepo.searchAll("%" + name + "%", pageable);

		} else {
			pageSerivce = serviceRepo.findAll(pageable);
		}
		ListService listService = new ListService();
		listService.setListService(pageSerivce.toList());
		listService.setTotalPage(pageSerivce.getTotalPages());
		listService.setSize(size);
		listService.setPage(page);

		return listService;
	}
}
