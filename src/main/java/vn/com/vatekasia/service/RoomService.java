//package vn.com.vatekasia.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//import vn.com.vatekasia.dto.RoomDTO;
//import vn.com.vatekasia.dto.SearchBookRoomDTO;
//import vn.com.vatekasia.entity.Room;
//import vn.com.vatekasia.enumeration.SessonEnum;
//import vn.com.vatekasia.enumeration.StatusRoomEnum;
//import vn.com.vatekasia.enumeration.TypeRoomEnum;
//import vn.com.vatekasia.repository.RoomRepository;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class RoomService {
//    @Autowired
//    RoomRepository roomRepo;
//
//    public RoomDTO searchRoom(SearchBookRoomDTO searchBookRoomDTO) {
//        List<Room> rooms = searchBookRoomDTO.getRoomId().stream()
//                .map(aLong -> roomRepo.findById(aLong).get())
//                .collect(Collectors.toList());
//        Room room = new Room();
//        room.setId(0l);
//        room.setName("name");
//        room.setFloor("floor");
//        room.setTypeRoomEnum(TypeRoomEnum.vip);
//        room.setStatus(StatusRoomEnum.Vacancy);
//        room.setQuantity(0l);
//        room.setSeasons(SessonEnum.Autumn);
//
//        RoomDTO roomDTO = new RoomDTO();
//        roomDTO.setId(room.getId());
//        roomDTO.setTypeRoom(room.getTypeRoomEnum());
//        roomDTO.setStatus(room.getStatus());
//        roomDTO.setFloor(room.getFloor());
//        roomDTO.setName(room.getName());
//        roomDTO.setSeasons(room.getSeasons());
//        roomDTO.setQuantity(room.getQuantity());
//
//        List<Room> listRoom  = PageRequest.of(searchBookRoomDTO.getSize(), Sort.by(id));
//
//        List<Room> listRoom = roomRepo.find(searchBookRoomDTO.getPage());
//        return roomDTO;
//    }
//}
