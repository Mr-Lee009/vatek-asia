package vn.com.vatekasia.util;

import java.util.Date;
import java.util.List;

import lombok.Data;
import vn.com.vatekasia.entity.Room;

@Data
public class ListRoom {
	private List<Room> listRoom;
	private int totalPage;
	private int page;
	private int size;
	private Date fromDate;
	private Date toDate;

}
