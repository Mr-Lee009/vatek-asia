package vn.com.vatekasia.dto;

import lombok.Data;
import vn.com.vatekasia.entity.Bill;
import vn.com.vatekasia.entity.Customer;
import vn.com.vatekasia.entity.User;

import java.util.List;
@Data
public class BookRoomDTO {
    private List<Long> roomId;
    private User user;
    private Bill bill;
    private Customer customer;
}
