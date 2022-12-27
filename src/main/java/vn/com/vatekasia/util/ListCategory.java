package vn.com.vatekasia.util;

import java.util.List;

import lombok.Data;
import vn.com.vatekasia.entity.Category;

@Data
public class ListCategory {
	private List<Category> listCategory;
	private int totalPage;
	private int size;
	private int page;
}
