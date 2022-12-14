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

import vn.com.vatekasia.dto.ListRoom;
import vn.com.vatekasia.entity.Room;
import vn.com.vatekasia.repository.RoomRepository;
import vn.com.vatekasia.repository.ServiceReponsitory;

@RestController
@RequestMapping("/api/room")
public class RoomControllerAPI {
	@Autowired
	RoomRepository roomRepo;
	@Autowired
	ServiceReponsitory serviceRepo;

	@PostMapping("/create")
	public Room create(@RequestBody Room room) {
		roomRepo.save(room);
		return room;

	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam(value = "id") Long id) {
		roomRepo.deleteById(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody Room room) {
		Room rooms = roomRepo.getById(room.getId());
		;

		rooms.setName(room.getName());
		roomRepo.save(rooms);
	}

	@PostMapping("/search")
	public ListRoom search(@RequestParam(name = "name", required = false) String name,
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
		Page<Room> pageRoom = null;
		if (name != null && !name.isEmpty()) {
			pageRoom = roomRepo.searchAll("%" + name + "%", pageable);

		} else {
			pageRoom = roomRepo.findAll(pageable);
		}
		ListRoom listRoom = new ListRoom();
		listRoom.setListRoom(pageRoom.toList());
		listRoom.setTotalPage(pageRoom.getTotalPages());
		listRoom.setSize(size);
		listRoom.setPage(page);

		return listRoom;
	}
}
