package vn.com.vatekasia.dto;

import lombok.Data;
import vn.com.vatekasia.entity.Room;

import javax.persistence.Id;
import java.util.List;
@Data
public class BookRoomDTO {
    private List<Long> roomId;
}
