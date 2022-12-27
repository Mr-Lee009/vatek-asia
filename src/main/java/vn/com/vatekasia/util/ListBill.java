package vn.com.vatekasia.util;

import lombok.Data;
import vn.com.vatekasia.entity.Bill;

import java.util.List;

@Data
public class ListBill {
    private List<Bill> listBill;
    private int totalPage;
    private int size;
    private int page;

}
