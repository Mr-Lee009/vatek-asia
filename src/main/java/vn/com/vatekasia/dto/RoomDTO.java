package vn.com.vatekasia.dto;

import lombok.Data;
import vn.com.vatekasia.enumeration.SessonEnum;
import vn.com.vatekasia.enumeration.StatusRoomEnum;
import vn.com.vatekasia.enumeration.TypeRoomEnum;

import java.util.Date;

@Data
public class RoomDTO {
    private Long id;
    private String name;
    private StatusRoomEnum status;
    private SessonEnum seasons;
    private TypeRoomEnum typeRoom;
    private Long quantity;
    private String floor;
    private Date time;
}
