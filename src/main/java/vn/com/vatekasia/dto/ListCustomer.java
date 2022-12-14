package vn.com.vatekasia.dto;

import java.util.List;

import lombok.Data;
import vn.com.vatekasia.entity.Customer;

@Data
public class ListCustomer {
	private List<Customer> listCustomer;
	private int totalPage;
	private int page;
	private int size;
}
