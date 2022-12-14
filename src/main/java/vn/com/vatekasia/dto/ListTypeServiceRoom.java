package vn.com.vatekasia.dto;

import java.util.List;

import lombok.Data;
import vn.com.vatekasia.entity.TypeServiceRoom;

@Data
public class ListTypeServiceRoom {
	private List<TypeServiceRoom> listTypeService;
	private int totalPage;
	private int size;
	private int page;
}
