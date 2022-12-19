package vn.com.vatekasia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import vn.com.vatekasia.dto.ListBill;
import vn.com.vatekasia.entity.Bill;
import vn.com.vatekasia.entity.Customer;
import vn.com.vatekasia.entity.User;
import vn.com.vatekasia.repository.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
public class BillControllerAPI {
   @Autowired
    BillRepository billRepo;
    @Autowired
    UserRepository userRepo;
    @Autowired
    CustomerReponsitory customerRepo;

    @PostMapping("/create")
    public Bill create(@RequestBody Bill bill) {
        List<User> users = userRepo.findAll();
        List<Customer> customers = customerRepo.findAll();
        billRepo.save(bill);
        return bill;

    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam(value = "id") Long id) {
        billRepo.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Bill bill) {
        Bill bills = billRepo.getById(bill.getId());
        List<User> users = userRepo.findAll();
        List<Customer> customers = customerRepo.findAll();
        ;

        bills.setName(bill.getName());
        billRepo.save(bills);
    }

    @PostMapping("/search")
    public ListBill search(@RequestParam(name = "name", required = false) String name,
                           @RequestParam(name = "id", required = false) Long id,
                           @RequestParam(name = "userId", required = false) Long userId,
                           @RequestParam(name = "customerId", required = false) Long customerId,
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
        Page<Bill> pageBill = null;
        if (name != null && !name.isEmpty()) {
            pageBill = billRepo.searchAll("%" + name + "%", userId, customerId, pageable);

        } else {
            pageBill = billRepo.findAll(pageable);
        }
        ListBill listBill = new ListBill();
        listBill.setListBill(pageBill.toList());
        listBill.setTotalPage(pageBill.getTotalPages());
        listBill.setSize(size);
        listBill.setPage(page);

        return listBill;
    }
}
