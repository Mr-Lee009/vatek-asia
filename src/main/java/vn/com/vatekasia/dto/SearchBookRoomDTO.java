package vn.com.vatekasia.dto;

import lombok.Data;
import org.hibernate.query.Query;
import vn.com.vatekasia.entity.Customer;

import java.util.List;
@Data
public class SearchBookRoomDTO {

    private List<Long> roomId;
    private Customer customer;

    private int page;
    private int size;
}
