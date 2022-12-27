package vn.com.vatekasia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import vn.com.vatekasia.entity.Combo;
import vn.com.vatekasia.repository.ComboRepository;
import vn.com.vatekasia.util.ListCombo;

@RestController
@RequestMapping("/api/combo")
public class ComboControllerAPI {
    @Autowired
    ComboRepository comboRepo;

    @PostMapping("/create")
    public Combo create(@RequestBody Combo combo) {
        comboRepo.save(combo);
        return combo;

    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(value = "id") Long id) {
        comboRepo.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Combo combo) {
        Combo combos = comboRepo.getById(combo.getId());
        ;

        combos.setName(combo.getName());
        comboRepo.save(combos);
    }

    @PostMapping("/search")
    public ListCombo search(@RequestParam(name = "name", required = false) String name,
                            @RequestParam(name = "id", required = false) Long id,
                            @RequestParam(name = "roomId", required = false) Long roomId,
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
        Page<Combo> pageCombo = null;
        if (roomId != null) {
            Page<Combo> comboPage = comboRepo.searchByRoom(roomId, pageable);
        } else if (name != null && !name.isEmpty()) {
            pageCombo = comboRepo.searchAll("%" + name + "%", pageable);

        } else {
            pageCombo = comboRepo.findAll(pageable);
        }
        ListCombo listCombo = new ListCombo();
        listCombo.setListCombo(pageCombo.toList());
        listCombo.setTotalPage(pageCombo.getTotalPages());
        listCombo.setSize(size);
        listCombo.setPage(page);

        return listCombo;
    }
}
