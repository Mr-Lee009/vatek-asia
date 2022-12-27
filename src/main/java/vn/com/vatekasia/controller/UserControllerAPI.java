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

import vn.com.vatekasia.util.ListUser;
import vn.com.vatekasia.entity.User;
import vn.com.vatekasia.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserControllerAPI {
	@Autowired
	UserRepository userRepo;

	@PostMapping("/create")
	public User create(@RequestBody User user) {
		userRepo.save(user);
		return user;
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam(value = "id") Long id) {
		userRepo.deleteById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody User user) {
		User users = userRepo.getById(user.getClientId());
		;

		users.setUsername(user.getUsername());
		userRepo.save(users);
	}

	@PostMapping("/search")
	public ListUser search(@RequestParam(name = "name", required = false) String name,
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
		Page<User> pageUser = null;
		if (name != null && !name.isEmpty()) {
			pageUser = userRepo.searchAll("%" + name + "%", pageable);

		} else {
			pageUser = userRepo.findAll(pageable);
		}
		ListUser listUser = new ListUser();
		listUser.setListUser(pageUser.toList());
		listUser.setTotalPage(pageUser.getTotalPages());
		listUser.setSize(size);
		listUser.setPage(page);

		return listUser;
	}
}
