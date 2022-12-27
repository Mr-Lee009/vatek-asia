package vn.com.vatekasia.util;

import java.util.List;

import lombok.Data;
import vn.com.vatekasia.entity.User;

@Data
public class ListUser {
	private List<User> listUser;
	private int page;
	private int size;
	private int totalPage;
}
