package vn.com.vatekasia.controller;

import java.util.List;

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

import vn.com.vatekasia.util.ListTypeServiceRoom;
import vn.com.vatekasia.entity.Room;
import vn.com.vatekasia.entity.Service;
import vn.com.vatekasia.entity.TypeServiceRoom;
import vn.com.vatekasia.repository.RoomRepository;
import vn.com.vatekasia.repository.ServiceReponsitory;
import vn.com.vatekasia.repository.TypeServiceRoomRepository;

@RestController
@RequestMapping("/api/tpye-service")
public class TypeServiceRoomControllerAPI {
	@Autowired
	TypeServiceRoomRepository typeServiceRepo;

	@Autowired
	RoomRepository roomRepo;

	@Autowired
	ServiceReponsitory serviceRepo;

	@PostMapping("/create")
	public TypeServiceRoom create(@RequestBody TypeServiceRoom typeService) {
		List<Room> rooms = roomRepo.findAll();
		List<Service> services = serviceRepo.findAll();
		typeServiceRepo.save(typeService);
		return typeService;

	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam(value = "id") Long id) {
		typeServiceRepo.deleteById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody TypeServiceRoom typeService) {
		TypeServiceRoom typeServices = typeServiceRepo.getById(typeService.getId());
		List<Room> rooms = roomRepo.findAll();
		List<Service> services = serviceRepo.findAll();
		;

		typeServices.setName(typeService.getName());
		typeServiceRepo.save(typeServices);
	}

	@PostMapping("/search")
	public ListTypeServiceRoom search(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "roomId", required = false) Long roomId,
			@RequestParam(name = "serviceId", required = false) Long serviceId,
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
		Page<TypeServiceRoom> pageTypeSerivce = null;
		if (name != null && !name.isEmpty()) {
			pageTypeSerivce = typeServiceRepo.searchAll("%" + name + "%", roomId, serviceId, pageable);

		} else {
			pageTypeSerivce = typeServiceRepo.findAll(pageable);
		}
		ListTypeServiceRoom listTypeService = new ListTypeServiceRoom();
		listTypeService.setListTypeService(pageTypeSerivce.toList());
		listTypeService.setTotalPage(pageTypeSerivce.getTotalPages());
		listTypeService.setSize(size);
		listTypeService.setPage(page);

		return listTypeService;
	}
}
