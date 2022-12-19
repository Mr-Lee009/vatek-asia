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

import vn.com.vatekasia.dto.ListCategory;
import vn.com.vatekasia.entity.Category;
import vn.com.vatekasia.repository.CategoryRepository;

@RestController
@RequestMapping("/api/category")
public class CategoryControllerAPI {
	@Autowired
	CategoryRepository categoryRepo;

	@PostMapping("/create")
	public Category create(@RequestBody Category category) {
		categoryRepo.save(category);
		return category;

	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam(value = "id") Long id) {
		categoryRepo.deleteById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Category category) {
		Category categorys = categoryRepo.getById(category.getId());
		;

		categorys.setName(category.getName());
		categoryRepo.save(categorys);
	}

	@PostMapping("/search")
	public ListCategory search(@RequestParam(name = "name", required = false) String name,
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
		Page<Category> pageCategory = null;
		if (name != null && !name.isEmpty()) {
			pageCategory = categoryRepo.searchAll("%" + name + "%", pageable);

		} else {
			pageCategory = categoryRepo.findAll(pageable);
		}
		ListCategory listCategory = new ListCategory();
		listCategory.setListCategory(pageCategory.toList());
		listCategory.setTotalPage(pageCategory.getTotalPages());
		listCategory.setSize(size);
		listCategory.setPage(page);
		return listCategory;
	}
}
