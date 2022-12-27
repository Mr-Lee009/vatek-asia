package vn.com.vatekasia.util;

import java.util.List;

import lombok.Data;
import vn.com.vatekasia.entity.Service;

@Data
public class ListService {
	private List<Service> listService;
	private int page;
	private int size;
	private int totalPage;
}
