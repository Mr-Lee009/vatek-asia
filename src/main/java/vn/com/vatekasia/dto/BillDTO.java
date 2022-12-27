package vn.com.vatekasia.dto;

import lombok.Data;
import vn.com.vatekasia.entity.Customer;
import vn.com.vatekasia.entity.Room;
import vn.com.vatekasia.entity.User;

import java.util.Date;
import java.util.List;

@Data
public class BillDTO {
    private Long id;
    private String name;
    private Date buyDate;
    private Long totalPay;
    private Long totalPayment;
    private double price;
    private List<Room> listRoom;


}
